package pages;

import basecalsses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DonePage extends PageBase {

    @FindBy(xpath="//div[@class='group-card__item ']/span")
    WebElement orderId;



    public DonePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getTheOrderId(){
        String orderID=orderId.getText();
        return orderID;
    }


}
