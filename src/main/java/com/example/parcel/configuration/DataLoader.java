package com.example.parcel.configuration;

import com.example.parcel.model.Category;
import com.example.parcel.model.Product;
import com.example.parcel.repository.CategoryRepository;
import com.example.parcel.repository.ProductRepository;
import com.example.parcel.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "command.line.runner.enable", havingValue = "true")
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception{

        Product product = new Product();
        product.setProductName("HD 34Inch Monitor");
        product.setProductBrand("Philips");
        product.setProductDescription("2555 hz HD Monitor");
        product.setProductPrice(3000.00);
        product.setStock(5);
        product.setProductImageUrl("");

        productRepository.save(product);
        Category category = new Category("Computer");
        categoryService.add(category);

    }
}
