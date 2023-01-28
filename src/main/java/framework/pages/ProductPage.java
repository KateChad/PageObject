package framework.pages;

import framework.object.Product;
import framework.pages.blocks.BaseMenuBlock;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    private BaseMenuBlock baseMenuBlock = new BaseMenuBlock();
    @FindBy(xpath = "//div[@class ='product-card-top product-card-top_full']")
    private WebElement cardOfProduct;
    @FindBy(xpath = "//div[@class='product-buy__price']")
    private WebElement priceProduct;
    @FindBy(xpath = "//div[contains(text(),'Гарантия:')]")
    private WebElement warranty;
    @FindBy(xpath = "//div[@class ='product-buy__sub']")
    private WebElement changesPrice;
    @FindBy(xpath = "//span[contains(text(),'Доп. гарантия')]/..")
    private WebElement additionalWarranty;
    @FindBy(xpath = "//span[@class='product-warranty__price' and contains(text(),'1')]")
    private WebElement priceWarranty;
    @FindBy(xpath = "//div[contains(@class,'buy_one-line')]/..//button[contains(@class,'buy-btn')]")
    private WebElement buttonBuy;
    @FindBy(xpath = "//button[contains(@class, 'button-ui_passive-done')]")
    private WebElement buttonInBasket;


    public ProductPage checkCardOfProduct() {
        Assertions.assertTrue(cardOfProduct.isDisplayed(), "Страничка продуктов не прогрузилась");
        return this;
    }


    public ProductPage getPriceProduct(Product product) {
        product.setPriceProduct(Integer.parseInt(waitUntilElementToBeVisible(priceProduct).getText()
                .replaceAll("[^0-9]", "")));
        return this;
    }

    public ProductPage clickWarranty() {
        waitUntilElementToBeClicable(warranty).click();
        waitUntilElementToBeClicable(additionalWarranty).click();
        return this;
    }

    public ProductPage changesPrice() {
        Assertions.assertEquals("цена изменена", changesPrice.getText(),
                "Цена после выбора гарантии не изменилась");
        return this;
    }

    public ProductPage getPriceWarranty(Product product) {
        product.setPriceWarranty(Integer.parseInt(waitUntilElementToBeVisible(priceWarranty).getText()
                .replaceAll("[^0-9]", "")));
        return this;
    }

    public ProductPage clickBuy() {
        waitUntilElementToBeClicable(buttonBuy).click();
        return this;
    }

    public ProductPage checkClickBuy() {
        Assertions.assertTrue(buttonInBasket.isDisplayed(), "Страничка продуктов не прогрузилась");
        return this;
    }

    public BaseMenuBlock getBaseMenuBlock() {
        return baseMenuBlock;
    }


}
