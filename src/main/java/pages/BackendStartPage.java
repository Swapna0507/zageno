package pages;

import basecalsses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackendStartPage extends PageBase {
    @FindBy(xpath="//a[@class='button']")
    WebElement loginWithOktaBtn;






    public BackendStartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickLoginWithOktaBtn(){
        waitForDocumentReadiness();
        loginWithOktaBtn.click();
    }


}
