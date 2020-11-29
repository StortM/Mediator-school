package com.company.component;

import com.company.Mediator;

public class Component{
    final Mediator<Component> dialog;

    public Component(Mediator<Component> mediator) {
        this.dialog = mediator;
    }

    public void click(){
        dialog.notify(this,"click");
    }

    public void keypress(){
        dialog.notify(this,"keypress");
    }
}