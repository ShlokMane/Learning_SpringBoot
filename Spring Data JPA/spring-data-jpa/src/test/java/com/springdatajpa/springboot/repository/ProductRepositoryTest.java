package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //Create Product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //Save Product
        Product  savedObject = productRepository.save(product);

        //Display Product Info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        //find or retrieve an identity by id {1}
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //update entity information
        product.setName("Updated Product 1");
        product.setDescription("Updated Product 1 Description");

        //save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        System.out.println(product.toString());
    }


    @Test
    void saveAll() {
        //Create Product
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku("200ABC");
        product2.setPrice(new BigDecimal(100));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku("300ABC");
        product3.setPrice(new BigDecimal(100));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        //Save Product
        productRepository.saveAll(List.of(product2, product3));
    }

    @Test
    void findAllMethod() {
        List<Product> productList = productRepository.findAll();

        productList.forEach((product -> {
            System.out.println(product.toString());
        }));
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
        findAllMethod();
    }

    @Test
    void deleteMethod() {
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        productRepository.delete(product);
        findAllMethod();
    }

    @Test
    void deleteAllMethod() {
        productRepository.deleteAll();
    }

    @Test
    void countMethod() {
        System.out.println(productRepository.count());
    }

    @Test
    void existByIdMethod() {
        System.out.println(productRepository.existsById(1L));
    }
}