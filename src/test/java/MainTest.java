import framework.object.ProductList;
import framework.object.Product;
import framework.pages.BasketPage;
import framework.pages.StartPage;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTests {
    @Test
    public void mainTest() {
        Product iphone = new Product("5072935");
        Product airPods = new Product("5072988");
        ProductList.addInMap(iphone.getArticle(), iphone);
        ProductList.addInMap(airPods.getArticle(),airPods);
        pageManager.getPage(StartPage.class)
                .checkDNSFirstPage()
                .getBaseMenuBlock()
                .findProductGoToCatalog("iphone")
                .checkCatalog()
                .selectCatalogByArticle(iphone.getArticle())
                .checkCardOfProduct()
                .getPriceProduct(iphone)
                .clickWarranty()
                .changesPrice()
                .getPriceWarranty(iphone)
                .clickBuy(iphone)
                .checkClickBuy()
                .getBaseMenuBlock()
                .findProductGoToProductPage("Apple AirPods Pro 2")
                .checkCardOfProduct()
                .getPriceProduct(airPods)
                .clickBuy(airPods)
                .checkClickBuy()
                .getBaseMenuBlock()
                .checkPriceInBasketLabel()
                .goToBasket()
                .checkPageBasket()
                .checkWarranty(iphone.getArticle(),"12")
                .checkPriseProductInBasket(iphone)
                .checkPriseProductInBasket(airPods)
                .checkBasketPrice()
                .removeProductInBasket(airPods)
                .checkRemoveProduct()
                .checkBasketPrice()
                .addProductInBasket(iphone)
                .checkCountOfProduct(ProductList.sizeMapOfProduct())
                .addProductInBasket(iphone)
                .checkCountOfProduct(ProductList.sizeMapOfProduct())
                .returnRemovedProduct(airPods)
                .checkReturn(airPods.getArticle())
                .checkBasketPrice();
    }
}
