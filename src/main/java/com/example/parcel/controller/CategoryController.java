package com.example.parcel.controller;

import com.example.parcel.Messages.SysMessage;
import com.example.parcel.model.Category;
import com.example.parcel.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/categories/")
@RequiredArgsConstructor
@CrossOrigin
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("getAll")
    public List<Category> getAll() {
        return this.categoryService.getAll();
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody Category category) {
        this.categoryService.add(category);
        return ResponseEntity.ok(SysMessage.CATEGORY_NAME_ALREADY_IN_USE);
    }

    @GetMapping("getByCategoryName")
    public List<Category> getByCategoryName(String categoryName) {
        return this.categoryService.getByCategoryName(categoryName);
    }
}
