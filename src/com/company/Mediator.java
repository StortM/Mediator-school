package com.company;

public interface Mediator<T> {

    public void notify(T sender, String event);
}
