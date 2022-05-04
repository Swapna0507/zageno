package basecalsses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LoginPage;
import pages.UIStartPage;
import utilclasses.ConstantUtil;
import utilclasses.PropertiesUtil;
import utilclasses.WebDriverUtil;

public class DriverBase  {
    public WebDriver driver;
    public String frontEndAppURL;
    public String backendAppURL;
    LoginPage loginPage;
    UIStartPage uiStartpage;
    WebDriverWait wait;
    boolean driverAvailable;
    String email;
    String password;

   /* public DriverBase(WebDriver driver) {
        this.driver=driver;
        wait=new WebDriverWait(driver,15);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
*/


    @BeforeClass
    @Parameters({"browserName","frontend","browserVersion","platformName"})
    public void   driverSetUp(String browserName,String frontend, @Optional String browserVersion,@Optional String platformName) throws Exception {

        driver = new WebDriverUtil().createWebDriver(browserName);
        driver.get(setFrontEndAppURL(frontend));
        loginPage = new LoginPage(driver);
        email=PropertiesUtil.getValueFromThePropertiesFile(ConstantUtil.urlPropertyFile,"username");
        password= PropertiesUtil.getValueFromThePropertiesFile(ConstantUtil.urlPropertyFile,"password");
        uiStartpage=new UIStartPage(driver);
        uiStartpage.clickOnLoginBtn();
        loginPage.login(email,password);



    }

    public String setFrontEndAppURL(String frontend) throws Exception {

        try {
            frontEndAppURL = PropertiesUtil.getValueFromThePropertiesFile(ConstantUtil.urlPropertyFile, frontend.toLowerCase());
        }catch(Exception e) {
            throw new Exception(ConstantUtil.urlPropertyFile+" file does not exists or "+frontend+"is not present in the property file");
        }

        return frontEndAppURL;
    }

    public String setBackEndAppURL(String backend) throws Exception {

        try {
            backendAppURL = PropertiesUtil.getValueFromThePropertiesFile(ConstantUtil.urlPropertyFile, backend.toLowerCase());
        }catch(Exception e) {
            throw new Exception(ConstantUtil.urlPropertyFile+" file does not exists or "+backend+"is not present in the property file");
        }

        return backendAppURL;
    }


    public  void loginToBackend() throws Exception {
        loginPage.login(email,password);

    }
    @AfterClass
    public void closeDriver(){
        driver.quit();
    }










}
