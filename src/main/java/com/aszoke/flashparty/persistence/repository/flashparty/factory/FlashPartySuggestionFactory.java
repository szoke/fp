package com.aszoke.flashparty.persistence.repository.flashparty.factory;

import com.aszoke.flashparty.presentation.domain.FlashPartySuggestion;
import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;

import java.util.Set;

public interface FlashPartySuggestionFactory {

    FlashPartySuggestion create(Set<User> users);

}
