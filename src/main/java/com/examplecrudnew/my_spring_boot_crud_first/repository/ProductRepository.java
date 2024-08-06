package com.examplecrudnew.my_spring_boot_crud_first.repository;


import com.examplecrudnew.my_spring_boot_crud_first.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Integer> {
    Product findByName(String name);


}
