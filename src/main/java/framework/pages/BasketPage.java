package framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends BasePage {
    @FindBy(xpath = "//div[@class='cart-items__product']")
    private List<WebElement> shoppingList;
    @FindBy(xpath = "//div[@class='cart-tab-total-amount']//../span[@class='price__current']")
    private WebElement sumPrice;
    @FindBy(xpath = "//span[@class='restore-last-removed']")
    private WebElement returnProduct;


    public BasketPage checkWarranty(String articl) {
        for (WebElement product : shoppingList) {
            if (product.findElement(By.xpath("./..//div[contains(@class,'base-ui-radio-button__checked')]"))
                    .getText().contains("+") && product.findElement(By.xpath("./..//div[@class='cart-items__product-code']/div"))
                    .getText().contains(articl)) {
                                return this;
            }
        }
        Assertions.fail("Гарантия на товар не выбрана");
        return this;
    }
    public int getPriseOfProductInBasket(String articl) {
        for (WebElement product : shoppingList) {
            int price;
            if (product.findElement(By.xpath("./..//div[@class='cart-items__product-code']/div"))
                    .getText().contains(articl)) {

                 price = Integer.parseInt(waitUntilElementToBeVisible(product.findElement(By.xpath("./..//span[@class='price__current']")))
                        .getText().replaceAll("[^0-9]",""));
            } else {
                continue;
            }
            return price;

        }
        Assertions.fail("Не найдена стоимость товара");
        return 0;
    }

    public int  getBasketPrice(){
        return Integer.parseInt(waitUntilElementToBeVisible(sumPrice).getText().replaceAll("[^0-9]",""));
    }

    public BasketPage removeProductInBasket(String articl) {
        for (WebElement product : shoppingList) {
            if (product.findElement(By.xpath("./..//div[@class='cart-items__product-code']/div"))
                    .getText().contains(articl)) {
                waitUntilElementToBeClicable(product.findElement(By.xpath("./..//button[@class='menu-control-button remove-button']")))
                        .click();
                return this;
            }

        }
        Assertions.fail("Не удалось удалить товар");
        return this;
    }

    public BasketPage countOfProductInBasket(String articl) {
        for (WebElement product : shoppingList) {
            if (product.findElement(By.xpath("./..//div[@class='cart-items__product-code']/div"))
                    .getText().contains(articl)) {
                waitUntilElementToBeClicable(product.findElement(By.xpath("./..//button[@class='count-buttons__button count-buttons__button_plus']")))
                        .click();
                return this;
            }
        }
        Assertions.fail("Не удалось увеличить количество товара");
        return this;
    }

    public BasketPage returnProduct(){
        waitUntilElementToBeVisible(returnProduct).click();
        return this;
    }
}






