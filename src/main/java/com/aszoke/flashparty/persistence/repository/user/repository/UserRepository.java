package com.aszoke.flashparty.persistence.repository.user.repository;

import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;

import java.util.Optional;
import java.util.Set;

public interface UserRepository {

    User create(GeoLocation geoLocation);

    Optional<User> findById(long id);

    Set<User> findAll();

    long count();

    Optional<User> update(long id, GeoLocation geoLocation);
}
