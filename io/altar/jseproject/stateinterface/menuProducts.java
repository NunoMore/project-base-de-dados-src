package io.altar.jseproject.stateinterface;

import io.altar.jseproject.textinterface.TextInterface;

public class menuProducts extends State{
    public void on() {
        TextInterface.menuProducts();
    }

    public void off() {
        TextInterface.mainMenu();
    }

    public void ack() {
        System.out.println("A + ack = A");
    }

}
