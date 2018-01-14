package com.aszoke.flashparty.persistence.repository.user.factory;

import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import org.springframework.stereotype.Component;

public interface UserFactory {

    User create(GeoLocation geoLocation);

}
