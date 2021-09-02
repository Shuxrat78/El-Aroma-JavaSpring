package com.elaroma.demo.controllers;

import com.elaroma.demo.models.Products;
import com.elaroma.demo.models.Brands;
import com.elaroma.demo.models.Capacities;
import com.elaroma.demo.models.Categories;
import com.elaroma.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/products")
    public String productMain(Model model){
        Iterable<Products> products = productsRepository.findAll();
        Iterable<Brands> brands = brandsRepository.findAll();
        Iterable<Categories> categories = categoriesRepository.findAll();
        Iterable<Capacities> capacities = capacitiesRepository.findAll();

        model.addAttribute("products", products);
        model.addAttribute("brands", brands);
        model.addAttribute("categories", categories);
        model.addAttribute("capacities", capacities);

        return "products";
    }

    @GetMapping("/productlist")
    public String productlist(Model model, @RequestParam(value = "page", defaultValue = "0") Integer pageNumber, @SortDefault(sort = "name", direction = Sort.Direction.ASC) Sort sort) {
        Pageable pageable = PageRequest.of(pageNumber, 5, sort);
        Example<Products> searchTerm = Example.of(new Products());
        Page<Products> productList = productsRepository.findAll(searchTerm, pageable);
        model.addAttribute("products", productList);
        return("productlist");
    }

}