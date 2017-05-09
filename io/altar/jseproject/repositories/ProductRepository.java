package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Product;

public class ProductRepository extends EntityRepository<Product> {
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	private ProductRepository(){};
	
	public static ProductRepository getInstance(){
		
		return INSTANCE;
	}
	
	public void printProductList(){
		//emite lista de produtos
		System.out.println("\nProduct List:");
		for (long i = 1; i <= getInstance().consult().size(); i++) {
			getInstance().consult(i).show();
		}
	}
	
	public boolean hasProducts(){
		if (getInstance().consult().size() == 0) {
			System.out.println("\nThere are no products!"
					+ "\nStart by creating one!");
			return false;
		} else{
			return true;
		}
	}
}
