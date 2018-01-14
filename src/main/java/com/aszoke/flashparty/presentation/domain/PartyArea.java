package com.aszoke.flashparty.presentation.domain;

public class PartyArea {

    public PartyArea(GeoLocation center, long radiusInMeters) {
        this.center = center;
        this.radiusInMeters = radiusInMeters;
    }

    private final GeoLocation center;
    private final long radiusInMeters;
}
