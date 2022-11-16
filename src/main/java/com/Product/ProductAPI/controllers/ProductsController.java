package com.Product.ProductAPI.controllers;

import com.Product.ProductAPI.model.Product;
import com.Product.ProductAPI.model.ProductDTO;
import com.Product.ProductAPI.repository.ProductRepository;
import com.Product.ProductAPI.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductServiceImp service;

    @GetMapping
    public ResponseEntity<Product> getBySku(@RequestParam("sku") final String sku) throws IOException, InterruptedException {
        final Product product = (Product) service.getBySku(sku);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/internal")
    public ResponseEntity<Product> internalGetBySku(@RequestParam("sku") final String sku){
        final Product product = (Product) service.internalGetBySku(sku);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping("/catalog")
    public Iterable<ProductDTO> getCatalog() {
        return service.getCatalog();
    }

    @GetMapping(value = "/search")
    public Iterable<Product> getBySkuOrDesignation(@RequestParam("skuOrDesignation") final String skuOrDesignation) throws IOException, InterruptedException {
        return service.getBySkuOrDesignation(skuOrDesignation);
    }

    @GetMapping(value = "/internalSearch")
    public Iterable<Product> internalGetBySkuOrDesignation(@RequestParam("skuOrDesignation") final String skuOrDesignation) {
        return service.internalGetBySkuOrDesignation(skuOrDesignation);

    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
      public Product createProduct(@RequestBody final Product pt) throws IOException, InterruptedException {
      return this.service.create(pt);
    }

    @GetMapping(value = "/{sku}/barcode128", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecueCode128Barcode(@PathVariable("sku") final String sku){
        return ResponseEntity.ok(service.generateCode128BarcodeImage(sku));
    }


}
