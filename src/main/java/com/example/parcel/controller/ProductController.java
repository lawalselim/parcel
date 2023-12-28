package com.example.parcel.controller;

import com.example.parcel.Messages.SysMessage;
import com.example.parcel.dto.ProductDto;
import com.example.parcel.model.Product;
import com.example.parcel.service.ProductService;
import org.springframework.data.domain.Pageable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

   @GetMapping("getById/{id}")
   public ResponseEntity<?> getById(@PathVariable int id) {
       return ResponseEntity.ok(productService.getById(id));
   }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        final List<Product> products = productService.getAll();
        if(products.size() <= 0) {
            return ResponseEntity.ok(SysMessage.PRODUCT_NOT_FOUND);
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("getByProductName/{productName}")
    public ResponseEntity<?> getByproductName(@PathVariable String productName) {
        String productsName = "";
        List<Product> products = this.productService.getByproductName(productName);
        for(Product product: products) {
            productsName = product.getProductName();
        }
        if(!productName.equals(productsName)) {
            return ResponseEntity.ok(SysMessage.NOT_FOUND_THIS_NAME);
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("getByProductBrand/{productBrand}")
    public List<Product> getByproductBrand(@PathVariable String productBrand) {
        return this.productService.getByproductBrand(productBrand);
    }

    @GetMapping("slice")
    public ResponseEntity<List<Product>> slice(Pageable pageable) {
        final List<Product> products = this.productService.slice(pageable);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteByid(@PathVariable int id) {
        this.productService.deleteById(id);
        return ResponseEntity.ok(SysMessage.PRODUCT_DELETED);
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
