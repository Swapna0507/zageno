package pages;

import basecalsses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends PageBase {
    @FindBy(xpath="//a[text()='Marketplace ']")
    WebElement marketplaceMenuLink;

   @FindAll(@FindBy(xpath="//a[@class='paragraph paragraph--medium-bold product__name']"))
   List<WebElement> productNameList;

   @FindAll(@FindBy(xpath="//div[@class='btn btn--slim  product__cta-buy']"))
    List<WebElement> viewAndBuyLinkList;

    @FindBy(xpath="//*[@id='Pointer_Right']")
    WebElement paginationRightArrowBtn;




    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickMarketPlaceMenuLink(){
        waitForDocumentReadiness();
        waitForElement(marketplaceMenuLink);
       clickOn(marketplaceMenuLink);
    }


    public void clickOnTheViewAndBuyLinkOfTheProduct(String productName) throws InterruptedException {
        int productListSize=productNameList.size();
        for(int i=0;i<productListSize;i++){
            if(productNameList.get(i).getText().equals(productName))
            {
                viewAndBuyLinkList.get(i).click();
                break;
            }
            else
            {
                waitForDocumentReadiness();
                Thread.sleep(3000);
                scrollToTheElement(paginationRightArrowBtn);
                System.out.println("scrolled");
                paginationRightArrowBtn.click();
            }
        }
    }


}
