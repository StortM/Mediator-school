package com.company.repository;

import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

/*
    "Database" klasse der understøtter CRUD operationer
    Benytter ArrayList til intern opbevaring af User objekter

    ArrayList er 0-index baseret og derfor vil klassen instantiere en arraylist med 1 bruger for at index gerne skulle være repræsentativt for user objektet.
    OBS!! Brug size() metoden istedet for at kalde listens size metode.*/

public class MockUserRepository implements CrudRepository<User> {
    private final List<User> database;

    public MockUserRepository() {
        this.database = new ArrayList<>();
        database.add(new User(0, "!! 0 index user, dont use !!", "!! 0 index user, dont use !!", "!! 0 index user, dont use !!", "!! 0 index user, dont use !!", ""));
    }

    private int size() {
        return database.size() - 1;
    }

    // todo -- brug user id til at finde index for user (hvis det findes)
    private int findUserIndex(User user) {
        int userIndex = -1;
        int current = 0;

        for(User userFromDb : database) {
            current++;

            if(userFromDb.getId() == user.getId()) {
                return current;
            }
        }

        return userIndex;
    }

    @Override
    public void add(User user) {
        database.add(user);
    }

    @Override
    public User findById(long id) {
        for(User user : database) {
            if(user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    // todo -- skal bruge findUserIndex
    @Override
    public void update(User user) {
        int userIndexInDatabase = 0;

        for(User userFromDb : database) {
            userIndexInDatabase++;

            if(userIndexInDatabase == user.getId()) {
                database.set(userIndexInDatabase, user);
                break;
            }
        }
    }

    @Override
    public void delete(User user) {

        database.remove((int) user.getId());
    }

    @Override
    public boolean exists(long id) {
        if(id > size()) {
            return false;
        }

        for(User user : database) {
            if(user.getId() == id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return database;
    }
}
