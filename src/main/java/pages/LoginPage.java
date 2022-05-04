package pages;

import basecalsses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilclasses.ConstantUtil;
import utilclasses.PropertiesUtil;

public class LoginPage extends PageBase {

    //********* LoginPage Web Elements *****************

   @FindBy(xpath="//input[@id=\"idp-discovery-username\"]")
   WebElement emailTxtBox;

    @FindBy(xpath="//input[@id=\"idp-discovery-submit\"]")
    WebElement nextBtn;

    @FindBy(xpath=" //input[@id=\"okta-signin-password\"]")
    WebElement passwordTxtBox;

    @FindBy(xpath="//input[@id=\"okta-signin-submit\"]")
    WebElement loginBtn;




    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    //  **************** Methods to interact with the LoginPage web elements ***********************

    public void login(String email , String password) throws Exception {
        provideEmailField(email);
        providePasswordField(password);
    }


    public void provideEmailField(String email){
        waitForElement(emailTxtBox);
        clearTheText(emailTxtBox);
        clickOn(emailTxtBox);
        writeTextTo(emailTxtBox,email);
        clickOn(nextBtn);
    }

    public void providePasswordField(String Password){
        waitForElement(passwordTxtBox);
        clearTheText(passwordTxtBox);
        clickOn(passwordTxtBox);
        writeTextTo(passwordTxtBox,Password);
        clickOn(loginBtn);

    }



}
