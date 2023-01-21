package framework.pages;

import framework.pages.blocks.BaseMenuBlock;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage {
    private BaseMenuBlock baseMenuBlock = new BaseMenuBlock();

    @FindBy(xpath = "//div[@data-id='product']")
    private List<WebElement> catalog;
    @FindBy(xpath = "//a[@class='pagination-widget__page-link']")
    private List<WebElement> catalogPageList;


    public ProductPage selectCatalogByArticle(String article) {
        for (WebElement page : catalogPageList) {
            for (WebElement product : catalog) {
                if (product.getAttribute("data-code").contains(article)) {
                    waitUntilElementToBeClicable(product.findElement(By.xpath(".//a[@class='catalog-product__name ui-link ui-link_black']"))).click();
                    return pageManager.getProductPage();
                }
            }
            page.click();
        }
        Assertions.fail("Товар с артиклем " + article + " не найден в котологе");
        return pageManager.getProductPage();

    }

    public BaseMenuBlock getBaseMenuBlock() {
        return baseMenuBlock;
    }


}
