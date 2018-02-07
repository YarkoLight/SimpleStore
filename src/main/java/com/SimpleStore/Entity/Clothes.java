package com.SimpleStore.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Created by HOME on 27.05.2017.
 */
@Entity
@Table(name = "clothes", indexes = @Index(columnList = "clothesName", name = "clothesName_index"))
public class Clothes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String clothesName;

	private String pathImage;
	
	@ManyToOne
	private Country country;

	private int price;
	private boolean $;

	@ManyToMany
	@JoinTable(name = "orders_clothes", joinColumns = @JoinColumn(name = "clothes_id"), inverseJoinColumns = @JoinColumn(name = "orders_id"))
	private List<Orders> orders = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "clothes_user", joinColumns = @JoinColumn(name = "id_clothes"), inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> users = new ArrayList<User>();

	@ManyToMany
	@JoinTable(name = "drink_brand",
			joinColumns = @JoinColumn(name = "id_clothes"),
			inverseJoinColumns = @JoinColumn(name = "id_brand"))
	private List<Brand> brand = new ArrayList<>();
	

	public Clothes() {
		
	}


	public Clothes(String clothesName) {
		super();
		this.clothesName = clothesName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getClothesName() {
		return clothesName;
	}


	public void setClothesName(String clothesName) {
		this.clothesName = clothesName;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}

	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public List<Brand> getBrand() {
		return brand;
	}

	public void setBrand(List<Brand> Brand) {
		this.brand = brand;
	}
	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}


	@Override
	public String toString() {
		return "Products{" +
				"id=" + id +
				", ClothesName='" + clothesName + '\'' +
				", price=" + price +
				", $=" + $ +
				'}';
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Clothes clothes = (Clothes) o;

		return id == clothes.id;
	}
	@Override
	public int hashCode() {
		return id;
	}



	
	
	
	

}
