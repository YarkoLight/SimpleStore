package com.SimpleStore.dto;


import com.SimpleStore.Entity.Brand;
import com.SimpleStore.Entity.Country;
import com.SimpleStore.Entity.Clothes;

import java.util.ArrayList;
import java.util.List;

public class DtoUtilMapper {

    public static ClothesDto clothesToClothesDto(Clothes clothes){
        return new ClothesDto(clothes.getId(),clothes.getClothesName(), clothes.getPathImage());
    }

    public static BrandDto brandToBrandDto(Brand brand){
        return new BrandDto(brand.getBrandName());
    }

    public static List<BrandDto> BrandToBrandDtos(List<Brand> brands){

        List<BrandDto> brandDtos = new ArrayList<>();

        for (Brand brand : brands) {
            brandDtos.add(new BrandDto(brand.getBrandName()));
        }
        return brandDtos;
    }


    public static List<ClothesDto>clothesToClothesDtos(List<Clothes> clothes){
        List<ClothesDto> clothesDtos = new ArrayList<>();

        for (Clothes clothes1 : clothes) {

            ClothesDto clothesDto = clothesToClothesDto(clothes1);


            clothesDtos.add(clothesDto);

        }

        return clothesDtos;
    }
}
