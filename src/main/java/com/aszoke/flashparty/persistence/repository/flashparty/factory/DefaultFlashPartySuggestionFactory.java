package com.aszoke.flashparty.persistence.repository.flashparty.factory;

import com.aszoke.flashparty.presentation.domain.FlashPartySuggestion;
import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class DefaultFlashPartySuggestionFactory implements FlashPartySuggestionFactory {

    private final AtomicLong id = new AtomicLong(1L);

    @Override
    public FlashPartySuggestion create(Set<User> users) {
        Objects.requireNonNull(users, "users must not be null!");

        return new FlashPartySuggestion(id.getAndIncrement(), users);
    }
}
