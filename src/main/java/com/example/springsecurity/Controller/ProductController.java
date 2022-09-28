package com.example.springsecurity.Controller;

import com.example.springsecurity.Dao.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    List<Product> productList = new ArrayList<>();

    @PostMapping
    boolean add(@RequestBody Product product){
        return productList.add(product);
    }

    @GetMapping
    List<Product> getAll(){
        return productList;
    }

    @DeleteMapping("/{id}")
    String delete(@PathVariable Integer id){
        for (Product product : productList) {
            if(product.getId().equals(id)){
                productList.remove(product);
                return "Deleted";
            }
        }
        return null;
    }
}
