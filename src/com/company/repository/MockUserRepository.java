package com.company.repository;

import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

/*
    "Database" klasse der understøtter CRUD operationer
    Benytter ArrayList til intern opbevaring af User objekter

    ArrayList er 0-index baseret og derfor vil klassen instantiere en arraylist med 1 bruger for at index gerne skulle være repræsentativt for user objektet (index starter fra 1).
    OBS!! Brug size() metoden istedet for at kalde listens size metode.*/

// hele klassen burde nok være lavet med Map i stedet for arrayliste, da det havde været nemmere at forstå og kode til. Men lidt sent at ændre nu..

public class MockUserRepository implements CrudRepository<User> {
    private final List<User> database;

    public MockUserRepository() {
        this.database = new ArrayList<>();
        database.add(new User(0, "!! 0 index user, dont use !!", "!! 0 index user, dont use !!", "!! 0 index user, dont use !!", "!! 0 index user, dont use !!", ""));
    }

    public long size() {
        return database.size() - 1;
    }

    private long calculateNextId() {
        return size() + 1;
    }

    @Override
    public void add(User user) {
        user.setId(calculateNextId());

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

    // den her er lavet lidt hurtigt da jeg er en smule træt.
    // den er ligesom nogen af de andre metoder lidt dum pga den interne arraylist implementation
    // set metoden fra arraylist klassen skal bruge et index hvilket jeg tager direkte fra user id
    // det er ok hvis der ikke slettes elementer fra db listen, men hvis der gør vil id og index ikke være in sync.
    // regner ikke med vi skal slette elementer så det burde være ok
    @Override
    public void update(User user) {
        for(User userInDatabase : database) {
            if(userInDatabase.getId() == user.getId()) {
                database.set((int) userInDatabase.getId(), user);
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

    @Override
    public String toString() {
        return "MockUserRepository{" +
                "database=" + database +
                '}';
    }
}
