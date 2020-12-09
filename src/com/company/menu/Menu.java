package com.company.menu;

import com.company.CreateUserMediator;
import com.company.Mediator;
import com.company.component.Component;
import com.company.component.TextField;
import com.company.model.User;
import com.company.service.UserServiceImpl;

import javax.swing.*;
import java.util.Scanner;

public class Menu {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static CreateUserMediator createUserMediator = new CreateUserMediator();
    private static UserServiceImpl userService = new UserServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        while (true) {
            System.out.println(userService.getAll());
            System.out.println("[1] - Create User");
            System.out.println("[2] - Login");
            System.out.print("\n Choice: ");
            choiceLoop();
        }
    }

    public static void choiceLoop() {
        String choice = scanner.next();

        switch (choice) {
            case "1":
                createUserMenu();
                break;
            case "2":
                logInMenu();
                break;
            default:
                System.out.println("Wrong input. Try again");
        }
    }

    public static void createUserMenu() {
        System.out.println("createUser");
        System.out.println("Welcome new user \n Please enter your firstname...");

        String input = scanner.next();
        createUserMediator.setFirstNameTextField(input);
        String userName = input;
        System.out.println("\n Please enter your Lastname...");
        input = scanner.next();
        createUserMediator.setLastNameTextField(input);

        userName = userName + input + (int) (Math.random() * 35);
        createUserMediator.setUsernameTextField(userName);

        // If-check om Username er i DB
        System.out.println("\n Please enter your Email adresse...");
        input = scanner.next();
        // If-check om Email er i DB
        createUserMediator.setEmailTextField(input);

        System.out.println("\n Please enter your Password...");

        input = scanner.next();

        createUserMediator.setPasswordTextField(input);
        // if-check if less than X chars
       createUserMediator.pushCreate();
       // createUserMediator.notify(createUserMediator.getCreateButton(), "CreateUser");
    }

    public static void logInMenu() {
        System.out.println("loginmenu");

        System.out.println("Welcome \n Please enter your Username...");
        String username = scanner.next();

        System.out.println("\n Please enter your Password...");
        String password = scanner.next();

        User validationResult = userService.validateUser(username, password);

        if (validationResult == null) {
            System.out.println(ANSI_RED + "Bad username or password!" + ANSI_RESET);
        } else {
            System.out.println("Welcome back " + ANSI_RED + validationResult.getUsername() + ANSI_RESET);
        }
    }
}