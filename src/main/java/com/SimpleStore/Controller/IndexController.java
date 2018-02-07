package com.SimpleStore.Controller;

import com.SimpleStore.Service.ClothesService;
import com.SimpleStore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class IndexController {


	@Autowired
	private ClothesService clothesService;
	@Autowired
	private UserService userService;



	@GetMapping("/")
	public String index(Model model, Principal principal, @PageableDefault Pageable pageable) {
		model.addAttribute("clothes", clothesService.clothesWithBrandsPages(pageable));
		if (principal == null || principal.getName().equals("admin")) {

			return "views-base-index";

		}else{
			model.addAttribute("user",
					userService.findUserWithClothes(Integer.parseInt(principal.getName())));
			return "views-base-index";
		}


	}

	@PostMapping("/")
	public String indexAfterLogin(Model model,
								  @RequestParam String username,
								  @PageableDefault Pageable pageable) {
		model.addAttribute("clothes", clothesService.clothesWithBrandsPages(pageable));

		if(username.equals("admin")) {
			return "views-base-index";
		}else{
			model.addAttribute("user", userService
					.findUserByNameWithClothes(username));


			return "views-base-index";

		}



	}

	@GetMapping("/random")
	public String random(Model model){
		model.addAttribute("products", clothesService.random());
		return "views-base-random";



	}



}
