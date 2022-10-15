package com.danarim.lesson10.service;

import com.danarim.lesson10.model.Product;

public interface ProductService {

    Product getProductById(String id, String shop);

}
