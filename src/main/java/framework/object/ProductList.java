package framework.object;

import framework.object.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductList {
    static Map<String, Product> mapOfProduct = new HashMap<>();

    public static void addInMap(String productArticl, Product product) {
        mapOfProduct.put(productArticl, product);
    }

    public static Product returnArticle(String article) {
        return mapOfProduct.get(article);
    }

    public static int sizeMapOfProduct() {
        List<Product> products = mapOfProduct.entrySet().stream().map(Map.Entry::getValue)
                .collect(Collectors.toList());
        int count = 0;
        for (Product product : products) {
                count += product.getCountOfProduct();
        }
        return count;
    }

    public static void removeProduct(Product product) {
        mapOfProduct.remove(product);
    }

    public static int sumPrice() {
        List<Product> products = mapOfProduct.entrySet().stream().map(Map.Entry::getValue)
                .collect(Collectors.toList());
        int sum = 0;
        for (Product product : products) {
                sum += product.getPriceProductWithWarranty() * product.getCountOfProduct();
        }
        return sum;
    }


}
