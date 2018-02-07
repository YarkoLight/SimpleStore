package com.SimpleStore.Entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDateTime localDateTime;

	@ManyToOne
	private User user;

	@ManyToMany
	@JoinTable(name = "orders_clothes", joinColumns = @JoinColumn(name = "orders_id"), inverseJoinColumns = @JoinColumn(name = "clothes_id"))
	private Set<Clothes> clothes = new HashSet<>();

	public Orders() {
		
	}

	public Orders(LocalDateTime localDateTime) {
		super();
		this.localDateTime = localDateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public Set<Clothes> getClothes() {
		return clothes;
	}

	public void setClothes(Set<Clothes> clothes) {
		this.clothes = clothes;
	}





	
	

	
	
	
	
	
	
	
	
}
