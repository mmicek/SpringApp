package main.server.beans.services;

import main.server.controllers.data.User;
import main.server.database.dao.UserRepository;
import main.server.database.dto.UserData;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorizationServiceBean implements AuthorizationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String username) {
        UserData data = userRepository.getItem(username);
        if(data == null)
            return null;
        return new User(data.getUsername(),data.getPassword());
    }

    @Override
    public long registerUser(User user) {
        UserData data = new UserData();
        data.setUsername(user.getUsername());
        data.setPassword(user.getPassword());
        userRepository.createItem(data);
        return data.getId();
    }

    @Override
    public boolean isUserRegistered(String username) {
        return getUser(username) != null;
    }
}
