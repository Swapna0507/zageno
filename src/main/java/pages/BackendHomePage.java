package pages;

import basecalsses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BackendHomePage extends PageBase {
    @FindBy(xpath=" //a[text()='Zageno Admin for United States']")
    WebElement zagenoAdminForUnitedStates;

    @FindBy(xpath="//a[@href='/ordering/order/' and text()='Orders']")
    WebElement orders;


    public BackendHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void verifyingBackendHomePageHasOpened(){
        waitForElement(zagenoAdminForUnitedStates);
        Assert.assertEquals(zagenoAdminForUnitedStates.getText(),"Zageno Admin for United States");
    }

    public void clickOnOrdersLink(){
        scrollToTheElement(orders);
        orders.click();
    }


    }


