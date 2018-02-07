package com.SimpleStore.dto;


public class BrandDto {

    private String brandName;

    public BrandDto(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
