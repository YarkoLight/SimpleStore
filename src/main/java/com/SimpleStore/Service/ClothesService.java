package com.SimpleStore.Service;


import com.SimpleStore.Entity.Clothes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public interface ClothesService {

    void save(Clothes clothes, ArrayList<Integer> ids, MultipartFile image);

    List<Clothes> findAll(Pageable pageable);
    Page<Clothes> clothesWithBrandsPages(Pageable pageable);

    Clothes findOne(int id);

    void delete(int id);

    List<Clothes> clothesWithBrandsParsed();

    Clothes clothesWithBrands(int id);

    Clothes clothesWithBrandsParsed(int id);

    Clothes clothesWithAllInfo(int id);

    void updateClothes(Clothes clothes, MultipartFile image, ArrayList<Integer> brand);

    int random();

    List<Clothes> searchClothes(String search);








}
