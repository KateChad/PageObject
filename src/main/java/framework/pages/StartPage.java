package framework.pages;

import framework.pages.blocks.BaseMenuBlock;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage{
    private BaseMenuBlock baseMenuBlock = new BaseMenuBlock();

    @FindBy(xpath = "//div[@data-id='product']")
    private List<WebElement> catalog;

    public ProductPage selectCatalogByArticle(String article){
        for (WebElement product: catalog) {
            if (product.getAttribute("data-code").contains(article)){
                //не факт что сработает

                waitUntilElementToBeClicable(product.findElement(By.xpath("/..//a[@class='catalog-product__image-link']"))).click();
                return pageManager.getProductPage();
            }

        }
        Assertions.fail("Товар с артиклем " + article + " не найден в котологе на 1 стр");
        return pageManager.getProductPage();

    }
    public BaseMenuBlock getBaseMenuBlock() {
        return baseMenuBlock;
    }



}
