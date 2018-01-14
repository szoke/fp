package com.aszoke.flashparty.presentation.domain;

import java.util.Objects;

public class User {

    private final long id;

    private GeoLocation geoLocation;

    public User(long id, GeoLocation geoLocation) {
        this.id = id;
        this.geoLocation = geoLocation;

    }

    public long getId() {
        return id;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
