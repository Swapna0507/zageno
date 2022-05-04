package pages;

import basecalsses.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends PageBase {

    @FindBy(xpath="//select[@name='quantity-select']")
    WebElement selectQuantity;

    @FindBy(xpath="//button[@name='add_cart']")
    WebElement addToCartBtn;

    @FindBy(xpath="//a[@href='/cart']")
    WebElement cartLink;

    @FindBy(xpath="//a[@class='btn btn--block ']")
    WebElement reviewCartBtn;


    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void selectingTheQuantityOfTheProduct(String value){
        selectFromDropDown(selectQuantity,value);
    }

    public void clickAddToCartBtn(){
        addToCartBtn.click();
    }

    public void hoverToTheCart(){
        hoverOnToTheElement(cartLink);
    }

    public void clickTheReviewCartBtn(){
        waitForElement(reviewCartBtn);
        reviewCartBtn.click();
    }

}
