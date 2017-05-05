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
		
		sc.close();
		return number;
	}
	
	public static long checkInputLong(){
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextLong()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		long number = sc.nextLong();
		
		sc.close();
		return number;
	}
	
	public static double checkInputDouble(){
		Scanner sc = new Scanner(System.in);
		
		while(!sc.hasNextDouble()){
			System.out.println("\nInput is not a valid number!");
			sc.next();
		}
		double number = sc.nextDouble();
		
		sc.close();
		return number;
	}
	
	public static boolean keepValue(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Deseja manter o valor? (s/n)");
		while (!sc.hasNext("s") || !sc.hasNext("n")) {
			System.out.println("Por favor, escolha 's' ou 'n' para manter(ou não) o valor!");
		}
		
		boolean keep = true;
		if (sc.next() == "s") {
			keep = true;
			
		} else if (sc.next() == "n") {
			keep = false;
		}
		
		sc.close();
		
		return keep;
		
	}
}
