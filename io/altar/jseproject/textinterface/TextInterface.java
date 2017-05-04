package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.test.Test;

public class TextInterface {
	
	public static void mainMenu(){
		
		Scanner sc = new Scanner(System.in);
		int option = 0;
		
		while( option!=3 ){

			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Listar produtos \n"
					+ "2) Listar prateleiras \n"
					+ "3) Sair");
			
			try {
				option = Integer.parseInt( sc.nextLine() );
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		
			switch (option){
			
				case 1: if(Test.products.isEmpty()){
							System.out.println("\nThere are no products.");
						} else{
							System.out.println("\nProduct List:");
							for (int i = 0; i < Test.products.size(); i++) {
								Test.products.get(i).show();
							}
						}
						screenOption1(sc);
						
						break;
						
				case 2: if(Test.shelfs.isEmpty()){
							System.out.println("\nThere are no shelfs.");
						} else{
							System.out.println("\nShelf List:");
							for (int i = 0; i < Test.shelfs.size(); i++) {
								System.out.println("Prateleira " + Test.shelfs.get(i).id + ".\n");
							}
						}
						screenOption2(sc);
						
						break;
						
				case 3: System.out.println("\nGood bye!");
						sc.close();
						
						break;
						
				default: System.out.println("\nInvalid input...");
						break;
			}
		}
	}
	
	public static void screenOption1(Scanner sc){
		
		int option = 0;
		
		while( option!=5 ){
			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Criar novo Produto \n"
					+ "2) Editar um produto existente \n"
					+ "3) Consultar o detalhe de um produto \n"
					+ "4) Remover um produto \n"
					+ "5) Voltar ao ecra anterior");
			try {
				option = Integer.parseInt( sc.nextLine() );
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		
			switch (option){
			
				case 1: //cria novo produto
						Test.products.add(new Product());
						
						Test.products.get( Test.products.size() -1 ).create(sc); 
						
						//emite lista de produtos
						System.out.println("\nProduct List:");
						for (int i = 0; i < Test.products.size(); i++) {
							Test.products.get(i).show();
						}
						
						break;
				
				case 2: //pedido de ID
						int productId = 0;
						while(true){
							System.out.println("\nQual o ID do produto a editar?");
							try {
								productId = Integer.parseInt( sc.nextLine() );
								break;
							} catch (Exception e){
								System.out.println("\nInput is not a number!");
							}
						}
						
						Test.products.get(productId).update(sc);
						
						
//						//alterar prateleiras de exposicao
//						int[] shelfId;
//						while(true){
//							System.out.println("\nAlterar prateleiras de exposicao."
//												+ "\nDeve colocar novamente mesmo que queira manter a exposicao corrente."
//												+ "\nDe momento o produto está exposto nas prateleiras:");
//							
//							for(int i = 0; i < Test.products.get( productId ).getShelfId().length; i++){
//								System.out.println( Test.products.get( productId ).getShelfId()[i] +"; ");
//							}
//							System.out.println("end.");
//							System.out.println("\nColoque um id de exposicao: ");
//							try {
//								discount = Integer.parseInt( sc.nextLine() );
//								break;
//							} catch (Exception e){
//								System.out.println("\nInput is not a number!");
//							}
//						}
//						Test.products.get( productId ).setDiscount( discount );

						
						break;
				case 3:
					
						break;
				case 4:
					
						break;
				case 5: break;
				default: System.out.println("\nInvalid input...");
						break;
			}
		}
	}
	
	public static void screenOption2(Scanner sc){
		
		int option = 0;
		
		while( option!=5 ){
			System.out.println("\nPor favor selecione uma das seguintes opcoes: \n"
					+ "1) Criar nova prateleira \n"
					+ "2) Editar uma prateleira existente \n"
					+ "3) Consultar o detalhe de uma prateleira \n"
					+ "4) Remover uma prateleira \n"
					+ "5) Voltar ao ecra anterior \n");
			
			try {
				option = Integer.parseInt( sc.nextLine() );
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
			
			switch (option){
			
				case 1: Test.shelfs.add(new Shelf());
						System.out.println("\nNova prateleira criada!");
				
						System.out.println("\nShelf List:");
						for (int i = 0; i < Test.shelfs.size(); i++) {
							Test.shelfs.get(i).show();
						}
						break;
					
				case 2: 
						break;
				case 3:
						break;
				case 4:
						break;
				case 5: break;
				default: System.out.println("\nInvalid input...");
			}
		}
	}
	
	
}
