package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Scanner;


public class Product extends Entity{
	private String name;
	private ArrayList<Long> shelfId = new ArrayList<>();
	private long maiorShelfId = 0;
	private int discount;
	private double iva;
	private double pvp;
	
	public Product(){
		Scanner sc = new Scanner(System.in);
		
		//coloca nome
		System.out.println("\nQual o nome do produto?");
		String productName = sc.nextLine();
		this.setName(productName);
		
		sc.close();  //devo fechar??? da erro ao fechar...
		
		//coloca desconto
		System.out.println("\nQual o desconto do produto (%)? (valor unitario em percentagem)");
		int intAux = checkInputInt();
		this.setDiscount(intAux);
		
		//coloca iva
		System.out.println("\nQual o IVA do produto(%)?");
		double doubleAux = checkInputDouble();
		this.setIva(doubleAux);
		
		//coloca pvp
		System.out.println("\nQual o PVP do produto(euros)?");
		doubleAux = checkInputDouble();
		this.setPvp(doubleAux);
	}
	
	public void update() {
		
		//alterar nome
		System.out.println("\nAlterar nome('"+ this.getName() +"'): ");
		boolean keep = keepValue();

		Scanner sc = new Scanner(System.in);
		if (!keep) {
			System.out.println("Introduza o novo nome:");
			this.setName( sc.nextLine() );
		}
		sc.close();  //devo fechar??? da erro ao fechar...
		
		//alterar pvp
		System.out.println("\nAlterar PVP("+ this.getPvp() +"euros): ");
		keep = keepValue();
		
		if (!keep) {
			System.out.println("Introduza o novo valor de PVP:");
			this.setPvp( checkInputDouble() );
		}
		
		//alterar iva
		System.out.println("\nAlterar IVA("+ this.getIva() +"%): ");
		keep = keepValue();
		
		if (!keep) {
			System.out.println("Introduza o novo valor de IVA:");
			this.setIva( checkInputDouble() );
		}
		
		//alterar desconto
		System.out.println("\nAlterar desconto("+ this.getDiscount() +"%): ");
		keep = keepValue();
		
		if (!keep) {
			System.out.println("Introduza o novo valor de desconto:");
			this.setDiscount( checkInputInt() );
		}
	}
	
	public void show() {
		System.out.println("Produto " + this.getId() + ": (nome) " + 
							this.getName() +", (PVP) " + 
							this.getPvp() +"euros, (IVA)" + 
							this.getIva() +"%, (desconto) " + 
							this.getDiscount() +"%.");
		if (shelfId.size()>0) {
			System.out.println("Este produto encontra-se em: ");
			for (long i = 0; i <= maiorShelfId; i++) {
				if (shelfId.contains(i)) {
					System.out.println("Prateleira - " + i);
				}
			}
		} else if (shelfId.size()==0) {
			System.out.println("Este produto nao se encontra em nenhuma prateleira!");
		}
	}
	
	public void addShelfId(long id){
		shelfId.add(id);
		maiorShelfId++;
	}
	public void removeShelfId(long id){
		shelfId.remove(id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
