package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {
	public static void mainMenu(){
		
		Boolean run = true;
		
		while( run ){

			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Listar produtos \n"
					+ "2) Listar prateleiras \n"
					+ "3) Sair");
			
			int option = Entity.checkInputInt();
		
			switch (option){
			
				case 1: 
					printProductList();
					menuProducts();
					break;
						
				case 2: 		
					printShelfList();
					menuShelf();
					break;
					
				case 3: 
					System.out.println("\nGood bye!");
					run = false;
					break;
						
				default: 
					System.out.println("\nInvalid input."
										+ "\n\nChoose a valid option!");
					break;
			}
		}
	}
	
	private static void menuProducts(){
		
		Boolean run = true;
		
		while( run  ){
			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Criar novo Produto \n"
					+ "2) Editar um produto existente \n"
					+ "3) Consultar o detalhe de um produto \n"
					+ "4) Remover um produto \n"
					+ "5) Voltar ao ecra anterior");
			
			int option = Entity.checkInputInt();
			
			long productId = 0;
			switch (option){
			
				case 1: //cria produto
					
					//cria novo produto
					ProductRepository.getInstance().consult(
							ProductRepository.getInstance().create(new Product())
							).create();
					
					printProductList();
					break;
				
				case 2: //edita produto
					
					if (ProductRepository.getInstance().consult().size() == 0) {
						System.out.println("There are no products!"
								+ "\nStart by creating one!");
					} else{	
						//get id
						System.out.println("\nQual o ID do produto a editar?");
						productId = Entity.checkInputLong();
						productId = ProductRepository.getInstance().checkId(productId);
						
						//edita um produto
						ProductRepository.getInstance().consult(productId).update();
					}
					
					printProductList();
					break;
						
				case 3: //consulta produto
					
					if (ProductRepository.getInstance().consult().size() == 0) {
						System.out.println("There are no products!"
								+ "\nStart by creating one!");	
					} else{
						//get id
						System.out.println("\nQual o ID do produto a consultar?");
						productId = Entity.checkInputLong();
						productId = ProductRepository.getInstance().checkId(productId);
						
						//mostra um produto
						ProductRepository.getInstance().consult(productId).show();
					}
					break;
					
				case 4://remove produto
					
					if (ProductRepository.getInstance().consult().size() == 0) {
						System.out.println("There are no products!"
								+ "\nStart by creating one!");	
					} else{
						//get id
						System.out.println("\nQual o ID do produto a remover?");
						productId = Entity.checkInputLong();
						productId = ProductRepository.getInstance().checkId(productId);
							
						ProductRepository.getInstance().remove(productId);
					}
					
					printProductList();
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
	
	private static void menuShelf(){
		
		Boolean run = true;
		
		while( run == true ){
			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Criar nova prateleira \n"
					+ "2) Editar uma prateleira existente \n"
					+ "3) Consultar o detalhe de uma prateleira \n"
					+ "4) Remover uma prateleira \n"
					+ "5) Voltar ao ecra anterior \n");
			
			int option = Entity.checkInputInt();
			
			long shelfId = 0;
			switch (option){
			
				case 1: //cria prateleira
					
					//cria nova prateleira
					ShelfRepository.getInstance().consult(
							ShelfRepository.getInstance().create(new Shelf())
						).create();
				
					printShelfList();					
					break;
					
				case 2: //editar prateleira
					
					if (ShelfRepository.getInstance().consult().size() == 0) {
						System.out.println("There are no shelfs!"
								+ "\nStart by creating one!");	
					} else{
						//pedido de ID
						System.out.println("\nQual o ID da prateleira a editar?");
						shelfId = Entity.checkInputLong();
						shelfId = ShelfRepository.getInstance().checkId(shelfId);
						
						//edita prateleira
						ShelfRepository.getInstance().consult(shelfId).update();
						
						printShelfList();
					}
					break;
						
				case 3: //consultar prateleira
					
					if (ShelfRepository.getInstance().consult().size() == 0) {
						System.out.println("There are no shelfs!"
								+ "\nStart by creating one!");	
					} else{
						//pedido de ID
						System.out.println("\nQual o ID da prateleira a consultar?");
						shelfId = Entity.checkInputLong();
						shelfId = ShelfRepository.getInstance().checkId(shelfId);
						
						//mostra prateleira
						ShelfRepository.getInstance().consult(shelfId).show();
					}
					break;
						
				case 4: // remover prateleira
					
					if (ShelfRepository.getInstance().consult().size() == 0) {
						System.out.println("There are no shelfs!"
								+ "\nStart by creating one!");	
					} else{
						//pedido de ID
						System.out.println("\nQual o ID da prateleira a remover?");
						shelfId = Entity.checkInputLong();
						shelfId = ShelfRepository.getInstance().checkId(shelfId);
						
						//remove prateleira
						ShelfRepository.getInstance().remove(shelfId);
					}
					break;
					
				case 5://volta ao menu anterior
					
					run = false;
					break;
				
				default: //repete o menu
					System.out.println("\nInvalid input..."
										+ "\n\nChoose a valid option!");
					break;
			}
		}
	}
	
	private static void printProductList(){
		//emite lista de produtos
		if (ProductRepository.getInstance().consult().size() != 0) {
			System.out.println("\nProduct List:");
			for (long i = 1; i <= ProductRepository.getInstance().consult().size(); i++) {
				ProductRepository.getInstance().consult(i).show();
			}
		} else{
			System.out.println("\nThere are no products!");
		}
	}
	
	private static void printShelfList(){
		//emite lista de prateleiras
		if (ShelfRepository.getInstance().consult().size() != 0) {
			System.out.println("\nShelf List:");
			for (long i = 1; i <= ShelfRepository.getInstance().consult().size(); i++) {
				ShelfRepository.getInstance().consult(i).show();
			}
		} else{
			System.out.println("\nThere are no shelfs!");
		}
	}
}
