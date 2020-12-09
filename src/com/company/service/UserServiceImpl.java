package com.company.service;

import com.company.component.Component;
import com.company.model.User;
import com.company.repository.CrudRepository;
import com.company.repository.MockUserRepository;

import java.util.List;

public class UserServiceImpl implements IUserService<User> {

    MockUserRepository mockUserRepository;

    public UserServiceImpl(){
    }

    @Override
    public void add(User user) {
        mockUserRepository.add(user);
    }

    @Override
    public User getById(long id) {
        return mockUserRepository.findById(id);
    }

    @Override
    public void update(User user) {
        mockUserRepository.update(user);
    }

    @Override
    public void remove(User user) {
        mockUserRepository.delete(user);
    }

    @Override
    public boolean exists(long id) {
        return mockUserRepository.exists(id);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) mockUserRepository.findAll();
    }

    @Override
    public long size() {
        return mockUserRepository.size();
    }

    public boolean usernameExists(String usernameToCheck){
        List<User> userList = (List<User>) mockUserRepository.findAll();

        for (User user : userList) {
            if (user.getUsername().equals(usernameToCheck)){
                return true;
            }
        }

        return false;
    }

    public boolean emailExists(String emailToCheck){
        List<User> userList = (List<User>) mockUserRepository.findAll();

        for (User user : userList) {
            if (user.getEmail().equals(emailToCheck)){
                return true;
            }
        }

        return false;
    }

    public boolean loginCredentialsExists(String usernameToCheck, String passwordToCheck){
        List<User> userList = (List<User>) mockUserRepository.findAll();

        for (User user : userList) {
            if (user.getUsername().equals(usernameToCheck) && user.getPassword().equals(passwordToCheck)){
                return true;
            }
        }

        return false;
    }
}
