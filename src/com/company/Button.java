package com.company;

public class Button extends Component {

    public Button(Mediator<Component> mediator) {
        super(mediator);
    }


    public void buttonPress(){
        //something something

        //call other class

        dialog.notify(this,"click");

    }
}
