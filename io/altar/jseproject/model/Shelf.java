package io.altar.jseproject.model;

import java.util.Scanner;

import io.altar.jseproject.test.Test;

public class Shelf extends Entity{
	public int location;
	public int capacity;
	public int productId;
	public double rentPrice;
	
	public void create(Scanner sc) {
		
		//coloca id
		this.setId(Test.shelfs.size() -1); 
		
		//coloca localizacao (se nao for integer tem de ser alterado este codigo !!!!)
		int location = 0;
		while(true){
			System.out.println("\nQual a localizacao da prateleira? (codigo unitario)");
			try {
				location = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setLocation(location);
				
		//coloca capacidade
		int capacity = 0;
		while(true){
			System.out.println("\nQual a capacidade da prateleira (produtos)? (valor unitario)");
			try {
				capacity = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setCapacity(capacity);
		
		//coloca preco de aluguer
		double price = 0;
		while(true){
			System.out.println("\nQual o preco de aluguer da prateleira (euros)?");
			try {
				price = Double.parseDouble( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setRentPrice(price);
		
	}
	
	public void update(Scanner sc){
		
		System.out.println("\nCaso deseje manter algum campo basta clicar em 'enter' com o campo vazio.");
		
		//alterar capacidade
		int capacity = 0;
		while(true){
			System.out.println("\nAlterar capacidade("+ this.getCapacity() +"): ");
			try {
				capacity = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a valid number!");
			}
		}
		this.setCapacity(capacity);
		
		//alterar localizacao
		int location = 0;
		while(true){
			System.out.println("\nAlterar codigo de localizacao("+ this.getLocation() +"): ");
			try {
				location = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a valid number!");
			}
		}
		this.setLocation(location);
		
		//alterar preco de aluguer
		double price = 0;
		while(true){
			System.out.println("\nAlterar preco de aluguer("+ this.getRentPrice() +"euros): ");
			try {
				price = Double.parseDouble( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setRentPrice(price);
		
		//alterar produto
		int product = 0;
		while(true){
			System.out.println("\nDe momento existe o produto "+ this.getProductId() +"."
								+ "\nCaso pretenda manter coloque de novo o ID a que se refere.");
			try {
				if (sc.nextLine()==null) {
					System.out.println("Nao foi colocado qualquer produto na prateleira.");
					break;
				}
				product = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a valid number!");
			}
		}
		this.setProductId(product);
	}
	
	public void show() {
		System.out.println("Produto " + this.getId() + ": (localizacao) " + 
				this.getLocation() +", (capacidade) " + 
				this.getCapacity() +", (id de produto exposto)" + 
				this.getProductId() +", (preco de aluguer) " + 
				this.getRentPrice() +"euros.\n");
	}
	
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	

}
