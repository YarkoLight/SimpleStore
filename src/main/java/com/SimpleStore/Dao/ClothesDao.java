package com.SimpleStore.Dao;

import com.SimpleStore.Entity.Clothes;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface ClothesDao extends JpaRepository<Clothes, Integer>{

    @Query(value = "select distinct c from Clothes c left join fetch c.brand",
            countQuery = "select count(c.id) from Clothes c")
    Page<Clothes> clothesWithBrandsPages(Pageable pageable);

    @Query("select distinct c from Clothes c left join fetch c.brand")
    List<Clothes> clothesWithBrands();

    @Query("select distinct c from Clothes c left join fetch c.brand where c.id=:id")
    Clothes clothesWithBrands(@Param("id") int id);

    @Query("select distinct c from Clothes c left join fetch c.users where c.id=:id")
    Clothes clothesWithUsers(@Param("id") int id);

    @Query("select distinct c from Clothes c left join fetch c.brand where c.clothesName like %:search%")
    List<Clothes> searchClothes(@Param("search") String search);









}
