package io.altar.jseproject.model;

public class Shelf {
	public int id;
	public int location;
	public int capacity;
	public int productId;
	public double rentPrice;
	
	
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
