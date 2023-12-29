package com.example.parcel.controller;

import com.example.parcel.Messages.SysMessage;
import com.example.parcel.dto.ProductDto;
import com.example.parcel.model.Product;
import com.example.parcel.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    /*Product API functionality goes here
     Key functionality
     1. Create new product
     2. Find product by id
     3. update product details
     4. Delete Product
     5. Search by product Name
     6.
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

    //TODO: 1. Add appropriate error message for when the specified productname is not found during search
    //TODO: 2. the error message should take response from SysMessage.

    @GetMapping("searchByProduct/{productName}")
    public ResponseEntity<?> searchByProduct(@PathVariable String productName) {
        Map<Integer, Object> result = productService.searchByProduct(productName);
        return ResponseEntity.ok(result);
    }

    //TODO: 1. Add appropriate error message for when the specified brand  is not found
    //TODO: 2. the error message should take response from SysMessage.

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
//create product section needs modification
    @PostMapping("/create-product")
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductDto productDto) {
        this.productService.createProduct(productDto);
        return ResponseEntity.ok(SysMessage.PRODUCT_SAVED);
    }


    /*Cart API functionality goes here
     Key functionality
     1. Add to cart by id
     2. Remove from cart id
     3. Get cart

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

    /* Product Favourite  API functionality goes here
        Key functionality
        1. Remove from favourite
        2. Add to favourite
        3. Get total number of favourite
        4.

        */
    @PutMapping("addFavorite/{productId}")
    public ResponseEntity<?> addFavorite(@PathVariable("productId") int productId) {
        productService.addFavorite(productId);
        return ResponseEntity.ok(SysMessage.ADDED_TO_FAVORITES);
    }

    @GetMapping("getNumberOfFavorite/{productId}")
    public ResponseEntity<?> getNumberOfFavorite(@PathVariable("productId") int productId) {
        return ResponseEntity.ok(productService.getNumberOfFavorite(productId));
    }

    @PutMapping("removeFromFavorite/{productId}")
    public ResponseEntity<?> removeFromFavorite(@PathVariable("productId") int productId) {
        productService.removeFromFavorites(productId);
        return ResponseEntity.ok(SysMessage.REMOVE_FROM_FAVORITES);
    }
}
