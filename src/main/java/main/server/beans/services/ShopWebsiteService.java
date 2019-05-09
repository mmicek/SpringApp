package main.server.beans.services;

import main.server.controllers.data.product.Product;
import main.server.controllers.products.ProductController;
import main.server.database.dto.ProductData;

import java.io.IOException;
import java.util.List;

public interface ShopWebsiteService {

    List<ProductController.ProductResultList> getProducts(String searchCriteria) throws IOException;

    Product getProductDetails(String url) throws IOException;

}
