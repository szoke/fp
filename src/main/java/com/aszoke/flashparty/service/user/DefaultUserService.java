package com.aszoke.flashparty.service.user;

import com.aszoke.flashparty.persistence.repository.user.repository.UserRepository;
import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(GeoLocation geoLocation) {
        return userRepository.create(geoLocation);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Set<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> update(long id, GeoLocation geoLocation) {
        return userRepository.update(id, geoLocation);
    }
}
