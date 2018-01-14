package com.aszoke.flashparty.service;

public interface Observable<T> {

    void addObserver(T observer);

}
