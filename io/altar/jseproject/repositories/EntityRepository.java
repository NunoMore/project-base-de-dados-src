package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;

import io.altar.jseproject.model.Entity;

public abstract class EntityRepository <Entidade extends Entity> { //Entidade sera product ou shelf

	private HashMap<Long, Entidade> m1 = new HashMap<>();
	private long maiorId = 0;
	
	private Long nextId(){ 
		return ++this.maiorId;
	}
 
	public Long create(Entidade ent) {
		
		ent.setId(this.nextId());
		
		this.m1.put(ent.getId(), ent);
		
		return ent.getId();
	}
	
	public Collection<Entidade> consult(){
		return this.m1.values();
	}
	
	public Entidade consult(long id){
		return this.m1.get(id);
	}
	
//	public void edit(Entidade ent){} // nao é utilizada... será mesmo necessario???
	
	public void remove(long id){
		this.m1.remove(id);
	}
	
	public long checkId(long number){
		
		while(this.consult(number) == null) {
			System.out.println("O ID introduzido n�o existe..."
					+ "\nEscolha um ID que exista!");
			number = Entity.checkInputLong();
		}
		return number;
	}
}
