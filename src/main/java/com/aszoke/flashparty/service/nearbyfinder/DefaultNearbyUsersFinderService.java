package com.aszoke.flashparty.service.nearbyfinder;

import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.persistence.repository.user.repository.UserRepository;
import com.aszoke.flashparty.service.nearbyfinder.strategy.NearbyUsersFinderStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DefaultNearbyUsersFinderService implements NearbyUsersFinderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NearbyUsersFinderStrategy nearbyUsersFinderStrategy;

    @Override
    public Set<User> findNearbyUsers(User source) {
        return nearbyUsersFinderStrategy.findNearbyUsers(source, getAllUsersExceptSource(source));
    }

    private Set<User> getAllUsersExceptSource(User source) {
        Set<User> users = userRepository.findAll();
        users.remove(source);
        return users;
    }

}
