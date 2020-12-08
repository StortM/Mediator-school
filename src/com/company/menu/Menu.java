package com.company.menu;

import com.company.MediatorImpl;
import com.company.model.User;

import java.util.Scanner;

public class Menu {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    MediatorImpl mediator;
    int windowX = 150;
    int windowY = 100;
    String title = "Start title";


    public void startMenu() {
        System.out.println("The title of the frame is " + title);
        System.out.println("The size of this frame is " + windowX + " wide and " + windowY + " high");
    }

    public void createUserMenu() {
        System.out.println("createUser");
        Scanner scanner = new Scanner(System.in);
        User tempUser = new User();
        System.out.println("Welcome new user \n Please enter your firstname...");
        String input = scanner.nextLine();
        tempUser.setFirstName(input);
        System.out.println("\n Please enter your Lastname...");
        input = scanner.nextLine();
        tempUser.setLastName(input);
        tempUser.setUsername(tempUser.getFirstName() + tempUser.getLastName() + (Math.random() * 35));
        // If-check om Username er i DB
        System.out.println("\n Please enter your Email adresse...");
        input = scanner.nextLine();
        // If-check om Email er i DB
        tempUser.setEmail(input);
        System.out.println("\n Please enter your Email adresse...");
        input = scanner.nextLine();
        // if-check if less than X chars
        tempUser.setPassword(input);
        // Send tempUser to MockDB
        System.out.println("\n Welcome "+ ANSI_RED +tempUser.getFirstName() + ANSI_RESET + " to The Mediator Club!");
        scanner.close();
        // MainMenu(tempUser) ?
    }

    public void logInMenu() {
        System.out.println("loginmenu");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome \n Please enter your Username...");
        String input = scanner.nextLine();
        User tempUser = new User();
        tempUser.setUsername(input);
        System.out.println("\n Please enter your Password...");
        input = scanner.nextLine();
        tempUser.setPassword(input);
        // Sendt tempUser to DB , check if els "Wrong information, Try again... logInMenu()
        System.out.println("Welcome back "+ ANSI_RED +tempUser.getFirstName() + ANSI_RESET);
        // MainMenu(tempUser) ?
    }


    public int getWindowX() {
        return windowX;
    }

    public void setWindowxX(int windowxX) {
        this.windowX = windowxX;
    }

    public int getWindowY() {
        return windowY;
    }

    public void setWindowY(int windowY) {
        this.windowY = windowY;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
