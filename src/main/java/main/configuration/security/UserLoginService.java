package main.configuration.security;

import main.server.beans.services.AuthorizationService;
import main.server.controllers.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserLoginService implements UserDetailsService {

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authorizationService.getUser(username);
        if(user == null)
            throw new UsernameNotFoundException(username);
        return new UserDetails(user);
    }

}
