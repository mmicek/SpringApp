package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class
        , JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ImportResource("classpath:database-config.xml")
public class Main {

    public static void main(String args[]) throws ClassNotFoundException {
        System.out.println("Hello");
        SpringApplication.run(Main.class,args);

    }
}
