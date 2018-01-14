package com.aszoke.flashparty.persistence.repository.user.factory;

import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultUserFactoryTest {

    private DefaultUserFactory underTest;

    @Before
    public void before() {
        underTest = new DefaultUserFactory();
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowExceptionWhenGeolocationIsNull() {
        underTest.create(null);
    }

    @Test
    public void testCreateShouldCreateNewUserWithIncrementingIdWhenParametersAreValid() {
        GeoLocation geoLocation1 = new GeoLocation(1L, 1L);
        GeoLocation geoLocation2 = new GeoLocation(2L, 2L);

        User user1 = underTest.create(geoLocation1);
        User user2 = underTest.create(geoLocation2);

        assertEquals(1L, user1.getId());
        assertEquals(2L, user2.getId());
        assertEquals(geoLocation1, user1.getGeoLocation());
        assertEquals(geoLocation2, user2.getGeoLocation());
    }

}