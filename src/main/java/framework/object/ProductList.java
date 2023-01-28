package framework.object;

import framework.object.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductList {
    static Map<Product, String> mapOfProduct = new HashMap<>();

    public static void addInMap(Product product, String productArticl) {
        mapOfProduct.put(product,
                productArticl);
    }

    public static String returnArticle(Product product) {
        return mapOfProduct.get(product);
    }

    public static int sizeMapOfProduct() {
        return mapOfProduct.size();
    }

    public static void removeProduct(Product product) {
        mapOfProduct.remove(product);
    }

    public static int sumPrice() {
        List<Product> products = mapOfProduct.entrySet().stream().map(Map.Entry::getKey)
                .collect(Collectors.toList());
        int sum = 0;
        for (Product product : products) {
            sum += product.getPriceProductWithWarranty();
        }
        return sum;
    }


}
