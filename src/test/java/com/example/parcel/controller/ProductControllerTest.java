package com.example.parcel.controller;

import com.example.parcel.dto.ProductDto;
import com.example.parcel.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {
    private final static String CONTENT_TYPE = "application/json";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ProductService productService;

    @Test
    void createProduct() throws Exception {
        ProductDto productDto = new ProductDto();

        productDto.setProductName("Test-name");
        productDto.setProductDescription("Test-description");
        productDto.setProductBrand("Test-Brand");
        productDto.setProductPrice(500);
        productDto.setStock(40);
        productDto.setProductImageUrl("Test-url");

        ResultActions resultActions = mockMvc.perform(post("/api/products/create-product")
                .contentType(CONTENT_TYPE)
                .content(objectMapper.writeValueAsBytes(productDto)));

        ArgumentCaptor<ProductDto> captor = ArgumentCaptor.forClass(ProductDto.class);
        verify(productService,times(1)).createProduct(captor.capture());
        assertThat(captor.getValue().getProductBrand()).isEqualTo("Test-Brand");
        resultActions.andExpect(status().isOk());
    }
/*
    @Test
    void getAll() {
    }

    @Test
    void getByproductName() {
    }

    @Test
    void getByproductBrand() {
    }

    @Test
    void slice() {
    }

    @Test
    void deleteByid() {
    }

    @Test
    void getDto() {
    }

    @Test
    void addToCart() {
    }

    @Test
    void getCart() {
    }

    @Test
    void removeFromCart() {
    }

 */
}