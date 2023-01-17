package framework.managers;

import framework.pages.BasketPage;
import framework.pages.ProductPage;
import framework.pages.StartPage;

public class PageManager {
    private static PageManager INSTANCE = null;
    private StartPage startPage;
    private ProductPage productPage;
    private BasketPage basketPage;

    private PageManager(){

    }

    public static PageManager getInstance(){
        if (INSTANCE == null){
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public StartPage getStartPage(){
        if (startPage == null){
            startPage = new StartPage();
        }
        return startPage;
    }

    public ProductPage getProductPage(){
        if (productPage == null){
            productPage = new ProductPage();
        }
        return productPage;
    }

    public BasketPage getBasketPage(){
        if (basketPage == null){
            basketPage = new BasketPage();
        }
        return basketPage;
    }
}
