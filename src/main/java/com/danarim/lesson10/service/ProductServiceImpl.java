package com.danarim.lesson10.service;

import com.danarim.lesson10.model.Product;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(String id, String shop) {
        Random random = new Random();

        Product product = new Product();
        product.setId(id);
        product.setName("Product " + id + " from " + shop);
        product.setPrice(random.nextDouble() * 100);
        product.setDescription("Description for product " + id + " from " + shop);

        return product;
    }
}
