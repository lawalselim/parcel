package com.example.parcel.service;
import com.example.parcel.dto.ProductUpdateDto;
import com.example.parcel.exception.NotFoundException;
import com.example.parcel.model.Cart;
import com.example.parcel.model.Product;
import com.example.parcel.dto.ProductDto;
import com.example.parcel.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CartService cartService;

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }


    @Override
    public Product getById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("product couldn't be found by following id: " + id));
        return product;
    }
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        this.productRepository.save(new Product(productDto.getProductName(), productDto.getProductBrand(),
                productDto.getProductDescription(), productDto.getProductPrice(), productDto.getStock(), productDto.getProductImageUrl()));
        return productDto;
    }

    @Override
    public void deleteById(int id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void updateByProductDetails(ProductUpdateDto productUpdateDto) {
        Optional<Product> productOptional = productRepository.findById(productUpdateDto.getProductId());

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            // Update product details from the ProductUpdateDto
            product.setProductName(productUpdateDto.getProductName());
            product.setProductDescription(productUpdateDto.getProductDescription());
            product.setProductPrice(productUpdateDto.getProductPrice());
            product.setProductBrand(productUpdateDto.getProductBrand());
            product.setProductImageUrl(productUpdateDto.getProductImageUrl());
            product.setStock(productUpdateDto.getStock());
            product.setVendor(productUpdateDto.getVendor());
            product.setCategory(productUpdateDto.getCategory());

            // Save the updated product
            productRepository.save(product);
        }
    }

    @Override
    public List<Product> slice(Pageable pageable) {
        final List<Product> products = this.productRepository.findAll(pageable).stream().collect(Collectors.toList());
        return products;
    }

    @Override
    public List<Product> getByproductName(String productName) {
        return this.productRepository.getByproductName(productName);
    }

    @Override
    public List<Product> getByproductBrand(String productBrand) {
        return this.productRepository.getByproductBrand(productBrand);
    }


    @Override
    public Cart addToCart(int id) {
        Product product = productRepository.getById(id);
        Cart cart = new Cart();
        cart.setId(product.getId());
        cart.setProductBrand(product.getProductBrand());
        cart.setProductName(product.getProductName());
        cart.setProductDescription(product.getProductDescription());
        cart.setProductPrice(product.getProductPrice());
        cart.setProductImageUrl(product.getProductImageUrl());
        cart.setVendor(product.getVendor());
        cart.setQuantity(0);

        cart.setQuantity(cart.getQuantity() + 1);
        product.setStock(product.getStock() - 1);

        if(product.getStock() == 0) {
            productRepository.deleteById(product.getId());
        }
        cartService.addtoCart(cart);

        return cart;
    }

    @Override
    public List<Cart> getCart() {
        return cartService.getAll();
    }

    @Override
    public void removeFromCart(int id) {
        Cart cart = cartService.getById(id);
        cartService.deleteById(cart.getId());
    }

    @Override
    public Map<Integer, Object> searchByProduct(String productName) {
        Map<Integer, Object> searchResult = new HashMap<>();
        List<Product> products = new ArrayList<>();

        for (Product product : productRepository.findAll()) {
            if (product.getProductName().contains(productName)) {
                products.add(product);
                searchResult.put(products.size(), products);
                return searchResult;
            }
        }
        return null;
    }

    @Override
    public void addFavorite(int productId) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isPresent()) {
            product.get().setFavoriteNumber(product.get().getFavoriteNumber() + 1);
            productRepository.save(product.get());
        } else {
            throw new NotFoundException("product couldn't be found by following id: " + productId);
        }

    }

    @Override
    public int getNumberOfFavorite(int productId) {
        return productRepository.findById(productId).get().getFavoriteNumber();
    }

    @Override
    public void removeFromFavorites(int productId) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isPresent()) {
            product.get().setFavoriteNumber(product.get().getFavoriteNumber() - 1);
            productRepository.save(product.get());
        } else {
            throw new NotFoundException("product couldn't be found by following id: " + productId);
        }
    }

}
