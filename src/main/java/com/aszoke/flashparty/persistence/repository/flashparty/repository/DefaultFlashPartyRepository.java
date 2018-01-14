package com.aszoke.flashparty.persistence.repository.flashparty.repository;

import com.aszoke.flashparty.persistence.repository.flashparty.factory.FlashPartySuggestionFactory;
import com.aszoke.flashparty.persistence.repository.user.factory.UserFactory;
import com.aszoke.flashparty.persistence.repository.user.repository.UserRepository;
import com.aszoke.flashparty.presentation.domain.FlashPartySuggestion;
import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DefaultFlashPartyRepository implements FlashPartyRepository {

    @Autowired
    private FlashPartySuggestionFactory flashPartySuggestionFactory;

    private Map<Long, FlashPartySuggestion> flashPartySuggestions = new HashMap<>();

    @Override
    public FlashPartySuggestion create(Set<User> users) {
        FlashPartySuggestion flashPartySuggestion = flashPartySuggestionFactory.create(users);
        flashPartySuggestions.put(flashPartySuggestion.getId(), flashPartySuggestion);
        return flashPartySuggestion;
    }

    @Override
    public Set<FlashPartySuggestion> findAll() {
        return new HashSet<>(flashPartySuggestions.values());
    }

}
