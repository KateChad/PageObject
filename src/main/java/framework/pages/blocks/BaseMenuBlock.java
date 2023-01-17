package framework.pages.blocks;

import framework.pages.BasePage;
import framework.pages.BasketPage;
import framework.pages.StartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseMenuBlock extends BasePage {
    @FindBy(xpath = "//input[@placeholder='Поиск по сайту']")
    private WebElement searchString;
    @FindBy(xpath = "//span[@class='presearch__icon-search']")
    private WebElement searchLabel;
    @FindBy(xpath = "//span[@class = 'buttons__link-price cart-link-counter__price']")
    private WebElement priceInBasket;
    @FindBy(xpath = "//a[@class = 'buttons__link ui-link cart-link-counter'] ")
    private WebElement linkOnBasket;


    public StartPage findProduct(String product){
        waitUntilElementToBeVisible(searchString).sendKeys(product);
        waitUntilElementToBeClicable(searchLabel).click();
        return pageManager.getStartPage();
    }

    public int getPriceInBasket(){
        return Integer.parseInt(priceInBasket.getText().replaceAll("[^0-9]",""));
    }

    public BasketPage goToBasket(){
        waitUntilElementToBeClicable(linkOnBasket).click();
        return pageManager.getBasketPage();
    }
}
