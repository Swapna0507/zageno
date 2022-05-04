package basecalsses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageBase extends DriverBase {
    //public WebDriver driver;


    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public PageBase() {
        driverAvailable = false;

    }

    /****Clicks on the Element
     *
     * @param element  the element to click on
     */
    protected void clickOn(WebElement element) {
        element.click();
    }

    /**
     * Uses Selenium's .sendKeys() to write the provided text to the provided element
     *
     * @param element the element to which to send the text
     * @param text    the text to send to the element
     */
    protected void writeTextTo(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Sends the driver to the URL
     */
    protected void goToPage(String url) {
        driver.get(url);
        waitForDocumentReadiness();

    }

    /**
     * Waits until the document returns a readyState of complete
     **/

    protected void waitForDocumentReadiness() {
        wait.until(WebDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }


    protected void waitForElement(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    protected void clearTheText(WebElement element) {
        element.clear();
    }

    protected void scrollToTheElement(WebElement element) {

        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    protected void selectFromDropDown(WebElement element,String value){
        Select select =new Select(element);
        select.selectByValue(value);
    }

    protected void hoverOnToTheElement(WebElement element){
        Actions action= new Actions(driver);
        action.moveToElement(element);

    }

    protected WebElement createWebElement(String element){

        return driver.findElement(By.xpath(element));

    }
}
