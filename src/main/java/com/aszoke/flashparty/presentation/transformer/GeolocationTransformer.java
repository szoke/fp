package com.aszoke.flashparty.presentation.transformer;

import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.dto.GeoLocationDto;
import org.springframework.stereotype.Component;

@Component
public class GeolocationTransformer {

    public GeoLocation transform(GeoLocationDto geoLocationDto, String timeStamp) {
        return new GeoLocation(geoLocationDto.getLatitude(), geoLocationDto.getLongitude(), timeStamp);
    }

}
