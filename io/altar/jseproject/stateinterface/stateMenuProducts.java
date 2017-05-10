package io.altar.jseproject.stateinterface;


public class stateMenuProducts extends StateMenu{
    public void on() { //Listar produtos

		String entidade = "produto";
		PRODUCT_REPOSITORY.has(entidade);
		PRODUCT_REPOSITORY.printList(entidade);
		
		subMenu(PRODUCT_REPOSITORY, entidade); 
    }

    public void off() { 
    	stateMachine.changeState(0);
    }
}
