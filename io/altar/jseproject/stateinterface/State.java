package io.altar.jseproject.stateinterface;

import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class State {

	protected static stateMachine stateMachine = new stateMachine();
	protected static ShelfRepository shelfRepository = ShelfRepository.getInstance();
	protected static ProductRepository productRepository = ProductRepository.getInstance();
	
	public void on() {
        System.out.println("error");
    }

    public void off() {
        System.out.println("error");
    }
}
