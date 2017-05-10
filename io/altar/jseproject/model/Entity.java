package io.altar.jseproject.model;

import java.util.Scanner;


public class Entity {
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
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextInt()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		int number = sc.nextInt();
		
		sc.close();  //devo fechar??? da erro ao fechar...
		return number;
	}
	
	public static long checkInputLong(){
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextLong()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		long number = sc.nextLong();
		
		sc.close();  //devo fechar??? da erro ao fechar...
		return number;
	}
	
	public static double checkInputDouble(){
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextDouble()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		double number = sc.nextDouble();
		
		sc.close();  //devo fechar??? da erro ao fechar...
		return number;
	}
	
	public static boolean keepValue(){
		Scanner sc = new Scanner(System.in);
		
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
		
		sc.close();  //devo fechar??? da erro ao fechar...
		return keep;
	}
}
