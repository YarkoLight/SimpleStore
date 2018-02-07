package com.SimpleStore.parser;

import com.SimpleStore.Entity.Brand;
import com.SimpleStore.Entity.Clothes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
/**
 * Created by HOME on 12.10.2017.
 */
public class Parser {

    public static void main(String[] args) throws IOException {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
        EntityManager manager = factory.createEntityManager();


        Document document = Jsoup.connect("http://art-zakaz.com.ua/stati/podgotovka-k-prazdniku/47-top-50-koktejlej-mira.html").get();

        manager.getTransaction().begin();

        for (Clothes clothes : ClothesBrand.getClothesNames(document)) {

            for (Brand brand : clothes.getBrand()) {

                if (brand.getBrandName().contains("Д")) {
                    brand.setBrandName(brand.getBrandName().substring(0, brand.getBrandName().indexOf("Д")));

                    manager.persist(brand);
                } else {
                    manager.persist(brand);
                }


            }

            manager.persist(clothes);
        }

        manager.getTransaction().commit();


    }

}
