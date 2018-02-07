package com.SimpleStore.ServiceImpl;


import com.SimpleStore.Dao.BrandDao;
import com.SimpleStore.Dao.ClothesDao;
import com.SimpleStore.Entity.Brand;
import com.SimpleStore.Entity.Clothes;
import com.SimpleStore.Service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class ClothesServiceImpl implements ClothesService {

    @Autowired
    private ClothesDao clothesDao;
    @Autowired
    private BrandDao brandDao;

    @Override
    public void save(Clothes clothes, ArrayList<Integer> ids, MultipartFile image) {
        clothesDao.saveAndFlush(clothes);

        String path = System.getProperty("catalina.home") + "/resources/"
                + clothes.getClothesName() + "/" + image.getOriginalFilename();

        clothes.setPathImage("resources/" + clothes.getClothesName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        for (Integer id : ids) {
            Brand brand = brandDao.brandWithClothes(id);
            brand.getClothes().add(clothes);
            brandDao.save(brand);
        }

        clothesDao.save(clothes);
    }

    @Override
    public List<Clothes> findAll(Pageable pageable) {
        return clothesDao.findAll();
    }


    public Page<Clothes> clothesWithBrandsPages(Pageable pageable) {
        return clothesDao.clothesWithBrandsPages(pageable);
    }

    @Override
    public Clothes findOne(int id) {
        return clothesDao.findOne(id);
    }

    @Override
    public void delete(int id) {
           clothesDao.delete(id);
    }

    @Override
    public List<Clothes> clothesWithBrandsParsed() {
        List<Clothes> clothes = clothesDao.clothesWithBrands();



        return clothes;
    }

    @Override
    public Clothes clothesWithBrands(int id) {
        return clothesDao.clothesWithBrands(id);
    }

    @Override
    public Clothes clothesWithBrandsParsed(int id) {
        Clothes clothes = clothesDao.clothesWithBrands(id);

        return clothes;

    }

    @Override
    public Clothes clothesWithAllInfo(int id) {

        Clothes clothes = clothesDao.clothesWithBrands(id);
        Clothes clothes1 = clothesDao.clothesWithUsers(id);

        Clothes returnedClothes = new Clothes();
        returnedClothes.setId(clothes.getId());
        returnedClothes.setBrand(clothes.getBrand());
        returnedClothes.setUsers(clothes1.getUsers());

        return returnedClothes;
    }

    @Transactional
    @Override
    public void updateClothes(Clothes clothes, MultipartFile image, ArrayList<Integer> brand) {

        String path = System.getProperty("catalina.home") + "/resources/"
                + clothes.getClothesName() + "/" + image.getOriginalFilename();

        clothes.setPathImage("resources/" + clothes.getClothesName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        Iterator<Brand> iterator = clothes.getBrand().iterator();

        while (iterator.hasNext()) {

            if (brand.contains(iterator.next().getId())) {

            } else {
                iterator.remove();
            }

        }

        clothesDao.save(clothes);

    }

    @Override
    public int random() {

        List<Clothes> clothes = clothesDao.clothesWithBrands();

        return clothes.get((int)(Math.random()*clothes.size())).getId();
    }

    @Override
    public List<Clothes> searchClothes(String search) {
        return clothesDao.searchClothes(search);
    }
}
