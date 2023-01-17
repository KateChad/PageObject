package framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{
    @FindBy(xpath = "//div[@data-cart-product-id='440a4d81-49b5-422b-ae0c-fd4626365d10']//../div[contains(@class,'checked')]")
    private WebElement warrantyIphone;
    @FindBy(xpath = "//div[@data-cart-product-id='440a4d81-49b5-422b-ae0c-fd4626365d10']//../span[@class='price__current']")
    private WebElement priceProduct;
    @FindBy(xpath = "//div[@data-cart-product-id='0f112ff0-4d35-4b72-a8bd-ec4e5874bf0f']//../span[@class='price__current']")
    private WebElement priceProduct2;
    @FindBy(xpath = "//div[@class='cart-tab-total-amount']//../span[@class='price__current']")
    private WebElement sumPrice;
    @FindBy(xpath = "//div[@data-cart-product-id='0f112ff0-4d35-4b72-a8bd-ec4e5874bf0f']//../p[@class='remove-button__title']")
    private WebElement deleteProduct2;
    @FindBy(xpath = "//div[@data-cart-product-id='440a4d81-49b5-422b-ae0c-fd4626365d10']//../i[@class='count-buttons__icon count-buttons__icon-plus']")
    private WebElement plusCountProduct;
    @FindBy(xpath = "//span[@class='restore-last-removed']")
    private WebElement returnProduct;

    public void checkWarranty(){
        Assertions.assertEquals("+ 12  мес.",warrantyIphone.getText(), "Доп.гарантия не выбрана");
    }
    public int  getPriceProduct(){
        return Integer.parseInt(priceProduct.getText().replaceAll("[^0-9]",""));
    }
    public int  getPriceProduct2(){
        return Integer.parseInt(priceProduct2.getText().replaceAll("[^0-9]",""));
    }
    public int  getBasketPrice(){
        return Integer.parseInt(sumPrice.getText().replaceAll("[^0-9]",""));
    }

    public BasketPage deleteProduct2(){
        waitUntilElementToBeClicable(deleteProduct2).click();
        return this;
    }

    public BasketPage plusCountProduct1(){
        waitUntilElementToBeClicable(plusCountProduct).click();
        return this;
    }

    public BasketPage returnProduct(){
        waitUntilElementToBeVisible(returnProduct).click();
        return this;
    }


//    @FindBy(xpath = "//div[contains(@class,'additional-warranties-row__radio')]")
//    private List<WebElement> warrantiesList;
//
//
//    public void checkWarranty(){
//        for (WebElement warranty: warrantiesList) {
//            if (warranty.getText().contains("+ 12  мес.") && warranty.getAttribute("class").contains("checked")){
//                //дописать привязку к полю айфона //div[@data-cart-product-id='440a4d81-49b5-422b-ae0c-fd4626365d10']
//                return;
//            }
//        }
//        Assertions.fail("Гарантия на айфон не выбрана");
//    }

}
