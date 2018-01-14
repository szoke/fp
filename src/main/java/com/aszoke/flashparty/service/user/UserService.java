package com.aszoke.flashparty.service.user;

import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {

    User create(GeoLocation geoLocation);

    Optional<User> findById(long id);

    Set<User> findAll();

    Optional<User> update(long id, GeoLocation geoLocation);
}
