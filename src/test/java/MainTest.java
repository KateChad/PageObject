import framework.object.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTests {
    @Test
    public void mainTest() {
        pageManager.getStartPage()
                .getBaseMenuBlock()
                .findProduct("iphone")
                .selectCatalogByArticle("5072935");
        Product ipone = new Product();
        ipone.setPriceProduct(pageManager.getProductPage().getPriceProduct());
        pageManager.getProductPage().clickWarranty();
        ipone.setPriceWarranty(pageManager.getProductPage().getPriceWarranty());
        pageManager.getProductPage()
                .clickBuy()
                .getBaseMenuBlock()
                .findProduct("Apple AirPods Pro 2");
        Product airPods = new Product();
        airPods.setPriceProduct(pageManager.getProductPage().getPriceProduct());
        pageManager.getProductPage().clickBuy();
        int sumPrice1 = ipone.getPriceProductWithWarranty() + airPods.getPriceProduct();
        int priceInBasket = pageManager.getProductPage().getBaseMenuBlock().getPriceInBasket();
        Assertions.assertEquals(sumPrice1, priceInBasket, "Не верная стоимость в заначке корзины");
        pageManager.getProductPage()
                .getBaseMenuBlock()
                .goToBasket();
        pageManager.getBasketPage().checkWarranty("5072935");
        int priceProductInBasket = pageManager.getBasketPage().getPriceOfProductInBasket("5072935");
        Assertions.assertEquals(ipone.getPriceProduct(), priceProductInBasket, "Не верная стоимость 1 товара");
        int priceProduct2InBasket = pageManager.getBasketPage().getPriceOfProductInBasket("5072988");
        Assertions.assertEquals(airPods.getPriceProduct(), priceProduct2InBasket, "Не верная стоимость 2 товара");
        int priceBasket = pageManager.getBasketPage().getBasketPrice();
        Assertions.assertEquals(sumPrice1, priceBasket, "Не верная стоимость корзины");
        pageManager.getBasketPage().removeProductInBasket("5072988");
        int priceBasketWithout2 = pageManager.getBasketPage().getBasketPrice();
        Assertions.assertEquals(priceBasket - airPods.getPriceProduct(), priceBasketWithout2, "Не изменилась сумма товара после удаления");
        pageManager.getBasketPage()
                .countOfProductInBasket("5072935")
                .countOfProductInBasket("5072935")
                .returnProduct();
        int priceBasketEnd = pageManager.getBasketPage().getBasketPrice();
        int priceEnd = (3 * ipone.getPriceProductWithWarranty()) + airPods.getPriceProduct();
        Assertions.assertEquals(priceEnd, priceBasketEnd, "Не верная итоговая стоимость");

    }
}
