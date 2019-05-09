package main.server.controllers.products;

import main.server.controllers.AbstractController;
import main.server.database.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class BasketController extends AbstractController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/basket",method = RequestMethod.GET)
    public String basket(Model model){
        model.addAttribute("products",getApplicationContext().getBasket().getProducts());
        return "basket";
    }

    @RequestMapping("/basket/add")
    public String basketAdd(
            @RequestParam("name") String name,
            @RequestParam("productLink") String productLink,
            @RequestParam("returnUrl") String returnUrl
    ){
        getApplicationContext().getBasket().addProduct(productRepository.createItem(
                getApplicationContext().getUser().getId(),name,productLink));
        return redirect(returnUrl+"?productUrl="+productLink);
    }
}
