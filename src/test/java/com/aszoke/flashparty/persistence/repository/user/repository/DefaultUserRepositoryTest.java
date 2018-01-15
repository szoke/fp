package com.aszoke;

import com.aszoke.flashparty.persistence.repository.user.factory.UserFactory;
import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.persistence.repository.user.repository.DefaultUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class DefaultUserRepositoryTest {

    @Mock
    private UserFactory userFactory;

    @InjectMocks
    private DefaultUserRepository underTest;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateShouldReturnUserWhenItReceivesOneFromUserFactory() {
        GeoLocation geoLocation = createGeoLocation();
        User expected = new User(1L, geoLocation);
        when(userFactory.create(geoLocation)).thenReturn(expected);

        User actual = underTest.create(geoLocation);

        assertSame(actual, expected);
    }

    @Test
    public void testCreateShouldPersistUserWhenItReceivesOneFromUserFactory() {
        GeoLocation geoLocation = createGeoLocation();
        User expected = new User(1L, geoLocation);
        when(userFactory.create(geoLocation)).thenReturn(expected);

        User actual = underTest.create(geoLocation);

        assertSame(actual, expected);
        assertEquals(1, underTest.findAll().size());
        User expectedSingleUserInRepository = underTest.findAll().iterator().next();
        assertSame(actual, expectedSingleUserInRepository);
    }

    @Test
    public void testFindByIdShouldReturnEmptyOptionalWhenUserIsNotInTheRepository() {
        Optional<User> actual = underTest.findById(1L);

        assertFalse(actual.isPresent());
    }

    @Test
    public void testFindByIdShouldReturnUserWhenUserIsInTheRepository() {
        long id = 1L;
        GeoLocation geoLocation = createGeoLocation();
        User expected = new User(id, geoLocation);
        when(userFactory.create(any(GeoLocation.class))).thenReturn(expected).thenReturn(expected);
        underTest.create(geoLocation);

        Optional<User> actual = underTest.findById(id);

        assertTrue(actual.isPresent());
        assertSame(actual.get(), expected);
    }

    @Test
    public void testFindAllShouldReturnEmptySetWhenNoUsersAreInTheRepository() {
        Set<User> actual = underTest.findAll();

        assertTrue(actual.isEmpty());
        assertEquals(0, underTest.count());
    }

    @Test
    public void testFindAllShouldReturnAllUsersWhenThereAreUsersInTheRepository() {
        GeoLocation geoLocation1 = createGeoLocation();
        User expectedUser1 = new User(1L, geoLocation1);
        GeoLocation geoLocation2 = createGeoLocation();
        User expectedUser2 = new User(2L, geoLocation2);
        when(userFactory.create(any(GeoLocation.class))).thenReturn(expectedUser1).thenReturn(expectedUser2);
        underTest.create(geoLocation1);
        underTest.create(geoLocation2);

        Set<User> actual = underTest.findAll();

        assertEquals(2, actual.size());
        assertTrue(actual.contains(expectedUser1));
        assertTrue(actual.contains(expectedUser2));
        assertEquals(2, underTest.count());
    }

    private GeoLocation createGeoLocation() {
        return new GeoLocation(1L, 2L, LocalDateTime.now());
    }

}