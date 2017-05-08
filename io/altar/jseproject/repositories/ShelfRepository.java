package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Shelf;

public class ShelfRepository extends EntityRepository<Shelf> {
	private static final ShelfRepository INSTANCE = new ShelfRepository();
	
	private ShelfRepository(){};
	
	public static ShelfRepository getInstance(){
		
		return INSTANCE; //nao se coloca this 
	}
	
	public static void printShelfList(){
		//emite lista de prateleiras
		System.out.println("\nShelf List:");
		for (long i = 1; i <= getInstance().consult().size(); i++) {
			getInstance().consult(i).show();
		}
	}
	
	public static boolean hasShelfs(){
		if (getInstance().consult().size() == 0) {
			System.out.println("\nThere are no shelfs!"
					+ "\nStart by creating one!");
			return false;
		} else{
			return true;
		}
	}
}
