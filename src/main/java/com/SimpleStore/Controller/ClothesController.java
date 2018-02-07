package com.SimpleStore.Controller;

import com.SimpleStore.Entity.Clothes;
import com.SimpleStore.Entity.Country;
import com.SimpleStore.Service.BrandService;
import com.SimpleStore.Service.ClothesService;
import com.SimpleStore.Service.CountryService;
import com.SimpleStore.dto.ClothesDto;
import com.SimpleStore.dto.DtoUtilMapper;
import com.SimpleStore.editors.CountryEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOME on 27.05.2017.
 */
@Controller
public class ClothesController {

    @Autowired
    private ClothesService clothesService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private BrandService brandService;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.registerCustomEditor(Country.class, new CountryEditor());
    }

    @GetMapping("/clothes")
    public String clothes(Model model) {

        model.addAttribute("clothes", clothesService.clothesWithBrandsParsed());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("brand", brandService.findAll());
        model.addAttribute("clothes", new Clothes());

        return "views-admin-clothes";
    }

    @PostMapping("/clothes")
    public String clothes(@ModelAttribute Clothes clothes,
                        @RequestParam ArrayList<Integer> brandIds,
                        @RequestParam MultipartFile image) {

        clothesService.save(clothes, brandIds, image);

        return "redirect:/clothes";
    }

    @GetMapping("/deleteClothes/{id}")
    public String deleteClothes(@PathVariable int id) {

        clothesService.delete(id);

        return "redirect:/clothes";

    }

    @GetMapping("/updateClothes/{clothes_id}")
    public String updateClothes(Model model,
                              @PathVariable int clothes_id) {

        model.addAttribute("clothes", clothesService.clothesWithBrands(clothes_id));



        return "views-admin-updateClothes";
    }


    @PostMapping("/updateClothes/{id}")
    public String updateClothes(@PathVariable int id,
                              @RequestParam String clothesName,
                                @RequestParam MultipartFile image,
                              @RequestParam ArrayList<Integer> brand){

        Clothes clothes = clothesService.clothesWithBrands(id);
        clothes.setClothesName(clothesName);


        clothesService.updateClothes(clothes,image,brand);

        return "redirect:/clothes";
    }

    @PostMapping("/searchClothes")
    public @ResponseBody
    List<ClothesDto> searchClothes(@RequestBody String search){
        return DtoUtilMapper.clothesToClothesDtos(clothesService.searchClothes(search));
    }





}
