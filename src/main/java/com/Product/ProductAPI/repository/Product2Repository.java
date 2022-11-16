package com.Product.ProductAPI.repository;

import com.Product.ProductAPI.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

@Repository
public class Product2Repository {

    public Product getProduct(String sku) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/products/internal?sku=" + sku))
                .build();

        HttpResponse response = client.send(request,
                HttpResponse.BodyHandlers.ofString());


        var code = response.statusCode();
        if(code == 200){
            ObjectMapper objectMapper = new ObjectMapper();
            String body = response.body().toString();
            var product = objectMapper.readValue(body, Product.class);
            return product;
        }else {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"This product doesn't exist");
        }

    }

    public List<Product> getProductBySkuOrDesignation(String skuOrDesignation) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/products/internalSearch?skuOrDesignation="+skuOrDesignation))
                .build();

        HttpResponse response = client.send(request,
                HttpResponse.BodyHandlers.ofString());


        var code = response.statusCode();
        ObjectMapper objectMapper = new ObjectMapper();
        String body = response.body().toString();
        List<Product> myObjects = objectMapper.readValue(body, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        if(myObjects==null){
            myObjects = Collections.emptyList();
        }
        return myObjects;

    }

}
