package com.aszoke.flashparty.presentation.domain;

import java.util.Collections;
import java.util.Set;

public class FlashPartySuggestion {

    public static final FlashPartySuggestion EMPTY = new FlashPartySuggestion(Collections.emptySet());

    private final Set<User> users;

    public FlashPartySuggestion(Set<User> users) {
        this.users = users;
    }

    public Set<User> getUsers() {
        return users;
    }
}
