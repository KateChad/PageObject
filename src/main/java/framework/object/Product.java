package framework.object;

public class Product {
    int priceProduct;
    int priceWarranty;

    String article;

    public Product(String article) {
        this.article = article;
    }

    public String getArticle() {
        return article;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public int getPriceWarranty() {
        return priceWarranty;
    }

    public int getPriceProductWithWarranty() {
        return priceWarranty + priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public void setPriceWarranty(int priceWarranty) {
        this.priceWarranty = priceWarranty;
    }


}
