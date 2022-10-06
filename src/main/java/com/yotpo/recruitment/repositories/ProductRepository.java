package com.yotpo.recruitment.repositories;

import com.yotpo.recruitment.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
