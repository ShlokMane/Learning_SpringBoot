package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 2");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> productList = productRepository.findByNameOrDescription("product 2", "product 3 description");

        productList.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> productList = productRepository.findByNameAndDescription("product 2", "product 2 description");

        productList.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }

    @Test
    void findDistinctByName() {
        Product product = productRepository.findDistinctByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> productList = productRepository.findByPriceGreaterThan(BigDecimal.valueOf(100));

        productList.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> productList = productRepository.findByPriceLessThan(BigDecimal.valueOf(101));

        productList.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> productList = productRepository.findByNameContaining("product");

        productList.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> productList = productRepository.findByNameLike("%product%");

        productList.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }

    @Test
    void findByPriceBetweenMethod() {
        List<Product> productList = productRepository.findByPriceBetween(new BigDecimal(100), BigDecimal.valueOf(200));

        productList.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }

    @Test
    void findByDateCreatedBetweenMethod() {
        List<Product> productList = productRepository.findByDateCreatedBetween(LocalDateTime.of(2024, 06, 20, 23, 06, 31), LocalDateTime.of(2024, 06, 20, 23, 06, 32));

        productList.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }

    @Test
    void findByNameInMethod() {
        List<String> names = new ArrayList<>();
        names.add("product 1");
        names.add("product 2");
        List<Product> productList = productRepository.findByNameIn(names);

        productList.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }

    @Test
    void findFirst2ByOrderByNameAsc() {
        List<Product> productList = productRepository.findFirst2ByOrderByNameDesc();
        productList.forEach((product -> {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }));
    }
}
