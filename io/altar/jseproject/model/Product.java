package io.altar.jseproject.model;

import java.util.Scanner;

import io.altar.jseproject.test.Test;


public class Product {
	public int id;
	public String name;
	public int[] shelfId;
	public int discount;
	public double iva;
	public double pvp;
	
	public void create(Scanner sc){
		
		//coloca id
		this.setId(Test.products.size() -1); 
		
		//coloca nome
		System.out.println("\nQual o nome do produto?");
		String productName = sc.nextLine();
		this.setName(productName);
		
		//coloca desconto
		int productDiscount = 0;
		while(true){
			System.out.println("\nQual o desconto do produto (%)? (valor unitario em percentagem)");
			try {
				productDiscount = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setDiscount(productDiscount);
		
		//coloca iva
		double productIva = 0;
		while(true){
			System.out.println("\nQual o IVA do produto(%)?");
			try {
				productIva = Double.parseDouble( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setIva(productIva);
		
		//coloca pvp
		double productPvp = 0;
		while(true){
			System.out.println("\nQual o PVP do produto(euros)?");
			try {
				productPvp = Double.parseDouble( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setPvp(productPvp);
	}
	
	public void update(Scanner sc) {
		
		System.out.println("\nCaso deseje manter algum campo basta clicar em 'enter'.");
		
		//alterar nome
		System.out.println("\nAlterar nome("+ this.getName() +"): ");
		this.setName( sc.nextLine() );
		
		//alterar pvp
		double pvp = 0;
		while(true){
			System.out.println("\nAlterar PVP("+ this.getPvp() +"euros): ");
			try {
				pvp = Double.parseDouble( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setPvp( pvp );
		
		//alterar iva
		double iva = 0;
		while(true){
			System.out.println("\nAlterar IVA("+ this.getIva() +"%): ");
			try {
				iva = Double.parseDouble( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setIva( iva );
		
		//alterar desconto
		int discount = 0;
		while(true){
			System.out.println("\nAlterar desconto("+ this.getDiscount() +"%): ");
			try {
				discount = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setDiscount( discount );
	}
	
	public void show() {
		System.out.println("Produto " + this.getId() + ": (nome) " + 
							this.getName() +", (PVP) " + 
							this.getPvp() +"euros, (IVA)" + 
							this.getIva() +"%, (desconto) " + 
							this.getDiscount() +"%.\n");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name!=null){
			this.name = name;
		}
	}
	public int[] getShelfId() {
		return shelfId;
	}
	public void setShelfId(int[] shelfId) {
		this.shelfId = shelfId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getPvp() {
		return pvp;
	}
	public void setPvp(double pvp) {
		this.pvp = pvp;
	}
	
}
