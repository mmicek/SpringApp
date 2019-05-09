package main.server.controllers;

import main.server.beans.services.ShopWebsiteService;
import main.server.controllers.data.Search;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
@Controller
public class ControllerAdvice {

    @Pointcut("within(main.server.controllers.AbstractController+) &&" +
            "!@annotation(main.server.controllers.IgnoreAdvice) &&" +
            "!@within(main.server.controllers.IgnoreAdvice)")
    public void advice(){}

    @Around("advice()")
    public String beforeAdvice(ProceedingJoinPoint pjp) throws Throwable {
        return "forward:/initAdvice?view="+pjp.proceed();
    }

    @RequestMapping(value = "/initAdvice",method = {RequestMethod.GET,RequestMethod.POST})
    public String initAdvice(
            @RequestParam("view") String forwardView,
            HttpServletRequest request,
            HttpServletResponse response,
            Model model
    ){
        model.addAttribute("search",new Search());
        return forwardView;
    }
}
