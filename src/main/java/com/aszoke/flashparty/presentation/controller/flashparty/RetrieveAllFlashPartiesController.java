package com.aszoke.flashparty.presentation.controller.flashparty;

import com.aszoke.flashparty.presentation.domain.FlashPartySuggestion;
import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.service.flashparty.FlashPartySuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class RetrieveAllFlashPartiesController {

    @Autowired
    private FlashPartySuggestionService flashPartySuggestionService;

    @RequestMapping(value = "/flashparties", method = RequestMethod.GET)
    public ResponseEntity<Set<FlashPartySuggestion>> retrieveAll() {
        Set<FlashPartySuggestion> flashPartySuggestions = getFlashPartySuggestions();
        return createResponseEntity(flashPartySuggestions);
    }

    private Set<FlashPartySuggestion> getFlashPartySuggestions() {
        return flashPartySuggestionService.findAll();
    }

    private ResponseEntity<Set<FlashPartySuggestion>> createResponseEntity(Set<FlashPartySuggestion> users) {
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

}