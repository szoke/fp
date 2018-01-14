package com.aszoke.flashparty.presentation.domain;

import java.util.HashSet;
import java.util.Set;

public class Party {

    private PartyArea partyArea;
    private User owner;
    private Set<User> users = new HashSet<>();

    public Party(User owner) {
        this.owner = owner;
        this.users.add(owner);
    }

    public void add(User user) {

    }

    public void remove(User user) {

    }
}
