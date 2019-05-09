package main.server.controllers.authorization;

import main.server.controllers.data.Basket;
import main.server.database.dao.ProductRepository;
import main.server.database.dto.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ApplicationContext {

    @Autowired
    private ProductRepository productRepository;

    private UserData user;

    private Basket basket;

    public ApplicationContext(){}

    public UserData getUser() {
        return user;
    }

    void initContext(UserData user){
        this.user = user;
        basket = new Basket();
        basket.setProducts(productRepository.getProducts(user.getUsername()));
    }

    public Basket getBasket() {
        return basket;
    }
}
