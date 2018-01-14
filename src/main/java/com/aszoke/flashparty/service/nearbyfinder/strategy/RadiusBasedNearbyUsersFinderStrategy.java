package com.aszoke.flashparty.service.nearbyfinder.strategy;

import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@Component
public class RadiusBasedNearbyUsersFinderStrategy implements NearbyUsersFinderStrategy {

    private static final long RADIUS = 10;

    @Override
    public Set<User> findNearbyUsers(User source, Set<User> candidates) {
        return candidates.stream()
                .filter(candidate -> distance(source.getGeoLocation(), candidate.getGeoLocation()) < RADIUS)
                .collect(Collectors.toSet());
    }

    private double distance(GeoLocation from, GeoLocation to) {
        return sqrt(pow(from.getLatitude() - to.getLatitude(), 2) + pow(from.getLongitude() - to.getLongitude(), 2));
    }

}
