package io.altar.jseproject.repositories;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

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
	
	public Entidade consult(Long id){
		return this.m1.get(id);
	}
	
	public void edit(Entidade ent){
		
	}
	
	public void remove(Entidade ent){
		
	}
	
}
