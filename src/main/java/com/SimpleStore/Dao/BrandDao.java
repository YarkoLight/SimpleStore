package com.SimpleStore.Dao;

import com.SimpleStore.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by HOME on 23.08.2017.
 */
public interface BrandDao extends JpaRepository<Brand, Integer> {

    @Query("select b from Brand b left join fetch b.clothes where b.id=:id")
    Brand brandWithClothes(@Param("id") int id);
}
