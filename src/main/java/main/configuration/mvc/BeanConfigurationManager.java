package main.configuration.mvc;

import main.configuration.security.HashPasswordEncoder;
import main.configuration.security.LoginSuccessHandler;
import main.server.database.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Configuration
@EnableTransactionManagement
public class BeanConfigurationManager {

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new LoginSuccessHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new HashPasswordEncoder();
    }

    @Autowired
    private List<AbstractRepository> repositoryList;

    @Autowired
    private ApplicationContext applicationContext;


}
