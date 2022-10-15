package com.danarim.lesson10.tasks;

import com.danarim.lesson10.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.concurrent.Callable;

public class GetProductTask implements Callable<Product> {

    private final String productId;
    private final String shop;

    public GetProductTask(String productId, String shop) {
        this.productId = productId;
        this.shop = shop;
    }

    @Override
    public Product call() throws Exception {
        URL url = new URL("http://localhost:8080/product/" + shop + "/" + productId);
        ObjectMapper objectMapper = new ObjectMapper();

        Product product = objectMapper.readValue(url, Product.class);
        System.out.println(product);
        return product;
    }
}
