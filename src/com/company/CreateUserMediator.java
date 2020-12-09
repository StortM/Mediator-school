package com.company;

import com.company.component.Button;
import com.company.component.Component;
import com.company.component.TextField;
import com.company.model.User;
import com.company.repository.CrudRepository;
import com.company.service.UserServiceImpl;

public class CreateUserMediator implements Mediator<Component> {

    private Button loginButton, createButton;
    private String usernameTextField, passwordTextField, firstNameTextField, lastNameTextField, emailTextField;
    private User user;
    private CrudRepository<User> crudRepository;
    private UserServiceImpl userService;

    public CreateUserMediator() {

    }

    public CreateUserMediator(String usernameTextField, String passwordTextField, String firstNameTextField, String lastNameTextField, String emailTextField) {
        this.usernameTextField = usernameTextField;
        this.passwordTextField = passwordTextField;
        this.firstNameTextField = firstNameTextField;
        this.lastNameTextField = lastNameTextField;
        this.emailTextField = emailTextField;
    }

    public void pushCreate() {
        User temp = new User();

        temp.setUsername(usernameTextField);
        temp.setFirstName(firstNameTextField);
        temp.setLastName(lastNameTextField);
        temp.setEmail(emailTextField);
        temp.setPassword(passwordTextField);
       // crudRepository.add(temp);
      //  userService.add(temp);
        System.out.println(temp.getUsername() + " added");
        System.out.println("\n Welcome " + temp.getFirstName() + " to The Mediator Club!");
        System.out.println("Your username is: " + temp.getUsername());


        //return createButton;
    }


    @Override
    public void notify(Component sender, String event) {

        if (sender.equals(createButton) && event.equals("CreateUser")) {
            user.setUsername(emailTextField);
            user.setFirstName(firstNameTextField);
            user.setLastName(lastNameTextField);
            user.setEmail(emailTextField);
            crudRepository.add(user);
            System.out.println(user.getUsername() + " added");

        }

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(String usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public String getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(String passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public String getFirstNameTextField() {
        return firstNameTextField;
    }

    public void setFirstNameTextField(String firstNameTextField) {
        this.firstNameTextField = firstNameTextField;
    }

    public String getLastNameTextField() {
        return lastNameTextField;
    }

    public void setLastNameTextField(String lastNameTextField) {
        this.lastNameTextField = lastNameTextField;
    }

    public String getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(String emailTextField) {
        this.emailTextField = emailTextField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    public Button getCreateButton() {
        return createButton;
    }

    public void setCreateButton(Button createButton) {
        this.createButton = createButton;
    }

}
