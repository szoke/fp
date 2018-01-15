package com.aszoke.flashparty.presentation.controller.user;

import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.presentation.dto.GeoLocationDto;
import com.aszoke.flashparty.presentation.transformer.GeolocationTransformer;
import com.aszoke.flashparty.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Api(tags = {"user"})
@ApiModel(value = "User Creation", description = "Endpoint for creating a new user")
@RestController
public class CreateUserController {

    @Autowired
    private GeolocationTransformer geolocationTransformer;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Creates a new user")
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody GeoLocationDto geoLocationDto) {
        User user = createUser(createGeolocation(geoLocationDto, getTimeStamp()));
        return createResponseEntity(user);
    }

    private User createUser(GeoLocation geoLocation) {
        return userService.create(geoLocation);
    }

    private GeoLocation createGeolocation(GeoLocationDto geoLocationDto, String timeStamp) {
        return geolocationTransformer.transform(geoLocationDto, timeStamp);
    }

    // In real world we would use structure data like LocalDateTime and need to consider time zones so probably ZonedDateTime
    private String getTimeStamp() {
        return LocalDate.now().toString();
    }

    private ResponseEntity<User> createResponseEntity(User user) {
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}