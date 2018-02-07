package com.SimpleStore.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOME on 23.08.2017.
 */
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brandName;

    @ManyToMany
    @JoinTable(name = "clothes_brand",
            joinColumns = @JoinColumn(name = "id_brand"),
            inverseJoinColumns = @JoinColumn(name = "id_clothes"))
    private List<Clothes> clothes = new ArrayList<>();

    public Brand() {
        // TODO Auto-generated constructor stub
    }

    public Brand(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public Brand(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Clothes> getClothes() {
        return clothes;
    }

    public void setClothes(List<Clothes> clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
