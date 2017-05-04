package io.altar.jseproject.model;

import java.util.Scanner;

import io.altar.jseproject.test.Test;

public class Shelf {
	public int id;
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
	
	public void show() {
		System.out.println("Produto " + this.getId() + ": (localizacao) " + 
				this.getLocation() +", (capacidade) " + 
				this.getCapacity() +", (id de produto exposto)" + 
				this.getProductId() +", (preco de aluguer) " + 
				this.getRentPrice() +"euros.\n");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
