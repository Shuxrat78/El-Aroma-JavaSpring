package com.elaroma.demo.repo;

import com.elaroma.demo.models.Brands;
import org.springframework.data.repository.CrudRepository;

public interface BrandsRepository extends CrudRepository<Brands, Integer> {
}
