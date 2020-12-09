package com.company.component;

import com.company.Mediator;

public class Button extends Component {

    public Button(Mediator<Component> mediator) {
        super(mediator);
    }

    @Override
    public void keypress() {
        super.keypress();
    }

    @Override
    public void click() {
        super.click();
    }

    public void loginClick(){
        System.out.println("login click");
        dialog.notify(this,"loginClick");
    }

    public void createUserClick(){
        System.out.println("createUserClick");
        dialog.notify(this,"createUserClick");
    }
}
