package framework.object;

import framework.managers.PageManager;

public class Product {
    //прописать в мэйн тесте
    PageManager pageManager = PageManager.getInstance();
    int priceProduct = pageManager.getProductPage().getPriceProduct();
    int priceWarranty = pageManager.getProductPage().getPriceWarranty();
    int priceProductWithWarranty = priceWarranty + priceProduct;

    public int getPriceProduct() {
        return priceProduct;
    }

    public int getPriceWarranty() {
        return priceWarranty;
    }

    public int getPriceProductWithWarranty() {
        return priceProductWithWarranty;
    }
}
