package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;

import io.altar.jseproject.model.Entity;

public abstract class EntityRepository <Entidade extends Entity> { //Entidade sera product ou shelf

	private HashMap<Long, Entidade> m1 = new HashMap<>();
	private long maiorId = 0;
	
	private Long nextId(){ 
		return ++maiorId;
	}
	
	public Entidade get(long id){
		return this.m1.get(id);
	}
 
	public Long create(Entidade ent) {
		
		ent.setId(this.nextId());
		this.m1.put(ent.getId(), ent);
		return ent.getId();
	}
	
	public Collection<Entidade> consult(){
		return this.m1.values();
	}
	
	public void consult( String entidade){
		
		if (has(entidade)){
			String msg = "\nQual o ID do(a) "+ entidade +" a consultar?";
			long id = checkId(msg);
			get(id).show();
		}
	}
	
	public void edit(String entidade){  
		
		if (has(entidade)){
			String msg = "\nQual o ID do(a) "+ entidade + " a editar?";
			long id = checkId(msg);
			get(id).update();
		}
		printList(entidade);
	}
	
	public void remove(String entidade){

		if (has(entidade)){
			String msg = "\nQual o ID do(a) "+ entidade +" a remover?";
			long productId = checkId(msg);
			
			boolean keep = Entity.keepValue();
			if (!keep) {
				System.out.println("\nO valor foi removido.");
				this.m1.remove(productId);
			}else {
				System.out.println("\nOperacao anulada!");
			}
		}
		printList(entidade);
	}
	
	public long checkId(String message){
		//get id
		long id = 0; //se nao houver id ele retorna 0. 
		if (maiorId != 0) {
			System.out.println(message);
			id = Entity.checkInputLong();
			
			while(get(id) == null) {
				System.out.println("\nO ID introduzido nao existe..."
									+ "\nEscolha um ID que exista!");
				id = Entity.checkInputLong();
			}
		}
		return id;
	}
	
	public void printList(String entidade){ //produtos ou prateleiras
		//emite lista de entidades
		System.out.println("\nLista de " + entidade + "s:");
		for (long i = 1; i <= consult().size(); i++) {
			get(i).show();
		}
	}
	
	public boolean has(String entidade){ //produto ou prateleira
		if (consult().size() == 0) {
			System.out.println("\nNao existe qualquer " + entidade + "!"
					+ "\nStart by creating one!");
			return false;
		} else{
			return true;
		}
	}
}