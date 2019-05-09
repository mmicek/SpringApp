package main.server.beans;

import main.configuration.security.UserLoginService;
import main.server.beans.services.AuthorizationServiceBean;
import main.server.beans.services.ShopWebsiteService;
import main.server.beans.services.ShopWebsiteServiceBean;
import main.server.database.dao.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetailsService;
import main.server.beans.services.AuthorizationService;
import main.server.controllers.authorization.ApplicationContext;

@Configuration
public class BeanServiceManager {

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserLoginService();
    }

    @Bean
    public AuthorizationService authorizationService(){
        return new AuthorizationServiceBean();
    }

    @Bean
    public ShopWebsiteService shopWebsiteService(){ return new ShopWebsiteServiceBean(); }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ApplicationContext applicationContext() {
        return new ApplicationContext();
    }

}
