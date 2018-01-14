package com.aszoke.flashparty.service.flashparty;

import com.aszoke.flashparty.persistence.repository.flashparty.repository.FlashPartyRepository;
import com.aszoke.flashparty.presentation.domain.FlashPartySuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DefaultFlashPartySuggestionService implements FlashPartySuggestionService{

    @Autowired
    private FlashPartyRepository flashPartyRepository;

    @Override
    public Set<FlashPartySuggestion> findAll() {
        return flashPartyRepository.findAll();
    }
}
