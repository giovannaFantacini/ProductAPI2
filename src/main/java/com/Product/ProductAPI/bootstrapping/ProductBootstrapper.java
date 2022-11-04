package com.Product.ProductAPI.bootstrapping;


import com.Product.ProductAPI.model.Product;
import com.Product.ProductAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("bootstrap")
public class ProductBootstrapper implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        if (productRepository.getBySku("12345679F128")==null) {
            Product p4 = new Product("12345679F128","Batata","assada","12345679F128_031e7791-1766-46d5-8d68-82ae57727448");
            productRepository.save(p4);
        }

        if (productRepository.getBySku("12345689F127")==null) {
            Product p5 = new Product("12345689F127","Bananas","Em formato de coração","12345689F127_2275baa5-c46f-4206-9eef-329218829084");
            productRepository.save(p5);
        }

        if (productRepository.getBySku("12345789F126")==null) {
            Product p6 = new Product("12345789F126","Banana","verde","12345789F126_8134d44e-9803-4d5f-8acf-fa79ea8dd81e");
            productRepository.save(p6);
        }

        if (productRepository.getBySku("12346789F125")==null) {
            Product p7 = new Product("12346789F125","Banana","Em muita quantidade","12346789F125_8410e48f-c991-43e0-8523-3c6bfaf5562e");
            productRepository.save(p7);
        }

        if (productRepository.getBySku("12356789F124")==null) {
            Product p8 = new Product("12356789F124","banana","pequena","12356789F124_8515d6e4-5499-4f86-8558-17c849c2fa11");
            productRepository.save(p8);
        }

        if (productRepository.getBySku("12456789F123")==null) {
            Product p9 = new Product("12456789F123","banana","amarela x 3","12456789F123_f673295f-8db4-4609-b0d7-1de3c4ba6a7a");
            productRepository.save(p9);
        }

        if (productRepository.getBySku("13456789F122")==null) {
            Product p10 = new Product("13456789F122","banana","amarela x 7","13456789F122_8ac0da2f-b8bd-41bc-bb29-0e4b0505725d");
            productRepository.save(p10);
        }

        if (productRepository.getBySku("23456789F121")==null) {
            Product p11 = new Product("23456789F121","banana","amarela","");
            productRepository.save(p11);
        }

        if (productRepository.getBySku("987654321FFF")==null) {
            Product p12 = new Product("987654321FFF","banana","amarela","");
            productRepository.save(p12);
        }

        if (productRepository.getBySku("987654321FF3")==null) {
            Product p13 = new Product("987654321FF3","banana","amarela","");
            productRepository.save(p13);
        }

    }

}

