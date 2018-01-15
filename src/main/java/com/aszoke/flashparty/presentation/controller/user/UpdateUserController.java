package com.aszoke.flashparty.presentation.controller.user;

import com.aszoke.flashparty.presentation.domain.FlashPartySuggestion;
import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.presentation.dto.GeoLocationDto;
import com.aszoke.flashparty.presentation.transformer.GeolocationTransformer;
import com.aszoke.flashparty.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class UpdateUserController {

    @Autowired
    private GeolocationTransformer geolocationTransformer;

    @Autowired
    private UserService userService;

    /*
        In real life I would probably bind incoming data into a DTO and validate it.
        I would pay more attention to distinguishing between DTOs and domain objects.
     */
    @RequestMapping(value = "/users/{id}/geolocation", method = RequestMethod.POST)
    public ResponseEntity<FlashPartySuggestion> update(@PathVariable("id") long id, @RequestBody GeoLocationDto geoLocationDto) {
        // In real life I would not leak entities to this level
        // Application tears would have their own domains
        updateUser(id, createGeolocation(geoLocationDto, getTimeStamp()));
        // Returning a status code is enough now that we have a separate flash party controller
        return createEmptyResponseEntity();
    }

    private Optional<User> updateUser(long id, GeoLocation geoLocation) {
        return userService.update(id, geoLocation);
    }

    private GeoLocation createGeolocation(GeoLocationDto geoLocationDto, LocalDateTime timeStamp) {
        return geolocationTransformer.transform(geoLocationDto, timeStamp);
    }

    // In real world we would need to consider time zones
    private LocalDateTime getTimeStamp() {
        return LocalDateTime.now();
    }

    private ResponseEntity<FlashPartySuggestion> createEmptyResponseEntity() {
        // TODO
        return new ResponseEntity<>(FlashPartySuggestion.EMPTY, HttpStatus.OK);
    }

}