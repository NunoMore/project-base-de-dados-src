package io.altar.jseproject.stateinterface;

import io.altar.jseproject.textinterface.TextInterface;

public class stateMenuProducts extends State{
    public void on() {

		String entidade = "produto";
		productRepository.has(entidade);
		productRepository.printList(entidade);
		
		subMenu(productRepository, entidade); 
		break;
		
        TextInterface.subMenu(productRepository, "produto");
    }

    public void off() {
        TextInterface.mainMenu();
    }

    public void ack() {
        System.out.println("A + ack = A");
    }

}
