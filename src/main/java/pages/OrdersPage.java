package pages;

import basecalsses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrdersPage extends PageBase {

    DonePage donepage= new DonePage(driver);

    @FindBy(xpath=" //input[@id='searchbar']")
    WebElement searchBar;

    @FindBy(xpath="//input[@type ='submit' and @value='Search']")
    WebElement searchBtn;

    @FindBy(xpath=" //a[contains(@href,'/ordering/order/US-')]")
    WebElement productLink;

    @FindBy(xpath="//input[@name='po_number' and @type='text']")
    WebElement poNumberText;


    public OrdersPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement searchTheOrderedProduct() {
    return searchBar;
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }

    public void clickProductLink(){
        productLink.click();
    }

    public String getTextValueOfPoNumber(){
        return poNumberText.getAttribute("value");
    }



}
