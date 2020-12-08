package com.company.menu;

import com.company.Mediator;
import com.company.MediatorImpl;
import com.company.component.Button;

import java.util.Scanner;

public class Menu implements Mediator{

MediatorImpl mediator;
Button button;


    public void startMenu() {

        // consoleOutput.welcome
        notify(mediator, "welcome");

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        //button.buttonPress();

        switch (input) {
            //case 1-> System.out.println("create user"); // notify(mediator,"create") or logInMenu(sc);
            //case 2-> System.out.println("Log in"); //notify(mediator,"login") or createMenu(sc);
            //case 3-> {
                //notify(mediator,"exit");
                //System.out.println("exit");
                //break;
            //}

        }

    }

public void logInMenu(Scanner sc){
        notify(mediator, "printLoginMenu");

}
public void createUserMenu(Scanner sc){
        notify(mediator,"createUser");

}



    @Override
    public void notify(Object sender, String event) {

    }
}
