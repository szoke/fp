package com.aszoke.flashparty.presentation.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class GeoLocation {

    private long latitude;
    private long longitude;
    private LocalDateTime timeStamp;

    public GeoLocation(long latitude, long longitude, LocalDateTime timeStamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoLocation that = (GeoLocation) o;
        return latitude == that.latitude &&
                longitude == that.longitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    public long getLatitude() {
        return latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
