package framework.object;

public class Product {
    int priceProduct;
    int priceWarranty;
    int countOfProduct = 0;
    String article;

    public int getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(int countOfProduct) {
        this.countOfProduct = countOfProduct;
    }
    public void addProduct() {
        countOfProduct++;
    }

    public void deleteProduct() {
        countOfProduct--;
    }

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
