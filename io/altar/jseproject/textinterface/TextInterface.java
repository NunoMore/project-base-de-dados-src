package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {
	
	public static void mainMenu(){
		
		Scanner sc1 = new Scanner(System.in);
		
		Boolean run = true;
		
		while( run == true ){

			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Listar produtos \n"
					+ "2) Listar prateleiras \n"
					+ "3) Sair");
			
			while(!sc1.hasNextInt()){
				System.out.println("\nInput is not a valid number!");
				sc1.next();
			}
			int option = sc1.nextInt();
		
			switch (option){
			
				case 1: 
					//emite lista de produtos
					if (ProductRepository.getInstance().consult().size() != 0) {
						System.out.println("\nProduct List:");
						for (long i = 1; i <= ProductRepository.getInstance().consult().size(); i++) {
							ProductRepository.getInstance().consult(i).show();
						}
					} else{
						System.out.println("\nThere are no products!");
					}
					
					screenOption1();
					
					break;
						
				case 2: 
					//emite lista de prateleiras
					if (ShelfRepository.getInstance().consult().size() != 0) {
						System.out.println("\nShelf List:");
						for (long i = 1; i <= ShelfRepository.getInstance().consult().size(); i++) {
							ShelfRepository.getInstance().consult(i).show();
						}
					} else{
						System.out.println("\nThere are no shelfs!");
					}
					
					screenOption2();
					
					break;
					
				case 3: 
					System.out.println("\nGood bye!");
					run = false;
						
					break;
						
				default: 
					System.out.println("\nInvalid input...");
					break;
			}
		}
	}
	
	public static void screenOption1(){
		Scanner sc2 = new Scanner(System.in);
		
		Boolean run = true;
		
		while( run == true ){
			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Criar novo Produto \n"
					+ "2) Editar um produto existente \n"
					+ "3) Consultar o detalhe de um produto \n"
					+ "4) Remover um produto \n"
					+ "5) Voltar ao ecra anterior");
			
			while(!sc2.hasNextInt()){
				System.out.println("\nInput is not an integer!");
				sc2.next();
			}
			int option = sc2.nextInt();
			
			long productId = 0;
			switch (option){
			
				case 1: //cria novo produto
						ProductRepository.getInstance().consult(
								ProductRepository.getInstance().create(new Product())
								).create();
						
						//emite lista de produtos						
						System.out.println("\nProduct List:");
						for (long i = 1; i <= ProductRepository.getInstance().consult().size(); i++) {
							ProductRepository.getInstance().consult(i).show();
						}
						
						break;
				
				case 2: //pedido de ID
						while(!sc2.hasNextLong()){
							System.out.println("\nInput is not a valid number!");
							sc2.next();
						}
						productId = sc2.nextLong();
						
						ProductRepository.getInstance().consult(productId).update();
						
						//emite lista de produtos						
						System.out.println("\nProduct List:");
						for (long i = 0; i < ProductRepository.getInstance().consult().size(); i++) {
							ProductRepository.getInstance().consult(i).show();
						}

						break;
						
				case 3: 
					//pedido de ID
					while(!sc2.hasNextLong()){
						System.out.println("\nInput is not a valid number!");
						sc2.next();
					}
					productId = sc2.nextLong();
						
					ProductRepository.getInstance().consult(productId).show();
				
					break;
					
				case 4:
					//pedido de ID
					while(!sc2.hasNextLong()){
						System.out.println("\nInput is not a valid number!");
						sc2.next();
					}
					productId = sc2.nextLong();
						
					ProductRepository.getInstance().remove(productId);
				
					break;
						
				case 5: 
					run = false;
					break;
				
				default: 
					System.out.println("\nInvalid input...");
					break;
			}
		}
//		sc2.close();
	}
	
	public static void screenOption2(){
		Scanner sc3 = new Scanner(System.in);
		
		int option = 0;
		
		while( option!=5 ){
			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Criar nova prateleira \n"
					+ "2) Editar uma prateleira existente \n"
					+ "3) Consultar o detalhe de uma prateleira \n"
					+ "4) Remover uma prateleira \n"
					+ "5) Voltar ao ecra anterior \n");
			
			try {
				option = Integer.parseInt( sc3.nextLine() );
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
			
			long shelfId = 0;
			
			switch (option){
			
				case 1: //cria nova prateleira
						ShelfRepository.getInstance().consult(
								ShelfRepository.getInstance().create(new Shelf())
							).create();
					
						//emite lista de prateleiras						
						System.out.println("\nShelf List:");
						for (long i = 0; i < ShelfRepository.getInstance().consult().size(); i++) {
							ShelfRepository.getInstance().consult(i).show();
						}
						
						break;
					
				case 2: //pedido de ID
						shelfId = 0;
						while(true){
							System.out.println("\nQual o ID da prateleira a editar?");
							try {
								shelfId = Long.parseLong( sc3.nextLine() );
								break;
							} catch (Exception e){
								System.out.println("\nInput is not a number!");
							}
						}
						
						ShelfRepository.getInstance().consult(shelfId).update();
						
						//emite lista de prateleiras						
						System.out.println("\nShelf List:");
						for (long i = 0; i < ShelfRepository.getInstance().consult().size(); i++) {
							ShelfRepository.getInstance().consult(i).show();
						}
					
						break;
						
				case 3: //pedido de ID
						shelfId = 0;
						while(true){
							System.out.println("\nQual o ID da prateleira a consultar?");
							try {
								shelfId = Long.parseLong( sc3.nextLine() );
								break;
							} catch (Exception e){
								System.out.println("\nInput is not a number!");
							}
						}
						
						ShelfRepository.getInstance().consult(shelfId).show();
					
						break;
						
				case 4://pedido de ID
						shelfId = 0;
						while(true){
							System.out.println("\nQual o ID da prateleira a remover?");
							try {
								shelfId = Long.parseLong( sc3.nextLine() );
								break;
							} catch (Exception e){
								System.out.println("\nInput is not a number!");
							}
						}
						
						ShelfRepository.getInstance().remove(shelfId);
					
						break;
						
				case 5: break;
				
				default: System.out.println("\nInvalid input...");
						break;
			}
		}
//		sc3.close();
	}
}
