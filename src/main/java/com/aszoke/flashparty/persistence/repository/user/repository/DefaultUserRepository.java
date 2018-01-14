package com.aszoke.flashparty.persistence.repository.user.repository;

import com.aszoke.flashparty.persistence.repository.user.factory.UserFactory;
import com.aszoke.flashparty.presentation.domain.GeoLocation;
import com.aszoke.flashparty.presentation.domain.User;
import com.aszoke.flashparty.service.Observable;
import com.aszoke.flashparty.service.Observer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DefaultUserRepository implements UserRepository, Observable<Observer<Set<User>>> {

    @Autowired
    private UserFactory userFactory;

    private Map<Long, User> users = new HashMap<>();
    private List<Observer<Set<User>>> observers = new ArrayList<>();

    @Override
    public User create(GeoLocation geoLocation) {
        User user = userFactory.create(geoLocation);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(long id) {
        User user = users.get(id);
        return (user != null) ? Optional.of(user) : Optional.empty();
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(users.values());
    }

    @Override
    public long count() {
        return users.size();
    }

    @Override
    public Optional<User> update(long id, GeoLocation geoLocation) {
        Optional<User> user = findById(id);
        user.ifPresent(u -> u.setGeoLocation(geoLocation));
        updateObservers();
        return user;
    }

    @Override
    public void addObserver(Observer<Set<User>> observer) {
        observers.add(observer);
    }

    private void updateObservers() {
        for (Observer<Set<User>> observer : observers) {
            observer.update(findAll());
        }
    }

}
