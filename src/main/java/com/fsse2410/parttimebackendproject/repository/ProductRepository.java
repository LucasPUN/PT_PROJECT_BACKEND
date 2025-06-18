package com.fsse2410.parttimebackendproject.repository;

import com.fsse2410.parttimebackendproject.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
}
