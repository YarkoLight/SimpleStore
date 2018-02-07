package com.SimpleStore.Controller;

import com.SimpleStore.Entity.Brand;
import com.SimpleStore.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by HOME on 23.08.2017.
 */
@Controller
public class BrandController {


    @Autowired
    private BrandService brandService;


    @GetMapping("/brand")
    public String brand(Model model, @PageableDefault Pageable pageable){
        model.addAttribute("ingredients", brandService.findAllPages(pageable));
        model.addAttribute("ingredient", new Brand());
        return "views-admin-brand";
    }

    @PostMapping("/brand")
    public String brand(@ModelAttribute Brand brand){

        brandService.save(brand);

        return "redirect:/brand";
    }

    @GetMapping("/deleteBrand/{id}")
    public String deleteBrand(@PathVariable int id){

        brandService.delete(id);

        return "redirect:/brand";

    }

    @GetMapping("/updateBrand/{id}")
    public String updateBrand(@PathVariable int id, Model model){

        Brand brand =
                brandService.findOne(id);

        model.addAttribute("brand", brand);

        return "updateBrand";

    }
}
