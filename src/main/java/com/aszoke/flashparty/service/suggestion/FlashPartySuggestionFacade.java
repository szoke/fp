package com.aszoke.flashparty.service.suggestion;

import com.aszoke.flashparty.presentation.domain.FlashPartySuggestion;
import com.aszoke.flashparty.presentation.domain.User;

import java.util.Optional;

public interface FlashPartySuggestionFacade {

    Optional<FlashPartySuggestion> create(User user);

}
