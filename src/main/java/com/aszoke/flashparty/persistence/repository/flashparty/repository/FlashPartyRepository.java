package com.aszoke.flashparty.persistence.repository.flashparty.repository;

import com.aszoke.flashparty.presentation.domain.FlashPartySuggestion;
import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;

import java.util.Optional;
import java.util.Set;

public interface FlashPartyRepository {

    FlashPartySuggestion create(Set<User> user);

    Set<FlashPartySuggestion> findAll();

}
