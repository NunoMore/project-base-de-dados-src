package io.altar.jseproject.stateinterface;

import io.altar.jseproject.model.Entity;

public class stateMainMenu extends State{
	
	public void on() {
		Boolean run = true;
		while( run ){

			System.out.println("\nPor favor selecione uma das seguintes opcoes: "
					+ "\n1) Listar produtos"
					+ "\n2) Listar prateleiras"
					+ "\n3) Sair");
			
			int option = Entity.checkInputInt();
			if (option == 1 || option == 2) {
				stateMachine.changeState(option);
			} else if (option == 3) {
				this.off();
			} else{
				System.out.println("\nNot a valid option!");
			}
			
		}
    }
	
	public void off(){
		stateMachine.off();
	}
}
