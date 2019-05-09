package main.server.beans.services;

import main.server.controllers.data.product.Product;
import main.server.controllers.products.ProductController;
import main.server.database.dto.ProductData;
import main.server.logic.products.WebsiteType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ShopWebsiteServiceBean implements ShopWebsiteService {
    @Override
    public List<ProductController.ProductResultList> getProducts(String searchCriteria) throws IOException {
        Document doc = Jsoup.connect("https://www.olx.pl/oferty/q-"+searchCriteria).get();
        Elements table = doc.select("a.marginright5").select("strong");
        List<ProductController.ProductResultList> resultsList = new LinkedList<>();
        for(Element el : table){
            ProductController.ProductResultList result = new ProductController.ProductResultList();
            result.setName(el.html());
            result.setUrl(el.parent().attributes().get("href"));
            resultsList.add(result);
        }
        return resultsList;
    }

    @Override
    public Product getProductDetails(String url) throws IOException {
        return WebsiteType.getProductDetails(url);
    }
}
