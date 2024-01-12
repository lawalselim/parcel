package com.example.parcel.service;

import com.example.parcel.dto.ProductDto;
import com.example.parcel.model.Product;
import com.example.parcel.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @BeforeEach
    void setUp () {

    }

    @Test
    void testGetAll() {
        Product product = mock(Product.class);
        product.setId(1);
        product.setProductName("Test-Name");
        product.setProductBrand("Test-Brand");
        product.setProductDescription("Test-Details");
        product.setProductImageUrl("Test-Url");
        product.setStock(10);
        product.setProductPrice(1000);

        when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
        List<Product> productList = productServiceImpl.getAll();

        assertEquals(productList.size(), 1);

    }

    @Test
    @DisplayName("product add test method")
    @Tag("addProduct")
    void testcreateProduct() {
        ProductDto productDto = mock(ProductDto.class);
        productDto.setProductBrand("Test-Brand");
        productDto.setProductName("Test-Name");
        productDto.setProductDescription("Test-Details");
        productDto.setProductPrice(1000);
        productDto.setProductImageUrl("Test-Url");
        productDto.setStock(10);
        Product product = mock(Product.class);

        when(productRepository.save(any(Product.class))).thenReturn(product);
        ProductDto result = productServiceImpl.createProduct(productDto);

        assertEquals(result.getProductBrand(), productDto.getProductBrand());

    }

    @Test
    @DisplayName("get product name test")
    @Tag("getByProductName")
    void testGetByproductName() {
        String productName = "Test-Name";
        productServiceImpl.getByproductName(productName);
        verify(productRepository).getByproductName(productName);

    }

    @Test
    @DisplayName("get product brand test")
    @Tag("getByProductBrand")
    void testGetByproductBrand() {
        String productBrand = "Test-Brand";
        productServiceImpl.getByproductBrand(productBrand);
        verify(productRepository).getByproductBrand(productBrand);

    }

    @Test
    @DisplayName("product delete by id")
    @Tag("deleteById")
    void testDeleteById() {
        int id = 1;
        productServiceImpl.deleteById(id);
        verify(productRepository).deleteById(id);
    }

    @Test
    void testSlice() {

    }

    /*
    @Test
    @DisplayName("product get dto test")
    void testGetDto() {
        Product product = mock(Product.class);
        product.setId(1);
        product.setProductName("Test-Name");
        product.setProductBrand("Test-Brand");
        product.setProductDescription("Test-Details");
        product.setProductImageUrl("Test-Url");
        product.setStock(10);
        product.setProductPrice(1000);

        when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
        List<ProductDto> productViewDto = productServiceImpl.();

        assertEquals(productViewDto.size(), 1);


    }

     */
}