package com.aszoke.flashparty.presentation.domain;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class FlashPartySuggestion {

    public static final FlashPartySuggestion EMPTY = new FlashPartySuggestion(0L, Collections.emptySet());

    private final long id;
    private final Set<User> users;

    public FlashPartySuggestion(long id, Set<User> users) {
        this.id = id;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlashPartySuggestion that = (FlashPartySuggestion) o;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

}
