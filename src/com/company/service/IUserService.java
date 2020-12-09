package com.company.service;

import java.util.List;

public interface IUserService<T> {
    void add(T t);
    T getById(long id);
    void update(T t);
    void remove(T t);
    boolean exists(long id);
    List<T> getAll();
    long size();
}
