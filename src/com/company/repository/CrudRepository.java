package com.company.repository;

public interface CrudRepository<T> {
    void add(T entity);
    T findById(long id);
    void update(T entity);
    void delete (T entity);
    boolean exists(long id);
    Iterable<T> findAll();
}