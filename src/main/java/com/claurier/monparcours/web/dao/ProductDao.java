package com.claurier.monparcours.web.dao;


import com.claurier.monparcours.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductDao {
    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
}
