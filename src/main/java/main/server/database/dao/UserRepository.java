package main.server.database.dao;

import main.configuration.security.HashPasswordEncoder;
import main.server.database.AbstractRepository;
import main.server.database.dto.UserData;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Repository
public class UserRepository extends AbstractRepository<UserData> {

    private static PasswordEncoder passwordEncoder = new HashPasswordEncoder();

    public UserRepository() { super(UserData.class);}

    @Cacheable(value = "userCache",unless = "#result == null")
    @Transactional
    public UserData getItem(String username){
        return (UserData) getSession().createQuery("from UserData where username = :username")
                .setParameter("username",username).uniqueResult();
    }
}
