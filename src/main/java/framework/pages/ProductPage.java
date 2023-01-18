package framework.pages;

import framework.pages.blocks.BaseMenuBlock;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    private BaseMenuBlock baseMenuBlock = new BaseMenuBlock();
    @FindBy(xpath = "//div[@class='product-buy__price']")
    private WebElement priceProduct;
    @FindBy(xpath = "//div[contains(text(),'Гарантия:')]")
    private WebElement warranty;
    @FindBy (xpath = "//span[contains(text(),'Доп. гарантия')]/..")
    private WebElement additionalWarranty;
    @FindBy(xpath = "//span[@class='product-warranty__price' and contains(text(),'1')]")
    private WebElement priceWarranty;
    @FindBy(xpath = "//div[@class='product-buy product-buy_one-line']/..//button[contains(@class,'buy-btn')]")
    private WebElement buttonBuy;

    public int getPriceProduct(){

        return Integer.parseInt(waitUntilElementToBeVisible(priceProduct).getText().replaceAll("[^0-9]",""));
    }
    public ProductPage clickWarranty(){
        waitUntilElementToBeClicable(warranty).click();
        waitUntilElementToBeClicable(additionalWarranty).click();
        return this;
    }
    public int getPriceWarranty(){
        return Integer.parseInt(waitUntilElementToBeVisible(priceWarranty).getText().replaceAll("[^0-9]",""));
    }
    public ProductPage clickBuy(){
        waitUntilElementToBeClicable(buttonBuy).click();
        return this;
    }
    public BaseMenuBlock getBaseMenuBlock() {
        return baseMenuBlock;
    }




}
