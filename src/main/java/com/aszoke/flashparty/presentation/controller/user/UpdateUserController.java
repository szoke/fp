package com.aszoke.flashparty.presentation.controller.user;

import com.aszoke.flashparty.presentation.domain.FlashPartySuggestion;
import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UpdateUserController {

    @Autowired
    private UserService userService;

    /*
        In real life I would probably bind incoming data into a DTO and validate it.
        I would pay more attention to distinguishing between DTOs and domain objects.
     */
    @RequestMapping(value = "/users/{id}/geolocation", method = RequestMethod.POST)
    public ResponseEntity<FlashPartySuggestion> update(@PathVariable("id") long id, @RequestBody GeoLocation geoLocation) {
        // In real life I would not leak entities to this level
        // Application tears would have their own domains
        Optional<User> user = updateUser(id, geoLocation);
        return createEmptyResponseEntity();
    }

    private Optional<User> updateUser(long id, GeoLocation geoLocation) {
        return userService.update(id, geoLocation);
    }

    private ResponseEntity<FlashPartySuggestion> createResponseEntity(FlashPartySuggestion flashPartySuggestion) {
        return new ResponseEntity<>(flashPartySuggestion, HttpStatus.OK);
    }

    private ResponseEntity<FlashPartySuggestion> createEmptyResponseEntity() {
        // TODO
        return new ResponseEntity<>(FlashPartySuggestion.EMPTY, HttpStatus.OK);
    }

}