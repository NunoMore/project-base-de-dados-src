package io.altar.jseproject.model;

import java.util.Scanner;

import io.altar.jseproject.repositories.ProductRepository;

public class Shelf extends Entity{
	public int location;
	public int capacity;
	public long productId;
	public double rentPrice;
	
	public Shelf(){
		
		Scanner sc = new Scanner(System.in);
		
		//coloca localizacao (se nao for integer tem de ser alterado este codigo !!!!)
		System.out.println("\nQual a localizacao da prateleira? (codigo unitario)");
		int intAux = checkInputInt();
		this.setLocation(intAux);
				
		//coloca capacidade
		System.out.println("\nQual a capacidade da prateleira (produtos)? (valor unitario)");
		intAux = checkInputInt();
		this.setCapacity(intAux);
		
		//coloca preco de aluguer
		System.out.println("\nQual o preco de aluguer da prateleira (euros)?");
		double doubleAux = checkInputDouble();
		this.setRentPrice(doubleAux);
		
		//coloca product ID
		System.out.println("\nQual o ID do produto a colocar na prateleira? (valor unitario)");
		long id = checkInputLong();
		id = ProductRepository.getInstance().checkId(id);
		this.setProductId(id);
		ProductRepository.getInstance().consult(id).shelfId.add( this.getId() ); 
		
//		sc.close();  //devo fechar??? da erro ao fechar...
	}
	
	public void update(){
		
//		System.out.println("\nCaso deseje manter algum campo basta clicar em 'enter' com o campo vazio.");
		Scanner sc = new Scanner(System.in);
		
		//alterar capacidade
		System.out.println("\nAlterar capacidade("+ this.getCapacity() +"): ");
		int intAux = checkInputInt();
		this.setCapacity(intAux);
		
		//alterar localizacao //podera ser alterado por nao ser um int ???
		System.out.println("\nAlterar codigo de localizacao("+ this.getLocation() +"): ");
		intAux = checkInputInt();
		this.setLocation(intAux);
		
		//alterar preco de aluguer
		System.out.println("\nAlterar preco de aluguer("+ this.getRentPrice() +"euros): ");
		double doubleAux = checkInputDouble();
		this.setRentPrice(doubleAux);
		
		//alterar produto
		System.out.println("\nDe momento existe o produto "+ this.getProductId() +"."
							+ "\nCaso pretenda manter coloque de novo o ID a que se refere.");
		
		ProductRepository.getInstance().consult( this.getProductId() ).shelfId.remove( this.getId() );
		long id = checkInputLong();
		id = ProductRepository.getInstance().checkId(id);
		this.setProductId(id);
		ProductRepository.getInstance().consult(id).shelfId.add( this.getId() );
		
//		sc.close();  //devo fechar??? da erro ao fechar...
	}
	
	public void show() {
		System.out.println("Prateleira " + this.getId() + ": (localizacao) " + 
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
