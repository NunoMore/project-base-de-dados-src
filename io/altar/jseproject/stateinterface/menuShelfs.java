package io.altar.jseproject.stateinterface;

import io.altar.jseproject.textinterface.TextInterface;

public class menuShelfs extends State{
    public void on() {
        TextInterface.menuShelf();
    }

    public void off() {
    	TextInterface.mainMenu();
    }

}
