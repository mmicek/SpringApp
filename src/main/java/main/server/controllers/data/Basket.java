package main.server.controllers.data;

import main.server.database.dto.ProductData;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Basket {

    private Set<ProductData> products;

    public void addProduct(ProductData product){
        products.remove(product);
        products.add(product);
    }

    public List<ProductData> getProducts() {
        return new LinkedList<>(products);
    }

    public void setProducts(Set<ProductData> products) {
        this.products = products;
    }
}
