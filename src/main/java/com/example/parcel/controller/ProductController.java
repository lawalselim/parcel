package com.example.parcel.controller;

import com.example.parcel.Messages.SysMessage;
import com.example.parcel.dto.ProductDto;
import com.example.parcel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {

    /*Product API functionality goes here
     Key functionality
     1. Create new product
     2. Find product by id
     3. update product details
     4. Delete Product
     */

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


    /*Cart API functionality goes here
     Key functionality
     1. Add to cart by id
     2. Remove from cart id

     */

    @GetMapping("getCart")
    public ResponseEntity<?> getCart() {
        return ResponseEntity.ok(productService.getCart());
    }
    @PostMapping("addToCart/{id}")
    public ResponseEntity<?> addToCart(@RequestBody @PathVariable int id) {
        productService.addToCart(id);
        return ResponseEntity.ok(SysMessage.ADD_TO_CART);
    }

    @DeleteMapping("removeFromCart/{id}")
    public ResponseEntity<?> removeFromCart(@PathVariable int id) {
        productService.removeFromCart(id);
        return ResponseEntity.ok(SysMessage.REMOVE_FROM_CART);
    }
}
