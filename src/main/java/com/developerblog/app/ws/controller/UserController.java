package com.developerblog.app.ws.controller;

import com.developerblog.app.ws.exception.UserServiceException;
import com.developerblog.app.ws.model.request.UpdateUserDetailsModel;
import com.developerblog.app.ws.model.response.UserDetailsResponse;
import com.developerblog.app.ws.model.response.UserRest;
import com.developerblog.app.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("users")//http://localhost:8082
public class UserController {

    Map<String, UserRest> map = null;

    @Autowired
    UserService userService;

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable("userId") String userId) {

        if (true) throw new UserServiceException("User Service Exception");

        if (map.containsKey(userId)) {
            return new ResponseEntity<>(map.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping()
    public String getUsers(@RequestParam(value = "page") int page, @RequestParam(value = "limit", defaultValue = "25") int limit) {
        return "page & limit :" + page + " " + limit;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsResponse userDetailsResponse) {

        return new ResponseEntity<>(userService.createUser(userDetailsResponse), HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable("userId") String userId, @Valid @RequestBody UpdateUserDetailsModel updateUserDetailsModel) {

        UserRest storedUserDetail = map.get(userId);
        storedUserDetail.setFirstName(updateUserDetailsModel.getFirstName());
        storedUserDetail.setLastName(updateUserDetailsModel.getLastName());
        map.put(userId, storedUserDetail);
        return storedUserDetail;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {
        map.remove(userId);
        return ResponseEntity.noContent().build();
    }


}
