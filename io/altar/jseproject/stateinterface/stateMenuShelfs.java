package io.altar.jseproject.stateinterface;

import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.textinterface.TextInterface;

public class stateMenuShelfs extends State{
    public void on() {
        TextInterface.subMenu(ShelfRepository.getInstance(), "prateleira");
    }

    public void off() {
    	TextInterface.mainMenu();
    }

}
