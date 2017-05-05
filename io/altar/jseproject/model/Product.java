package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.Scanner;


public class Product extends Entity{
	public String name;
	public ArrayList<Integer> shelfId = new ArrayList<>();
	public int discount;
	public double iva;
	public double pvp;
	
	public void create(){
		Scanner sc = new Scanner(System.in);
		
		//coloca nome
		System.out.println("\nQual o nome do produto?");
		String productName = sc.nextLine();
		this.setName(productName);
		
		sc.close();
		
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
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nCaso deseje manter algum campo basta clicar em 'enter'.");
		
		//alterar nome
		System.out.println("\nAlterar nome("+ this.getName() +"): ");
		if (sc.nextLine()==null) {
			System.out.println("O valor foi mantido.");
		}
		this.setName( sc.nextLine() );
		
		//alterar pvp
		System.out.println("\nAlterar PVP("+ this.getPvp() +"euros): ");
		
		double doubleAux = 0;
		if (sc.nextLine()==null) {
			doubleAux = this.getPvp();
			System.out.println("O valor foi mantido.");
		} else {
			doubleAux = checkInputDouble();
		}
		break;
				
			
		}
		this.setPvp( doubleAux );
		
		//alterar iva
		doubleAux = 0;
		while(true){
			System.out.println("\nAlterar IVA("+ this.getIva() +"%): ");
			try {
				if (sc.nextLine()==null) {
					doubleAux = this.getIva();
					System.out.println("O valor foi mantido.");
					break;
				}
				doubleAux = Double.parseDouble( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setIva( doubleAux );
		
		//alterar desconto
		int intAux = 0;
		while(true){
			System.out.println("\nAlterar desconto("+ this.getDiscount() +"%): ");
			try {
				if (sc.nextLine()==null) {
					intAux = this.getDiscount();
					System.out.println("O valor foi mantido.");
					break;
				}
				intAux = Integer.parseInt( sc.nextLine() );
				break;
			} catch (Exception e){
				System.out.println("\nInput is not a number!");
			}
		}
		this.setDiscount( intAux );
		sc.close();
	}
	
	public void show() {
		System.out.println("Produto " + this.getId() + ": (nome) " + 
							this.getName() +", (PVP) " + 
							this.getPvp() +"euros, (IVA)" + 
							this.getIva() +"%, (desconto) " + 
							this.getDiscount() +"%.");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name!=null){
			this.name = name;
		}
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
