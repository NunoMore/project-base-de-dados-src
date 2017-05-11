package io.altar.jseproject.model;

import java.util.Scanner;



public class Entity {
	protected static Scanner sc = new Scanner(System.in);
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void show(){}
	public void update(){}
	
	
	public static int checkInputInt(){
		
		while(!sc.hasNextInt()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		int number = sc.nextInt();
		
		return number;
	}
	
	public static long checkInputLong(){
		
		while(!sc.hasNextLong()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		long number = sc.nextLong();
		
		return number;
	}
	
	public static double checkInputDouble(){
		
		while(!sc.hasNextDouble()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		double number = sc.nextDouble();
		
		return number;
	}
	
	public static boolean keepValue(){
		
		System.out.println("Deseja REMOVER? (s-sim / n-nao)");
		String yesORno = sc.next();
		
		while (!yesORno.equals("s") && !yesORno.equals("n")) {
			System.out.println("Por favor, ecreva 's' ou 'n' para REMOVER(ou nao)!");
			yesORno = sc.next();
		}
		
		boolean keep = false;
		if (yesORno.equals("n")) {
			System.out.println("Nao houve remocao!");
			keep = true;
		}
		
		return keep;
	}
}
