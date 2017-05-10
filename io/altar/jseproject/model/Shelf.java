package io.altar.jseproject.model;

import java.util.Scanner;

import io.altar.jseproject.repositories.ProductRepository;

public class Shelf extends Entity{
	private String location;
	private int capacity;
	private long productId;
	private double rentPrice;
	
	public Shelf(){
		
		Scanner sc = new Scanner(System.in);
		
		//coloca localizacao 
		System.out.println("\nQual a localizacao da prateleira?");
		String location = sc.nextLine();
		this.setLocation(location);

		sc.close();  //devo fechar??? da erro ao fechar...

		//coloca capacidade
		System.out.println("\nQual a capacidade da prateleira (produtos)? (valor unitario)");
		int intAux = checkInputInt();
		this.setCapacity(intAux);
		
		//coloca preco de aluguer
		System.out.println("\nQual o preco de aluguer da prateleira (euros)?");
		double doubleAux = checkInputDouble();
		this.setRentPrice(doubleAux);
		
		//coloca product ID
		String msg = "\nQual o ID do produto a colocar na prateleira? (valor unitario)";
		long id = ProductRepository.getInstance().checkId(msg);
		this.setProductId(id);
		if (ProductRepository.getInstance().has("produto")) {
			ProductRepository.getInstance().get(id).addShelfId(this.getId());
		}
	}
	
	public void update(){
		
		//alterar localizacao //podera ser alterado por nao ser um int ???
		System.out.println("\nAlterar codigo de localizacao("+ this.getLocation() +"): ");
		boolean keep = keepValue();

		Scanner sc = new Scanner(System.in);
		if (!keep) {
			System.out.println("Introduza nova localizacao:");
			this.setLocation(sc.nextLine() );
		}		
		sc.close();  //devo fechar??? da erro ao fechar...
		
		//alterar capacidade
		System.out.println("\nAlterar capacidade("+ this.getCapacity() +"): ");
		keep = keepValue();
		
		if (!keep) {
			System.out.println("Introduza o novo valor de capacidade:");
			this.setCapacity(checkInputInt());
		}
		
		//alterar preco de aluguer
		System.out.println("\nAlterar preco de aluguer("+ this.getRentPrice() +"euros): ");
		
		keep = keepValue();
		if (!keep) {
			System.out.println("Introduza o novo preco de aluguer:");
			this.setRentPrice(checkInputDouble());
		}
		
		//alterar produto
		if (ProductRepository.getInstance().has("produto")) { 
			System.out.println("\nAlterar produto existente(Produto "+ this.getProductId() +"): ");
			 
			keep = keepValue();
			if (!keep) {
				if (this.getProductId()!=0) {
					ProductRepository.getInstance().get( this.getProductId() ).removeShelfId(this.getId());
				}
				String msg = "Introduza o ID do novo produto para a prateleira:";
				long id = ProductRepository.getInstance().checkId(msg);
				this.setProductId(id);
				ProductRepository.getInstance().get(id).addShelfId(id); 
			}
		} else {
			System.out.println("\nNao existem produtos! - 0");
		}
	}
	
	public void show() {
		System.out.println("Prateleira " + this.getId() + ": (localizacao) " + 
				this.getLocation() +", (capacidade) " + 
				this.getCapacity() +", (id de produto exposto) " + 
				this.getProductId() +", (preco de aluguer) " + 
				this.getRentPrice() +"euros.");
	} 
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
}
