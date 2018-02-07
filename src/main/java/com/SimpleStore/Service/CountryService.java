package com.SimpleStore.Service;


import com.SimpleStore.Entity.Country;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CountryService {

    void save(Country country, List<MultipartFile> image);


    List<Country> findAll();

    Country findOne(int id);

    void delete(int id);

    void update(Country country, MultipartFile image);

    List<Country> countriesWithImages();
}
