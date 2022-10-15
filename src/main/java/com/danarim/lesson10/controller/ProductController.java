package com.danarim.lesson10.controller;

import com.danarim.lesson10.model.Product;
import com.danarim.lesson10.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{shop}/{id}")
    public Product getProductById(@PathVariable String id,
                                  @PathVariable String shop) {
        return productService.getProductById(id, shop);
    }


}
