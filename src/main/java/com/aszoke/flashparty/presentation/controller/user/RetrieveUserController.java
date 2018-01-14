package com.aszoke.flashparty.presentation.controller.user;

import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RetrieveUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> retrieve(@PathVariable("id") long id) {
        Optional<User> user = getUser(id);
        return user.map(this::createResponseEntity).orElseGet(this::createEmptyResponseEntity);
    }

    private Optional<User> getUser(long id) {
        return userService.findById(id);
    }

    private ResponseEntity<User> createResponseEntity(User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    private ResponseEntity<User> createEmptyResponseEntity() {
        // TODO
        return new ResponseEntity<>(new User(1L,null), HttpStatus.NOT_FOUND);
    }

}