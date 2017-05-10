package io.altar.jseproject.stateinterface;


public class stateMenuShelfs extends StateMenu{
    public void on() { //Listar prateleiras

		String entidade = "prateleira";
		SHELF_REPOSITORY.has(entidade);
		SHELF_REPOSITORY.printList(entidade);
		
		subMenu(SHELF_REPOSITORY, entidade); 
    }

    public void off() {
    	stateMachine.changeState(0);
    }
}
