package com.SimpleStore.Controller;

import com.SimpleStore.Service.OrdersService;
import com.SimpleStore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

/**
 * Created by HOME on 27.05.2017.
 */

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    @GetMapping("/addIntoBasket/{id}")
    public String buy(Principal principal, @PathVariable int id, Model model){

        ordersService.addIntoBasket(principal, id);

        return "redirect:/";
    }

    @GetMapping("/deleteFromBasket/{userId}/{clothesId}")
    public String deleteFromBasket(@PathVariable int userId,
                                   @PathVariable int clothesId) {

        ordersService.deleteFromBasket(userId, clothesId);

        return "redirect:/profile";
    }
    @PostMapping("/buy")
    public String buy(Principal principal){

        ordersService.buy(Integer.parseInt(principal.getName()));

        return "redirect:/profile";

    }




}
