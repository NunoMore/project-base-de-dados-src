package io.altar.jseproject.stateinterface;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class StateSubMenu extends State{
	
	protected void on(){

		entidade = entidade.trim().toLowerCase(); //para o simples caso de receber espacos ou maiusculas na palavra 'produto' ou 'prateleira'
		
		Boolean run = true;		
		while( run  ){
			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Criar novo(a) "+ entidade +" \n"
					+ "2) Editar um(a) "+ entidade +" existente \n"
					+ "3) Consultar o detalhe de um(a) "+ entidade + " \n"
					+ "4) Remover um(a) "+ entidade + " \n" 
					+ "5) Voltar ao ecra anterior");
			
			int option = Entity.checkInputInt();
			switch (option){
			
				case 1: //cria entidade
					
					Entity item = new Entity();
					if(entidade.equals("produto")){
						item = new Product();
					}
					else if(entidade.equals("prateleira")){
						item = new Shelf();
					}
					repository.create(item);
					repository.printList(entidade);
					break;
				
				case 2: //edita entidade
					
					repository.edit(entidade);
					break;
						
				case 3: //consulta entidade
					
					repository.consult(entidade);
					break;
					
				case 4://remove entidade
					
					repository.remove(entidade);
					break;
						
				case 5: //volta ao menu anterior
					run = false;
					break;
				
				default: //mostra novamente o menu
					System.out.println("\nInvalid input..."
										+ "\n\nChoose a valid option!");
					break;
			}
		}
	}
}
