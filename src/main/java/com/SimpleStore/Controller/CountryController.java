package com.SimpleStore.Controller;


import com.SimpleStore.Entity.Country;
import com.SimpleStore.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public String country(Model model) {
        model.addAttribute("countries", countryService.countriesWithImages());
        return "views-admin-country";
    }

    @PostMapping("/country")
    public String country(@ModelAttribute Country country,
                          Model model,
                          @RequestParam("images") List<MultipartFile> images) {

        countryService.save(country, images);


        return "redirect:/country";
    }

    @GetMapping("/deleteCountry/{id}")
    public String delete(@PathVariable int id) {

        countryService.delete(id);

        return "redirect:/country";
    }

    @GetMapping("/updateCountry/{countryId}")
    public String updateCountry(@PathVariable int countryId, Model model){

        model.addAttribute("country", countryService.findOne(countryId));

        return "views-admin-updateCountry";

    }

    @PostMapping("/updateCountry/{countryId}")
    public String updateCountry(@PathVariable int countryId,
                                @RequestParam String name,
                                @RequestParam MultipartFile image){

        Country country = new Country(name);
        country.setId(countryId);

        countryService.update(country, image);

        return "redirect:/country";

    }

}
