package main.server.controllers;

import main.server.controllers.authorization.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractController {

    @Autowired
    private ApplicationContext applicationContext;

    protected ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public String redirect(String url){
        if(url.startsWith("/tai-app"))
            url = url.substring(8);
        return "redirect:" + url;
    }

    public String forward(String url){
        if(url.startsWith("/tai-app"))
            url = url.substring(8);
        return "forward:" + url;
    }
}
