package main.server.controllers.products;


import main.server.beans.services.ShopWebsiteService;
import main.server.controllers.AbstractController;
import main.server.controllers.data.Search;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ProductController extends AbstractController {

    @Autowired
    private ShopWebsiteService shopService;

    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public String product(
            @RequestParam("productUrl") String productUrl,
            Model model
    ) throws IOException {
        model.addAttribute("product",shopService.getProductDetails(productUrl));
        model.addAttribute("productLink",productUrl);
        return "product";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Search search, Model model) throws IOException {
        model.addAttribute("resultsList", shopService.getProducts(search.getSearchString()));
        return "results";
    }

    public static class ProductResultList {

        private String name;
        private String url;

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }

        public String getUrl() { return url; }

        public void setUrl(String url) { this.url = url; }
    }
}
