package com.aszoke.flashparty.presentation.domain;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class FlashPartySuggestion {

    public static final FlashPartySuggestion EMPTY = new FlashPartySuggestion(0L, Collections.emptySet());

    // Flash parties could have an area property so that we can check if the user is still inside when
    // its geolocation is updated
    // Then the flash party's area should / could be updated too
    // But this raises the Business question: what if users that already formed a party get far away from one another
    // Should they explicitly leave by pressing a Leave button or will the party disregarded if they don't assemble again withing a given time frame?

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

    // When are 2 flash parties considered equal? This equals() should be revisited when Business clarifies
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
