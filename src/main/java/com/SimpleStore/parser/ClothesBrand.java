package com.SimpleStore.parser;

import com.SimpleStore.Entity.Brand;
import com.SimpleStore.Entity.Clothes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOME on 12.10.2017.
 */
public class ClothesBrand {

    public static List<Clothes> getClothesNames(Document document) {

        List<Clothes> clothes = new ArrayList<>();
        Elements elementsList = document.select("tbody > tr > td");

        for (Element element : elementsList) {

            Clothes clothes1 = new Clothes();

            String line = element.text();
            try {

                if (line.contains("(") && line.contains(")")) {
                    if (line.contains("(BARBARY)")) {


                        String current = line.substring((line.indexOf(")") + 1), line.indexOf("1.") - 1).trim();
                        String[] ingredients = current.split(";");
                        for (String ing : ingredients) {

                            Brand brand = new Brand();
                            brand.setBrandName(ing);

                            clothes1.getBrand().add(brand);

                        }



                        System.out.println();

                        clothes1.setClothesName(line.substring(0, line.indexOf(")") + 1));

                        clothes.add(clothes1);

                    } else {
                        String current = line.substring((line.indexOf(")") + 1), line.indexOf("1.") - 1).trim();





                        clothes1.setClothesName(line.substring(0, line.indexOf(")") + 1));

                        clothes.add(clothes1);

                    }
                }
            } catch (StringIndexOutOfBoundsException e) {
            }

        }

        return clothes;
    }

}
