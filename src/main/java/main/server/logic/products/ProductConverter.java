package main.server.logic.products;

import main.server.controllers.data.product.Product;

public interface ProductConverter {

    Product getProductFromSite(String url);
}
