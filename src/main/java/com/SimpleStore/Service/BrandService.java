package com.SimpleStore.Service;

import com.SimpleStore.Entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by HOME on 23.08.2017.
 */
public interface BrandService {

    void save(Brand brand);

    List<Brand> findAll();

    Brand findOne(int id);

    void delete(int id);

    void update(Brand brand);

    Page<Brand> findAllPages(Pageable pageable);
}
