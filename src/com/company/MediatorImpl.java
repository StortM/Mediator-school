package com.company;

import com.company.component.Button;
import com.company.component.Component;
import com.company.component.TextField;
import com.company.menu.Menu;
import com.company.model.User;
import com.company.repository.CrudRepository;

public class MediatorImpl implements Mediator<Component>{

    private Button button;
    private TextField textField;
    private String title;
    private Menu menu;
    private CrudRepository<User> crudRepository;
    private int windowX;
    private int windowY;

    @Override
    public void notify(Component sender, String event) {
        if (sender instanceof Button && event.equals("loginClick")){
            String username = LoginMenu.getUsernameTextField();
            String password = LoginMenu.getPasswordTextField();

            if (LoginMenu.verifyUser(username, password)){
                menu.setTitle("login page");
                System.out.println("logging user into system");
                menu.setwindowX = 1680;
                menu.setwindowY = 1050;
                menu.setActivePage(HOME);
            }
            else{
                menu.setTitle("Error! Wrong username or password");
                menu.setwindowX = 1280;
                menu.setwindowY = 1024;
                menu.setActivePage(LOGIN);
            }
        }

        if (sender instanceof Button && event.equals("createUserClick")) {
            User userToBeAdded = new User();
            userToBeAdded.setFirstName(CreateUserMenu.getFirstName());
            userToBeAdded.setLastName(CreateUserMenu.getLastName());
            userToBeAdded.setUsername(CreateUserMenu.getUsername());
            userToBeAdded.setPassword(CreateUserMenu.getPassword());
            userToBeAdded.setEmail(CreateUserMenu.getEmail());

            crudRepository.add(userToBeAdded);

            //ide
            menu.setActivePage(HOME); //kunne være enum eller sådan noget
            menu.setTitle("home");
            menu.setwindowX = 1680;
            menu.setwindowY = 1050;
        }

        if (sender instanceof Button && event.equals("goHome")){
            menu.setActivePage(HOME); //kunne være enum eller sådan noget
            menu.setTitle("home");
            menu.setwindowX = 1680;
            menu.setwindowY = 1050;
        }

        else{
            System.out.println("Not a valid call to mediator");
        }
    }
}
