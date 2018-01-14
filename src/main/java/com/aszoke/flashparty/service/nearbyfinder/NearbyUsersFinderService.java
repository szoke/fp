package com.aszoke.flashparty.service.nearbyfinder;

import com.aszoke.flashparty.presentation.domain.User;

import java.util.Set;

public interface NearbyUsersFinderService {

    Set<User> findNearbyUsers(User sourceUser, Set<User> users);

}
