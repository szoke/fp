package com.aszoke.flashparty.service.nearbyfinder.strategy;

import com.aszoke.flashparty.presentation.domain.User;

import java.util.Set;

public interface NearbyUsersFinderStrategy {

    Set <User> findNearbyUsers(User source, Set<User> candidates);

}
