package com.aszoke.flashparty.presentation.transformer;

import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.dto.GeoLocationDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GeolocationTransformer {

    public GeoLocation transform(GeoLocationDto geoLocationDto, LocalDateTime localDateTime) {
        return new GeoLocation(geoLocationDto.getLatitude(), geoLocationDto.getLongitude(), localDateTime);
    }

}
