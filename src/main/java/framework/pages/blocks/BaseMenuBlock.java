package framework.pages.blocks;

import framework.object.ProductList;
import framework.pages.BasePage;
import framework.pages.BasketPage;
import framework.pages.ProductPage;
import framework.pages.StartPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseMenuBlock extends BasePage {
    @FindBy(xpath = ".//input[@placeholder='Поиск по сайту']")
    private WebElement searchString;
    @FindBy(xpath = ".//span[@class='presearch__icon-search']")
    private WebElement searchLabel;
    @FindBy(xpath = ".//span[@class = 'buttons__link-price cart-link-counter__price']")
    private WebElement priceInBasket;
    @FindBy(xpath = ".//a[@class = 'buttons__link ui-link cart-link-counter'] ")
    private WebElement linkOnBasket;
    @FindBy(xpath = ".//span[@class='cart-link-counter__badge']")
    private WebElement countOfProductInBasket;

    public StartPage findProductGoToCatalog(String product) {
        waitUntilElementToBeVisible(searchString).sendKeys(product);
        waitUntilElementToBeClicable(searchLabel).click();
        return pageManager.getPage(StartPage.class);
    }

    public ProductPage findProductGoToProductPage(String product) {
        waitUntilElementToBeVisible(searchString).sendKeys(product);
        waitUntilElementToBeClicable(searchLabel).click();
        return pageManager.getPage(ProductPage.class);
    }

    public BaseMenuBlock checkPriceInBasketLabel() {
        waitStabilityPage(5000, 200);
        int sumPrice = ProductList.sumPrice();
        int priceInBasketLable = Integer.parseInt(waitUntilElementToBeVisible(priceInBasket).getText()
                .replaceAll("[^0-9]", ""));
        Assertions.assertEquals(sumPrice, priceInBasketLable, "Не верная стоимость в заначке корзины");
        return this;
    }

    public BasketPage goToBasket() {
        waitUntilElementToBeClicable(linkOnBasket).click();
        return pageManager.getPage(BasketPage.class);
    }

}
