package com.aszoke.flashparty.presentation.controller.user;

import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody GeoLocation geoLocation) {
        User user = createUser(geoLocation);
        return createResponseEntity(user);
    }

    private User createUser(GeoLocation geoLocation) {
        return userService.create(geoLocation);
    }

    private ResponseEntity<User> createResponseEntity(User user) {
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}