package main.server.controllers.authorization;

import main.server.beans.services.AuthorizationService;
import main.server.controllers.AbstractController;
import main.server.controllers.IgnoreAdvice;
import main.server.controllers.data.User;
import main.server.database.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@IgnoreAdvice
@Controller
public class AuthorizationController extends AbstractController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLogin(HttpServletRequest request, Model model){
        if(request.getParameter("error") != null)
            model.addAttribute("error","Bad login or bad password");
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String postRegister(User user){
        if(authorizationService.isUserRegistered(user.getUsername()))
            return "redirect:/register";
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        authorizationService.registerUser(user);
        return redirect("/login");
    }

    @RequestMapping(value = "/user/initContext",method = RequestMethod.GET)
    private String init(
            @RequestParam("token") String accessToken,
            @RequestParam("username") String username,
            @RequestParam("redirect") String redirect
    ){
        String token = authorizationService.getUser(username).getPassword();
        if(token.equals(accessToken)) {
            getApplicationContext().initContext(userRepository.getItem(username));
            return redirect(redirect);
        }
        throw new IllegalArgumentException("Access token is not valid");
    }
}
