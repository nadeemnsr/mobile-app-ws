package com.developerblog.app.ws.service;

import com.developerblog.app.ws.model.response.UserDetailsResponse;
import com.developerblog.app.ws.model.response.UserRest;


public interface UserService {
    UserRest createUser(UserDetailsResponse userDetailsResponse);
}
