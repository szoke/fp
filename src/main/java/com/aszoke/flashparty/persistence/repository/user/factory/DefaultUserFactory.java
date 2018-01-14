package com.aszoke.flashparty.persistence.repository.user.factory;

import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class DefaultUserFactory implements UserFactory {

    private final AtomicLong id = new AtomicLong(1L);

    @Override
    public User create(GeoLocation geoLocation) {
        Objects.requireNonNull(geoLocation, "geoLocation must not be null!");

        return new User(id.getAndIncrement(), geoLocation);
    }

}
