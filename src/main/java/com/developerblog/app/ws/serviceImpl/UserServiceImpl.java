package com.developerblog.app.ws.serviceImpl;

import com.developerblog.app.ws.model.response.UserDetailsResponse;
import com.developerblog.app.ws.model.response.UserRest;
import com.developerblog.app.ws.service.UserService;
import com.developerblog.app.ws.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private Utils utils;
    private Map<String, UserRest> map = null;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsResponse userDetailsResponse) {
        UserRest user = new UserRest();
        user.setFirstName(userDetailsResponse.getFirstName());
        user.setLastName(userDetailsResponse.getLastName());
        user.setEmail(userDetailsResponse.getEmail());
        String userId = utils.generateUserId();
        user.setUserId(userId);
        user.setUserId(userId);
        map = new HashMap<>();
        map.put(userId, user);
        return user;
    }
}
