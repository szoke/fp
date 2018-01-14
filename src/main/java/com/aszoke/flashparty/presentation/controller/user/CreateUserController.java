package com.aszoke.flashparty.presentation.controller.user;

import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"user"})
@ApiModel(value = "User Creation", description = "Endpoint for creating a new user")
@RestController
public class CreateUserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Creates a new user")
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