import basecalsses.DriverBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilclasses.ConstantUtil;
import utilclasses.PropertiesUtil;

public class ValidateTheProductOrderPlacedTest extends DriverBase {
    LoginPage loginpage;
    UIStartPage startpage;
    HomePage homepage;
    CartPage cartpage;
    CheckOutPage checkoutpage;
    DonePage donepage;
    BackendStartPage backendStartPage;
    BackendHomePage backendhomepage;
    OrdersPage orderspage;




   @BeforeClass
    public void beforeClass(){
       orderspage= new OrdersPage(driver);
       loginpage=new LoginPage(driver);
        startpage=new UIStartPage(driver);
        homepage=new HomePage(driver);
        cartpage= new CartPage(driver);
        checkoutpage=new CheckOutPage(driver);
        donepage= new DonePage(driver);
        backendStartPage=new BackendStartPage(driver);
        backendhomepage= new BackendHomePage(driver);

    }


    @Test(description = "Adding the specific product to the cart",priority = 1)
    @Parameters( {"productName","quantity","poNumber"})
    public void addingTheProductToTheCart(String productName,String quantity,String poNumber) throws Exception {

       homepage.clickMarketPlaceMenuLink();
        homepage.clickOnTheViewAndBuyLinkOfTheProduct(productName);
        cartpage.selectingTheQuantityOfTheProduct(quantity);
        cartpage.clickAddToCartBtn();
        System.out.println("The Item has been added to The Cart");
        cartpage.hoverToTheCart();
        cartpage.clickTheReviewCartBtn();
        checkoutpage.isCostCenterSelected();
        checkoutpage.enterThePONumber(poNumber);
        System.out.println(poNumber);
        checkoutpage.clickCheckOutSubmitBtn();
        checkoutpage.clickAgreeAndPurchaseBtn();
        String orderID=donepage.getTheOrderId();
        System.out.println(donepage.getTheOrderId());
        driver.navigate().to("https://nj-coding-challenge-admin.zageno.com/");
        backendStartPage.clickLoginWithOktaBtn();
        loginToBackend();
        backendhomepage.verifyingBackendHomePageHasOpened();
        backendhomepage.clickOnOrdersLink();
        orderspage.searchTheOrderedProduct().sendKeys(orderID);
        orderspage.clickSearchBtn();
        orderspage.clickProductLink();
        System.out.println(orderspage.getTextValueOfPoNumber());
        Assert.assertEquals(orderspage.getTextValueOfPoNumber(),poNumber,"the PO Number is the same as the one entered at Checkout");











    }

    /*@AfterTest(description = "Closes the browser")
    public void closeTheBrowser(){driver.quit();}
*/


}
