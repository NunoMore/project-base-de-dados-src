package io.altar.jseproject.model;

import java.util.Scanner;

public class Shelf extends Entity{
	public int location;
	public int capacity;
	public int productId;
	public double rentPrice;
	
	public void create() {
		
		Scanner sc = new Scanner(System.in);
		
		//coloca localizacao (se nao for integer tem de ser alterado este codigo !!!!)
		int intAux = 0;
		while(true){
			System.out.println("\nQual a localizacao da prateleira? (codigo unitario)");
			try {
				intAux = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setLocation(intAux);
				
		//coloca capacidade
		intAux = 0;
		while(true){
			System.out.println("\nQual a capacidade da prateleira (produtos)? (valor unitario)");
			try {
				intAux = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setCapacity(intAux);
		
		//coloca preco de aluguer
		double doubleAux = 0;
		while(true){
			System.out.println("\nQual o preco de aluguer da prateleira (euros)?");
			try {
				doubleAux = Double.parseDouble( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setRentPrice(doubleAux);
		
		//coloca product ID
		intAux = 0;
		while(true){
			System.out.println("\nQual o ID do produto a colocar na prateleira? (valor unitario)");
			try {
				intAux = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setProductId(intAux);
		sc.close();
	}
	
	public void update(){
		
		System.out.println("\nCaso deseje manter algum campo basta clicar em 'enter' com o campo vazio.");
		Scanner sc = new Scanner(System.in);
		
		//alterar capacidade
		int intAux = 0;
		while(true){
			System.out.println("\nAlterar capacidade("+ this.getCapacity() +"): ");
			try {
				intAux = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a valid number!");
			}
		}
		this.setCapacity(intAux);
		
		//alterar localizacao
		intAux = 0;
		while(true){
			System.out.println("\nAlterar codigo de localizacao("+ this.getLocation() +"): ");
			try {
				intAux = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a valid number!");
			}
		}
		this.setLocation(intAux);
		
		//alterar preco de aluguer
		double doubleAux = 0;
		while(true){
			System.out.println("\nAlterar preco de aluguer("+ this.getRentPrice() +"euros): ");
			try {
				doubleAux = Double.parseDouble( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setRentPrice(doubleAux);
		
		//alterar produto
		intAux = 0;
		while(true){
			System.out.println("\nDe momento existe o produto "+ this.getProductId() +"."
								+ "\nCaso pretenda manter coloque de novo o ID a que se refere.");
			try {
				if (sc.nextLine()==null) {
					System.out.println("Nao foi colocado qualquer produto na prateleira.");
					break;
				}
				intAux = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a valid number!");
			}
		}
		this.setProductId(intAux);
		sc.close();
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
