package pages;

import basecalsses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckOutPage extends PageBase {

    @FindBy(xpath="//input[@name='po_number']")
    WebElement poNumberTextBox;

    @FindBy(xpath="//select[@id='id_cost_center']\n")
    WebElement costCenterDropdown;

    @FindBy(xpath="//input[@name='checkout' and @type='submit']")
    WebElement checkOutSubmitBtn;

    @FindBy(xpath="//input[@type='submit' and @value='Agree & Purchase']")
    WebElement agreeAndPurchaseBtn;










    public CheckOutPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterThePONumber(String poNumber){
        poNumberTextBox.sendKeys(poNumber);
    }

    public void isCostCenterSelected(){

        Assert.assertTrue(!costCenterDropdown.getText().isEmpty(),"CostCenter is selected");

    }

    public void clickCheckOutSubmitBtn(){
        checkOutSubmitBtn.click();
    }

    public void clickAgreeAndPurchaseBtn(){
        agreeAndPurchaseBtn.click();
    }

}
