package com.aszoke.flashparty.presentation.controller.user;

import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class RetrieveAllUsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Set<User>> retrieveAll() {
        Set<User> users = getAllUsers();
        return createResponseEntity(users);
    }

    private Set<User> getAllUsers() {
        return userService.findAll();
    }

    private ResponseEntity<Set<User>> createResponseEntity(Set<User> users) {
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

}