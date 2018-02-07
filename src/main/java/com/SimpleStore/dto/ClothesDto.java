package com.SimpleStore.dto;


import java.util.ArrayList;
import java.util.List;

public class ClothesDto {

    private int id;
    private String clothesName;
    private String pathImage;


    private List<BrandDto> brand = new ArrayList<>();

    public ClothesDto() {
    }

    public ClothesDto(int id, String clothesName, String pathImage) {
        this.id = id;
        this.clothesName = clothesName;
        this.pathImage = pathImage;

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
        this.clothesName =  clothesName;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }



    public List<BrandDto> getBrand() {
        return brand;
    }

    public void setBrand(List<BrandDto> brand) {
        this.brand = brand;
    }
}
