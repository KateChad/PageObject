import framework.object.ProductList;
import framework.object.Product;
import framework.pages.BasketPage;
import framework.pages.StartPage;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTests {
    @Test
    public void mainTest() {
        Product iphone = new Product("5072935");
        Product iphone2 = new Product("5072935");
        Product iphone3 = new Product("5072935");
        Product airPods = new Product("5072988");
        ProductList.addInMap(iphone, iphone.getArticle());
        ProductList.addInMap(airPods, airPods.getArticle());
        pageManager.getPage(StartPage.class)
                .checkDNSFirstPage()
                .getBaseMenuBlock()
                .findProductGoToCatalog("iphone")
                .checkCatalog()
                .selectCatalogByArticle(ProductList.returnArticle(iphone))
                .checkCardOfProduct()
                .getPriceProduct(iphone)
                .clickWarranty()
                .changesPrice()
                .getPriceWarranty(iphone)
                .clickBuy()
                .checkClickBuy()
                .getBaseMenuBlock()
                .findProductGoToProductPage("Apple AirPods Pro 2")
                .checkCardOfProduct()
                .getPriceProduct(airPods)
                .clickBuy()
                .checkClickBuy()
                .getBaseMenuBlock()
                .checkPriceInBasketLabel()
                .goToBasket()
                .checkPageBasket()
                .checkWarranty(ProductList.returnArticle(iphone))
                .checkPriseProductInBasket(iphone)
                .checkPriseProductInBasket(airPods)
                .checkBasketPrice()
                .removeProductInBasket(airPods)
                .checkRemoveProduct()
                .checkBasketPrice()
                .countOfProductInBasket(iphone2, ProductList.returnArticle(iphone))
                .checkCountOfProduct(ProductList.sizeMapOfProduct())
                .countOfProductInBasket(iphone3, ProductList.returnArticle(iphone))
                .checkCountOfProduct(ProductList.sizeMapOfProduct())
                .returnProduct(airPods, airPods.getArticle())
                .checkReturn(ProductList.returnArticle(airPods));
        iphone2.setPriceProduct(iphone.getPriceProduct());
        iphone2.setPriceWarranty(iphone.getPriceWarranty());
        iphone3.setPriceProduct(iphone.getPriceProduct());
        iphone3.setPriceWarranty(iphone.getPriceWarranty());
        pageManager.getPage(BasketPage.class).checkBasketPrice();
    }
}
