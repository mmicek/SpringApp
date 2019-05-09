package main.server.database.dao;

import main.server.database.AbstractRepository;
import main.server.database.dto.ProductData;
import main.server.database.dto.UserData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Repository
public class ProductRepository extends AbstractRepository<ProductData> {

    @Autowired
    private UserRepository userRepository;

    public ProductRepository() { super(ProductData.class);}

    @Transactional
    public Set<ProductData> getProducts(String username){
        return userRepository.getItem(username).getProducts();
    }

    @Transactional
    public synchronized ProductData createItem(Long userId,String name,String productLink) {
        Session session = getSession();
        ProductData product = (ProductData) session.createQuery("from ProductData where userId = :userId AND " +
                "name = :name AND productLink = :productLink")
                .setParameter("userId",userId).setParameter("name",name)
                .setParameter("productLink",productLink).uniqueResult();
        if(product == null){
            product = new ProductData(name,productLink);
            product.setUserId(userId);
            super.createItem(product);
        } else {
            product.setQuantity(product.getQuantity() + 1);
            super.modifyItem(product);
        }
        return product;
    }

}
