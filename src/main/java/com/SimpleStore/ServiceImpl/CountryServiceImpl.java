package com.SimpleStore.ServiceImpl;

import com.SimpleStore.Dao.CountryDao;
import com.SimpleStore.Dao.CountryImagesDao;
import com.SimpleStore.Entity.Country;
import com.SimpleStore.Entity.CountryImages;
import com.SimpleStore.Service.CountryService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{


    @Autowired
    private CountryDao countryDao;
    @Autowired
    private CountryImagesDao countryImagesDao;

    public void save(Country country, List<MultipartFile> images){

        countryDao.saveAndFlush(country);

        for (MultipartFile multipartFile : images) {

            String path = "C:\\workspace\\apache-tomcat-8.0.33\\resources\\"
                    + country.getName() + "\\" + multipartFile.getOriginalFilename();

            CountryImages countryImages =
                    new CountryImages("resources/" + country.getName() + "/"
                            + multipartFile.getOriginalFilename());

            countryImagesDao.saveAndFlush(countryImages);

            countryImages.setCountry(country);

            File filePath = new File(path);

            if(!filePath.exists()){
                filePath.mkdirs();
            }

            try {
                multipartFile.transferTo(filePath);
            } catch (IOException e) {
                System.out.println("error with file");
            }
            countryImagesDao.save(countryImages);
        }

        countryDao.save(country);
    }


    public List<Country> findAll() {
        return countryDao.findAll();
    }

    public Country findOne(int id) {
        return countryDao.findOne(id);
    }

    public void delete(int id) {
        countryDao.delete(id);
    }

    public void update(Country country) {
        countryDao.save(country);
    }



    @Override
    public void update(Country country, MultipartFile image) {

        country.setName(country.getName());

        String path = System.getProperty("catalina.home") + "/resources/"
                + country.getName() + "/" + image.getOriginalFilename();

//		country.setPathImage("resources/" + country.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            try {
                FileUtils.cleanDirectory
                        (new File(System.getProperty("catalina.home") + "/resources/" + country.getName() + "/"));
            } catch (IOException e) {

            }
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        countryDao.save(country);

    }

    @Override
    public List<Country> countriesWithImages() {
        return null;
    }


}
