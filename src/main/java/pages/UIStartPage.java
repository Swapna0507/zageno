package pages;


import basecalsses.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UIStartPage extends PageBase {

 //***Elements*****
 @FindBy(xpath="//a[@href='/accounts/login/']")
 WebElement loginBtn;

 public UIStartPage(WebDriver driver){
     super(driver);
     PageFactory.initElements(driver,this);
 }


 //***Methods*****

    public void clickOnLoginBtn() throws InterruptedException {
//     waitForElement(loginBtn);
        String javascript = "arguments[0].click()";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript, loginBtn);

      //  Thread.sleep(3000);
     //loginBtn.click();
    }





}
