package com.company;

public class MediatorImpl implements Mediator<Component>{

    private Button Loginbutton;
    private Button okButton;
    private TextField textField;
    private String title;
    private int windowX;
    private int windowY;

    @Override
    public void notify(Component sender, String event) {
        if (sender == Loginbutton && event.equals("click")){
            //something something
            //log ind side
            // set title
            // set windowx
            // set windowy

            //tag logininformationer med
            // fra textfielkd usenmame
            // fra textfielkd password


        }
        else{
            //something else
            //vise fejl side
            // title fejl!
            //
        }

        if (sender == textField && event.equals("keypress")){
            //something something
        }
        else{
            //something else
        }
    }
}
