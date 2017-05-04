package io.altar.jseproject.test;

import java.util.ArrayList;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.textinterface.TextInterface;

public class Test {
	
	public static ArrayList<Shelf> shelfs = new ArrayList<>();
	public static ArrayList<Product> products = new ArrayList<>();
	
	public static void main(String[] args) {
		TextInterface.mainMenu();
	}

}
