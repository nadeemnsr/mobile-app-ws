package com.developerblog.app.ws.controller;

import com.developerblog.app.ws.model.response.UserDetailsResponse;
import com.developerblog.app.ws.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")//http://localhost:8082
public class UserController {

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable("userId") String UserId) {
        UserRest user = new UserRest();
        user.setFirstName("Sergey");
        user.setLastName("kaop");
        user.setEmail("abd@Gmail.com");
        user.setUserId("1234");
        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
    }

    @GetMapping()
    public String getUsers(@RequestParam(value = "page") int page, @RequestParam(value = "limit", defaultValue = "25") int limit) {
        return "page & limit :" + page + " " + limit;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsResponse userDetailsResponse) {
        UserRest user = new UserRest();
        user.setFirstName(userDetailsResponse.getFirstName());
        user.setLastName(userDetailsResponse.getLastName());
        user.setEmail(userDetailsResponse.getEmail());
        user.setUserId(userDetailsResponse.getPassword());
        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }

}
