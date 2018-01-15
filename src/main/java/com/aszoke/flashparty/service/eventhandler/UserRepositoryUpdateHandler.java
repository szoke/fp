package com.aszoke.flashparty.service.eventhandler;

import com.aszoke.flashparty.persistence.repository.flashparty.repository.FlashPartyRepository;
import com.aszoke.flashparty.persistence.repository.user.repository.UserRepository;
import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.service.Observable;
import com.aszoke.flashparty.service.Observer;
import com.aszoke.flashparty.service.nearbyfinder.NearbyUsersFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// This class has too many responsibilities
@Component
public class UserRepositoryUpdateHandler implements Observer<Set<User>> {

    private static final long MINIMUM_NUMBER_OF_USERS_TO_FORM_PARTY = 5;

    @Autowired
    private Observable<Observer<Set<User>>> userRepository;

    @Autowired
    private FlashPartyRepository flashPartyRepository;

    @Autowired
    private NearbyUsersFinderService nearbyUsersFinderService;

    @PostConstruct
    public void postConstruct(){
        userRepository.addObserver(this);
    }

    // How many users do we process here?
    // Is this already a small enough partition of close enough users?
    // How do we handle overlapping flash parties?
    @Override
    public void update(Set<User> users) {

        // Are we too greedy here? Maybe create suggestions for the updated user
        // only like it worked before the API change
        // Also TDD would help here to set clear requirements
        for (User user : users) {
            Set<User> otherUsers = getOtherUsers(user, users);
            Set<User> nearbyUsers = findNearbyUsers(user, otherUsers);
            Set<User> partyMemberCandidates = createPartyMemberCandidates(user, nearbyUsers);
            if (isMinimumNumberRequirementMet(partyMemberCandidates)) {
                flashPartyRepository.create(partyMemberCandidates);
            }
        }
    }

    private Set<User> getOtherUsers(User source, Set<User> users) {
        return users.stream().filter(u -> u.getId() != source.getId()).collect(Collectors.toSet());
    }

    private Set<User> findNearbyUsers(User user, Set<User> users) {
        return nearbyUsersFinderService.findNearbyUsers(user, users);
    }

    private Set<User> createPartyMemberCandidates(User source, Set<User> nearbyUsers) {
        Set<User> candidates = new HashSet<>();
        candidates.add(source);
        candidates.addAll(nearbyUsers);
        return candidates;
    }

    // In the long run this can be moved into a separate class and act like a condition
    private boolean isMinimumNumberRequirementMet(Set<User> users) {
        return (users.size() + 1) >= MINIMUM_NUMBER_OF_USERS_TO_FORM_PARTY;
    }

}
