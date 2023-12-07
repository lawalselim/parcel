package com.example.parcel.service;
import com.example.parcel.dto.ProductDto;
import com.example.parcel.model.Product;
import com.example.parcel.repository.ProductRepository;
import com.example.parcel.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //section focuses on creating new product
    public ProductDto createProduct (ProductDto productDto){
     //create product logic
        Product product = ProductMapper.mapToProduct(productDto);
        productRepository.save(product);
        return productDto;
    }

    //Get All product

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
    //section focuses on getting product by id
    public ProductDto getProductById ( Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            return ProductMapper.mapToProductDto(product);
        }
        return null;// or add proper error message
    }

    //product update states here

    public ProductDto updateProduct(ProductDto productDto) {
        if (productDto.getId() != null) {
            Optional<Product> productOptional = productRepository.findById(productDto.getId());
            if (productOptional.isPresent()) {
                Product existingProduct = productOptional.get();
                updateProductFields(existingProduct, productDto);
                productRepository.save(existingProduct);
                return ProductMapper.mapToProductDto(existingProduct); // return the updated product DTO
            }
            // Handle case where the product ID is null or not found
            // You can throw an exception or return an error message as needed
            // For instance:
            throw new RuntimeException("Product not found with the given ID");
        }
        // Handle case where the product ID is null in the DTO
        // You can throw an exception or return an error message as needed
        // For instance:
        throw new RuntimeException("Product ID is null");
    }


    private void updateProductFields( Product existingProduct, ProductDto productDto){
        existingProduct.setProductName(productDto.getProductName());
        existingProduct.setProductDescription(productDto.getProductDescription());
        existingProduct.setProductCategory(productDto.getProductCategory());
        existingProduct.setProductPrice(productDto.getProductPrice());
    }
    //Add more service functionality like delete product

}
