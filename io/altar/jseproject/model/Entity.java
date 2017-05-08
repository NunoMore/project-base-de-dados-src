package io.altar.jseproject.model;

import java.util.Scanner;


public class Entity {
	public Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public static int checkInputInt(){
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextInt()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		int number = sc.nextInt();
		
//		sc.close();  //devo fechar??? da erro ao fechar...
		return number;
	}
	
	public static long checkInputLong(){
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextLong()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		long number = sc.nextLong();
		
//		sc.close();  //devo fechar??? da erro ao fechar...
		return number;
	}
	
	public static double checkInputDouble(){
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextDouble()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		double number = sc.nextDouble();
		
//		sc.close();  //devo fechar??? da erro ao fechar...
		return number;
	}
	
	public static boolean keepValue(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Deseja MANTER o valor? (s-sim / n-nao)");
		String yesORno = sc.next();
		
		while (yesORno.equals("s") && yesORno.equals("n")) {
			System.out.println("Por favor, ecreva 's' ou 'n' para MANTER(ou não) o valor!");
			yesORno = sc.next();
		}
		
		boolean keep = true;
		if (yesORno == "s") {
			keep = true;
		} else if (yesORno == "n") {
			keep = false;
		}
		
//		sc.close();  //devo fechar??? da erro ao fechar...
		return keep;
	}
	
//	public static boolean removeValue(){
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Deseja realmente remover o valor? (s-sim / n-nao)"
//							+ "\nEsta accao nao tem retorno!");
//		String yesORno = sc.next();
//		
//		while (yesORno.equals("s") && yesORno.equals("n")) {
//			System.out.println("Por favor, ecreva 's' ou 'n' para remover(ou não) o valor!");
//			yesORno = sc.next();
//		}
//		
//		boolean remove = true;
//		if (yesORno == "s") {
//			remove = true;
//		} else if (yesORno == "n") {
//			remove = false;
//		}
//		
////		sc.close();  //devo fechar??? da erro ao fechar...
//		return remove;
//	}
}
