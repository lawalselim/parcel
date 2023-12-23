package com.example.parcel.controller;

import com.example.parcel.dto.ProductDto;
import com.example.parcel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


   /* @GetMapping("/")
    public Iterable<ProductDto> getProducts(){
        return productService.getAllProducts;
    }

    */
    @GetMapping("/{id}")
    public ProductDto getProductById (@PathVariable Long id){
        return productService.getProductById(id);

    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        if (productDto.getId().equals(id)){
            return productService.updateProduct(productDto);
        }else{
            return null;//rework here for proper error message
        }

    }

    @PostMapping("/create-product")
    public ProductDto createProduct (@RequestBody  ProductDto productDto){
        return productService.createProduct(productDto);
    }


}
