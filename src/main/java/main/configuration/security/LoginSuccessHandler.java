package main.configuration.security;

import main.server.beans.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private PasswordEncoder encoder;
    private static SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse httpServletResponse
            ,Authentication authentication) {
        try {

            Field field = handler.getClass().getDeclaredField("requestCache");
            field.setAccessible(true);
            String redirectPath = request.getRequestURI().substring(0,request.getRequestURI().lastIndexOf("/"));
            DefaultSavedRequest savedRequest = ((DefaultSavedRequest)((RequestCache) field.get(handler))
                    .getRequest(request,httpServletResponse));
            String redirect = savedRequest == null ? "/" : savedRequest.getRequestURI();
            if(redirect.startsWith("/tai-app"))
                redirect = redirect.substring(8);
            String url = redirectPath + "/user/initContext?redirect=" + redirect
                    + "&username=" + request.getParameter("username")
                    + "&token=" + encoder.encode(request.getParameter("password"));
            httpServletResponse.sendRedirect(url);

        } catch (Exception e) { e.printStackTrace(); }
    }
}
