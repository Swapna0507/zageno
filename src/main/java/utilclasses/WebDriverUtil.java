package utilclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class WebDriverUtil {
    private WebDriver driver;
    private WebDriverWait wait;

   private final Path webDriverToolsFolder= Paths.get(System.getProperty("user.dir"), "tools", "webdrivers");

   private final String chromeDriverFileName="chromedriver.exe";
   private final String chromeDriverFilePath= Paths.get(webDriverToolsFolder.toString(),chromeDriverFileName).toString();


   public WebDriver createWebDriver(String browsername){
       WebDriver driver = null;
       browsername=browsername.toLowerCase();
       if (browsername.equals("chrome")){
           System.setProperty("webdriver.chrome.driver",chromeDriverFilePath);
           driver=new ChromeDriver();
       }
       else {
        System.out.println("Set the "+browsername+ "driver First ");
       }

       wait=new WebDriverWait(driver,10);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
   return driver;
   }

}
