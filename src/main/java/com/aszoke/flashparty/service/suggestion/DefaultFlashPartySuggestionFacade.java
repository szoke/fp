package com.aszoke.flashparty.service.suggestion;

import com.aszoke.flashparty.presentation.domain.FlashPartySuggestion;
import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.service.nearbyfinder.NearbyUsersFinderService;
import com.aszoke.flashparty.service.suggestion.FlashPartySuggestionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class DefaultFlashPartySuggestionFacade implements FlashPartySuggestionFacade {

    @Autowired
    private NearbyUsersFinderService nearbyUsersFinderService;

    @Override
    public Optional<FlashPartySuggestion> create(User user) {
        Set<User> nearbyUsers = findNearbyUsers(user);
        return nearbyUsers.size() > 0 ? createFlashPartySuggestion(user, nearbyUsers) : Optional.empty();
    }

    private Set<User> findNearbyUsers(User user) {
        return nearbyUsersFinderService.findNearbyUsers(user);
    }

    private Optional<FlashPartySuggestion> createFlashPartySuggestion(User user, Set<User> nearbyUsers) {
        HashSet<User> users = new HashSet<>();
        users.add(user);
        users.addAll(nearbyUsers);
        return Optional.of(new FlashPartySuggestion(1L, users));
    }

}
