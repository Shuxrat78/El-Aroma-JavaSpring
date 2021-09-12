package com.elaroma.demo.repo;

import com.elaroma.demo.models.Products;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository("productsRepository")
@Transactional
public interface ProductsRepository extends CrudRepository<Products, Long> {
}