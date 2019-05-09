package main.server.logic.products;

import main.server.controllers.data.product.Product;
import main.server.logic.products.websitetypes.AllegroProductConverter;
import main.server.logic.products.websitetypes.OLXProductConverter;
import main.server.logic.products.websitetypes.OtomotoProductConverter;

public enum WebsiteType {

    OLX(new OLXProductConverter()),
    OTOMOTO(new OtomotoProductConverter()),
    ALLEGRO(new AllegroProductConverter());

    private ProductConverter converter;

    WebsiteType(ProductConverter converter){
        this.converter = converter;
    }

    public static Product getProductDetails(String url) {
        for(WebsiteType type : WebsiteType.values())
            if(url.contains(type.name().toLowerCase()+".pl"))
                return type.getProduct(url);
        throw new UnsupportedOperationException("Unsupported website URL: " + url);
    }

    public Product getProduct(String url) {
        return converter.getProductFromSite(url);
    }
}
