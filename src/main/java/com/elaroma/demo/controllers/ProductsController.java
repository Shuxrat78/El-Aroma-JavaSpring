package com.elaroma.demo.controllers;

import com.elaroma.demo.models.Products;
import com.elaroma.demo.models.Brands;
import com.elaroma.demo.models.Capacities;
import com.elaroma.demo.models.Categories;
import com.elaroma.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private BrandsRepository brandsRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CapacitiesRepository capacitiesRepository;

    @GetMapping("/product")
    public String product(Model model){
        Iterable<Products> products = productsRepository.findAll();
        Iterable<Brands> brands = brandsRepository.findAll();
        Iterable<Categories> categories = categoriesRepository.findAll();
        Iterable<Capacities> capacities = capacitiesRepository.findAll();

        model.addAttribute("products", products);
        model.addAttribute("brands", brands);
        model.addAttribute("categories", categories);
        model.addAttribute("capacities", capacities);

        return "product";
    }

    @GetMapping("/productlist")
    public String productlist(Model model) {
        Iterable<Products> products = productsRepository.findAll();
        Iterable<Brands> brands = brandsRepository.findAll();
        Iterable<Categories> categories = categoriesRepository.findAll();
        Iterable<Capacities> capacities = capacitiesRepository.findAll();

        model.addAttribute("products", products);
        model.addAttribute("brands", brands);
        model.addAttribute("categories", categories);
        model.addAttribute("capacities", capacities);

        return("productlist");
    }

}