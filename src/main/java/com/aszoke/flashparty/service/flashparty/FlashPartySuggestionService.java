package com.aszoke.flashparty.service.flashparty;

import com.aszoke.flashparty.presentation.domain.FlashPartySuggestion;

import java.util.Set;

public interface FlashPartySuggestionService {

    Set<FlashPartySuggestion> findAll();

}
