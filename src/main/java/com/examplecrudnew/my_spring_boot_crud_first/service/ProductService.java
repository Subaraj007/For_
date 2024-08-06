package com.examplecrudnew.my_spring_boot_crud_first.service;

import com.examplecrudnew.my_spring_boot_crud_first.entity.Product;
import com.examplecrudnew.my_spring_boot_crud_first.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    // Push method
    public Product saveProduct(Product product){
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    // Get method
    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    // Delete method
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product deleted! "+ id ;
    }

    //Update method
    public Product updateProduct(Product product){
        Product existingProduct= repository.findById(product.getId()).orElse(null);
        assert existingProduct != null;
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);

    }


}
