import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest extends BaseTests{
@Test
public void mainTest(){
    pageManager.getStartPage()
            .getBaseMenuBlock()
            .findProduct("iphone")
            .selectCatalogByArticle("5072935");
    int priceProduct = pageManager.getProductPage().getPriceProduct();
    pageManager.getProductPage().clickWarranty();
    int priceWarranty = pageManager.getProductPage().getPriceWarranty();
    pageManager.getProductPage()
            .clickBuy()
            .getBaseMenuBlock()
            .findProduct("Apple AirPods Pro 2");
    int priceProduct2 = pageManager.getProductPage().getPriceProduct();
    pageManager.getProductPage().clickBuy();
    int sumPrice1 = priceProduct + priceWarranty + priceProduct2;
    int priceInBasket = pageManager.getProductPage().getBaseMenuBlock().getPriceInBasket();
    Assertions.assertEquals(sumPrice1,priceInBasket,"Не верная стоимость в занчке корзины");
    pageManager.getProductPage()
            .getBaseMenuBlock()
            .goToBasket();
    pageManager.getBasketPage().checkWarranty();
    int priceProductInBasket = pageManager.getBasketPage().getPriceProduct();
    Assertions.assertEquals(priceProduct,priceProductInBasket,"Не верная стоимость 1 товара");
    int priceProduct2InBasket = pageManager.getBasketPage().getPriceProduct2();
    Assertions.assertEquals(priceProduct2,priceProduct2InBasket,"Не верная стоимость 2 товара");
    int priceBasket = pageManager.getBasketPage().getBasketPrice();
    Assertions.assertEquals(sumPrice1,priceBasket,"Не верная стоимость корзины");
    pageManager.getBasketPage().deleteProduct2();
    int priceBasketWithout2 = pageManager.getBasketPage().getBasketPrice();
    Assertions.assertEquals(priceBasket-priceProduct2,priceBasketWithout2,"Не изменилась сумма товара после удаления");
    pageManager.getBasketPage()
            .plusCountProduct1()
            .plusCountProduct1()
            .returnProduct();
    int priceBasketEnd = pageManager.getBasketPage().getBasketPrice();
    Assertions.assertEquals(priceProduct2+3*(priceProduct+priceWarranty),priceBasketEnd,"Не изменилась сумма товара после удаления");








}
}
