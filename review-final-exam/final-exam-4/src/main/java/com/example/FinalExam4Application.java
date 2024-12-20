package com.example;

import com.example.models.Category;
import com.example.models.Product;
import com.example.services.CategoryService;
import com.example.services.ProductService;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class FinalExam4Application {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    public static void main(String[] args) {
        SpringApplication.run(FinalExam4Application.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
//                Faker faker = new Faker();
//                for(int i = 0; i < 5; i++){
//                    Product product = new Product();
//                    product.setName("Product " + i);
//                    product.setCategory(categoryService.findById(5l));
//                    product.setPrice(Double.parseDouble(faker.commerce().price()));
//                    product.setDescription(faker.lorem().paragraph(1));
//                    product.setRegisterDate(Date.from(Instant.now()));
//                    product.setCode("Pro123-12");
//                    productService.save(product);
//                }
            }
        };
    }

}
