package framework.pages;

import framework.object.ProductList;
import framework.object.Product;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends BasePage {
    @FindBy(xpath = "//div[@class='cart-items__product']")
    private List<WebElement> shoppingList;
    @FindBy(xpath = "//div[@class='cart-tab-total-amount']//../span[@class='price__current']")
    private WebElement sumPriceInBasket;
    @FindBy(xpath = "//span[contains(@class, 'cart-tab-menu__item')]/span")
    private WebElement returnProduct;
    @FindBy(xpath = "//button[contains(@class, ' base-ui-button-v2 buy-button')]")
    private WebElement buttonDesign;
    @FindBy(xpath = "//span[@class='cart-link-counter__badge']")
    private WebElement countOfProductInBasket;

    public BasketPage checkPageBasket() {
        Assertions.assertTrue(buttonDesign.isDisplayed(), "Страничка корзины не прогрузилась");
        return this;
    }
//разбить условие
    public BasketPage checkWarranty(String articl, String textWsrranty) {
        for (WebElement product : shoppingList) {
            if (product.findElement(By.xpath(".//div[@class='cart-items__product-code']/div"))
                    .getText().contains(articl)) {
                Assertions.assertTrue(product.findElement(By.xpath(".//div[contains(@class,'base-ui-radio-button__checked')]"))
                        .getText().contains(textWsrranty),"Гарантия для товара с артиклем " + articl +" "+ textWsrranty + "не выбрана");
                return this;
            }
        }
        Assertions.fail("Гарантия на товар не выбрана");
        return this;
    }

    private int getPriceOfProductInBasket(String articl) {

        for (WebElement product : shoppingList) {
            if (product.findElement(By.xpath(".//div[@class='cart-items__product-code']/div"))
                    .getText().contains(articl)) {
                return Integer.parseInt(waitUntilElementToBeVisible(product.findElement(By
                        .xpath(".//span[@class='price__current']")))
                        .getText().replaceAll("[^0-9]", ""));
            }
        }
        Assertions.fail("Не найдена стоимость товара");
        return 0;
    }

    public BasketPage checkPriseProductInBasket(Product product) {
        int priceProductInBasket = getPriceOfProductInBasket(product.getArticle());
        Assertions.assertEquals(product.getPriceProduct(), priceProductInBasket,
                "Не верная стоимость товара");
        return this;
    }

    public BasketPage checkBasketPrice() {
        waitStabilityPage(5000, 200);
        int sumPrice = ProductList.sumPrice();
        int priceInBasket = Integer.parseInt(waitUntilElementToBeVisible(sumPriceInBasket).getText()
                .replaceAll("[^0-9]", ""));
        Assertions.assertEquals(sumPrice, priceInBasket, "Не верная стоимость корзины");
        return this;
    }

    public BasketPage removeProductInBasket(Product removProduct) {
        for (WebElement product : shoppingList) {
            if (product.findElement(By.xpath(".//div[@class='cart-items__product-code']/div"))
                    .getText().contains(removProduct.getArticle())) {
                waitUntilElementToBeClicable(product.findElement(By
                        .xpath(".//button[@class='menu-control-button remove-button']")))
                        .click();
                removProduct.deleteProduct();
                return this;
            }
        }
        Assertions.fail("Не удалось удалить товар");
        return this;
    }

    //попробовать привязать к товару на страничке
    public BasketPage checkRemoveProduct() {
        Assertions.assertTrue(returnProduct.isDisplayed(), "Товар не удален");
        return this;
    }


    public BasketPage addProductInBasket(Product product) {
        for (WebElement productInList : shoppingList) {
            scrollWithOffset(productInList, 0, -250);
            if (productInList.findElement(By
                            .xpath(".//div[@class='cart-items__product-code']/div"))
                    .getText().contains(product.getArticle())) {
                waitUntilElementToBeClicable(productInList.findElement(By
                        .xpath(".//button[@class='count-buttons__button count-buttons__button_plus']")))
                        .click();
                product.addProduct();
                return this;
            }
        }
        Assertions.fail("Не удалось увеличить количество товара");
        return this;
    }

    public BasketPage checkCountOfProduct(int sizeOfListProduct) {
        waitStabilityPage(5000, 1000);
        Assertions.assertEquals(sizeOfListProduct, Integer.parseInt(countOfProductInBasket
                .getText()), "Количесто товаров не изменено");
        return this;
    }

    public BasketPage returnRemovedProduct(Product product) {
        returnProduct.click();
        product.addProduct();
        return this;
    }

    public BasketPage checkReturn(String articl) {
        waitStabilityPage(5000, 200);
        for (WebElement product : shoppingList) {
            if (waitUntilElementToBeClicable(product
                    .findElement(By
                            .xpath(".//div[@class='cart-items__product-code']/div")))
                    .getText().contains(articl)) {
                return this;
            }
        }
        Assertions.fail("Товар с  артиклем " + articl + " не возвращен");
        return this;
    }
}






