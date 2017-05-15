package io.altar.jseproject.stateinterface;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

abstract class State {
	
	protected static ShelfRepository shelfRepository = ShelfRepository.getInstance();
	protected static ProductRepository productRepository = ProductRepository.getInstance();
	
	protected void on() {
        System.out.println("error");
    }

	protected void off() {
        System.out.println("error");
    }
	
	protected int checkOptions(int[] options){
		int input;
		while(true){
			System.out.println("As opcoes validas sao: " + options.toString()); 
			input = Entity.checkInputInt();
			for (int i = 0; i < options.length; i++) {
				if (options[i]==input) {
					return input;
				}
			}
			System.out.println("Escolha uma opcao valida!");
		}
	}
}
