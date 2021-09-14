package com.elaroma.demo.controllers;

import com.elaroma.demo.domain.Role;
import com.elaroma.demo.domain.User;
import com.elaroma.demo.models.Brands;
import com.elaroma.demo.models.Capacities;
import com.elaroma.demo.models.Categories;
import com.elaroma.demo.models.Products;
import com.elaroma.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private BrandsRepository brandsRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CapacitiesRepository capacitiesRepository;

    @GetMapping("/")
    public String home(Model model) {

        Iterable<Products> products = productsRepository.findAll();
        Iterable<Brands> brands = brandsRepository.findAll();
        Iterable<Categories> categories = categoriesRepository.findAll();
        Iterable<Capacities> capacities = capacitiesRepository.findAll();

        model.addAttribute("products", products);
        model.addAttribute("brands", brands);
        model.addAttribute("categories", categories);
        model.addAttribute("capacities", capacities);

        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String logUser(User user, Map<String, Object> model){
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb == null) {
            model.put("error", "Имя пользователя не сушествует...");
            return "login";
        }
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.put("error", "Имя пользователя сушествует...");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }

}