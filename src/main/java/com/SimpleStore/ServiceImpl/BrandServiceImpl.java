package com.SimpleStore.ServiceImpl;

import com.SimpleStore.Dao.BrandDao;
import com.SimpleStore.Entity.Brand;
import com.SimpleStore.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HOME on 23.08.2017.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;


    public void save(Brand brand) {
        brandDao.save(brand);
    }


    public List<Brand> findAll() {
        return brandDao.findAll();
    }


    public Brand findOne(int id) {
        return brandDao.findOne(id);
    }


    public void delete(int id) {
        brandDao.delete(id);
    }


    public void update(Brand brand) {
        brandDao.save(brand);

    }

    @Override
    public Page<Brand> findAllPages(Pageable pageable) {
        return brandDao.findAll(pageable);
    }
}
