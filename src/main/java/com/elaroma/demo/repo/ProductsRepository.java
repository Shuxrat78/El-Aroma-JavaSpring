package com.elaroma.demo.repo;

import com.elaroma.demo.models.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productsRepository")
@Transactional
public interface ProductsRepository extends JpaRepository<Products, Long> {
}
