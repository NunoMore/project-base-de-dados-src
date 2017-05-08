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

			System.out.println("\nPor favor selecione uma das seguintes opcoes: "
					+ "\n1) Listar produtos"
					+ "\n2) Listar prateleiras"
					+ "\n3) Sair");
			
			int option = Entity.checkInputInt();
		
			switch (option){
			
				case 1:
					ProductRepository.hasProducts();
					ProductRepository.printProductList();
					menuProducts();
					break;
						
				case 2: 	
					ShelfRepository.hasShelfs();
					ShelfRepository.printShelfList();
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
	
	public static void menuProducts(){
		
		Boolean run = true;
		
		while( run  ){
			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Criar novo Produto \n"
					+ "2) Editar um produto existente \n"
					+ "3) Consultar o detalhe de um produto \n"
					+ "4) Remover um produto \n"
					+ "5) Voltar ao ecra anterior");
			
			int option = Entity.checkInputInt();
			
			switch (option){
			
				case 1: //cria produto
					
					//cria novo produto
					ProductRepository.getInstance().create(new Product());
					ProductRepository.printProductList();
					break;
				
				case 2: //edita produto
					
					if (ProductRepository.hasProducts()){
						//get id
						System.out.println("\nQual o ID do produto a editar?");
						long productId = Entity.checkInputLong();
						productId = ProductRepository.getInstance().checkId(productId);
						
						//edita um produto
						ProductRepository.getInstance().consult(productId).update();
					}
					
					ProductRepository.printProductList();
					break;
						
				case 3: //consulta produto
					
					if (ProductRepository.hasProducts()){
						//get id
						System.out.println("\nQual o ID do produto a consultar?");
						long productId = Entity.checkInputLong();
						productId = ProductRepository.getInstance().checkId(productId);
						
						//mostra um produto
						ProductRepository.getInstance().consult(productId).show();
					}
					break;
					
				case 4://remove produto
					
					if (ProductRepository.hasProducts()){
						//get id
						System.out.println("\nQual o ID do produto a remover?");
						long productId = Entity.checkInputLong();
						productId = ProductRepository.getInstance().checkId(productId);
						
						boolean keep = Entity.keepValue();
						
						if (!keep) {
							System.out.println("\nO valor foi removido.");
							ProductRepository.getInstance().remove(productId);
						}else {
							System.out.println("\nOperacao anulada!");
						}
					}
					
					ProductRepository.printProductList();
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
	
	public static void menuShelf(){
		
		Boolean run = true;
		
		while( run == true ){
			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Criar nova prateleira \n"
					+ "2) Editar uma prateleira existente \n"
					+ "3) Consultar o detalhe de uma prateleira \n"
					+ "4) Remover uma prateleira \n"
					+ "5) Voltar ao ecra anterior \n");
			
			int option = Entity.checkInputInt();
			
			switch (option){
			
				case 1: //cria prateleira
					
					//cria nova prateleira
					ShelfRepository.getInstance().create(new Shelf());
				
					ShelfRepository.printShelfList();
					break;
					
				case 2: //editar prateleira
					
					if (ShelfRepository.hasShelfs()){
						//pedido de ID
						System.out.println("\nQual o ID da prateleira a editar?");
						long shelfId = Entity.checkInputLong();
						shelfId = ShelfRepository.getInstance().checkId(shelfId);
						
						//edita prateleira
						ShelfRepository.getInstance().consult(shelfId).update();
					}
					
					ShelfRepository.printShelfList();
					break;
						
				case 3: //consultar prateleira
					
					if (ShelfRepository.hasShelfs()){
						//pedido de ID
						System.out.println("\nQual o ID da prateleira a consultar?");
						long shelfId = Entity.checkInputLong();
						shelfId = ShelfRepository.getInstance().checkId(shelfId);
						
						//mostra prateleira
						ShelfRepository.getInstance().consult(shelfId).show();
					}
					break;
						
				case 4: // remover prateleira
					
					if (ShelfRepository.hasShelfs()){
						//pedido de ID
						System.out.println("\nQual o ID da prateleira a remover?");
						long shelfId = Entity.checkInputLong();
						shelfId = ShelfRepository.getInstance().checkId(shelfId);
						
						boolean keep = Entity.keepValue();
						
						if (!keep) {
							System.out.println("\nO valor foi removido.");
							ShelfRepository.getInstance().remove(shelfId);
						}else {
							System.out.println("\nOperacao anulada!");
						}
					}
					
					ShelfRepository.printShelfList();
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
}
