package com.company;

import com.company.component.Button;
import com.company.component.Component;
import com.company.component.TextField;
import com.company.model.User;
import com.company.repository.CrudRepository;

public class CreateUserMediator implements Mediator<Component>{

    private Button loginButton;
    private TextField usernameTextField;
    private TextField passwordTextField;
    private CrudRepository<User> crudRepository;

    public CreateUserMediator() {

    }

    public CreateUserMediator(Button loginButton, TextField usernameTextField, TextField passwordTextField) {
        this.loginButton = loginButton;
        this.usernameTextField = usernameTextField;
        this.passwordTextField = passwordTextField;
    }

    public void setPasswordFieldText(String text) {
        passwordTextField.setText(text);
    }

    public void setUsernameFieldText(String text) {
        usernameTextField.setText(text);
    }

    @Override
    public void notify(Component sender, String event) {

    }
}
