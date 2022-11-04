package com.Product.ProductAPI.services;

import com.Product.ProductAPI.model.Product;
import com.Product.ProductAPI.model.ProductDTO;
import org.springframework.data.domain.Page;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface ProductService {

    Object getBySku(String sku) throws IOException, InterruptedException;

    Page<Product> getBySkuOrDesignation (String skuOrDesignation, int offset, int pageSize);

    Page<ProductDTO> getCatalog(int offset, int pageSize);
    Product create(Product pt) throws IOException;

    BufferedImage generateCode128BarcodeImage(String barcodeText);

}
