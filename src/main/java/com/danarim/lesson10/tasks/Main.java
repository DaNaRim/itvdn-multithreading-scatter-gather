package com.danarim.lesson10.tasks;

import com.danarim.lesson10.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<String> shops = List.of("amazom", "ebay", "atb");

        ArrayList<Future<Product>> products = new ArrayList<>();

        for (String shop : shops) {
            products.add(executorService.submit(new GetProductTask("1", shop)));
        }

        StringBuffer result = new StringBuffer();

        for (Future<Product> productFuture : products) {
            Product product = productFuture.get();
            result.append(product.getName()).append(": ").append(product.getPrice()).append(" ");
        }
        System.out.println(result);

        executorService.shutdown();
    }

}
