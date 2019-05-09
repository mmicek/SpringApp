package main.server.logic.products.websitetypes;

import main.server.controllers.data.product.CarProduct;
import main.server.controllers.data.product.Product;
import main.server.logic.products.ProductConverter;

public class OLXProductConverter implements ProductConverter {

    @Override
    public Product getProductFromSite(String url) {
        //TODO get Product from URL
        return new CarProduct("00000000",2001,300000);
    }
}
