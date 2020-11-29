package com.company;

public class TextField extends Component{
    private String text = "";

    public TextField(Mediator<Component> mediator) {
        super(mediator);
    }

    public void actionMethod(){
        //something somehting

        dialog.notify();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
