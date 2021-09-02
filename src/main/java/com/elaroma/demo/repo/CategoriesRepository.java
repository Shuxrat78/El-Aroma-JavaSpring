package com.elaroma.demo.repo;

import com.elaroma.demo.models.Categories;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Categories, Integer> {
}
