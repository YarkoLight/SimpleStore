package com.SimpleStore.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	@OneToMany(mappedBy = "country")
	private List<Clothes> clothes = new ArrayList<Clothes>();

	public Country() {
		
	}

	public Country(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Clothes> getClothes() {
		return clothes;
	}

	public void setClothes(List<Clothes> clothes) {
		this.clothes = clothes;
	}
	
	
	
	
	
	
	
}
