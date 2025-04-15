package com.store_phone.controller.admin;

import com.store_phone.dto.CategoryDTO;
import com.store_phone.request.category.AddCategoryRequest;
import com.store_phone.request.category.UpdateCategoryRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.category.CategoryInfo;
import com.store_phone.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "v1/category/findAll")
    public ResponseEntity<CommonResponse<ResultDataPaging<CategoryInfo>>> findAll(Pageable pageable) {
    	// thiếu trả về categoryRootName
    	return ResponseEntity.ok(new CommonResponse<>(categoryService.findAll(pageable)));
    }

    @GetMapping(value = "v1/category/{categoryId}")
    public ResponseEntity<CommonResponse<CategoryInfo>> findById(@PathVariable("categoryId") String categoryId) {
        CategoryDTO categoryDTO = categoryService.getCategoryInfo(categoryId);
        CategoryInfo categoryInfo = new CategoryInfo(categoryDTO);
        return ResponseEntity.ok(new CommonResponse<>(categoryInfo));
    }

    @PostMapping(value = "v1/category")
    public ResponseEntity<CommonResponse<CategoryDTO>> addCategory (@Valid @RequestBody AddCategoryRequest request) {
        return ResponseEntity.ok(new CommonResponse<>(categoryService.addCategory(request)));
    }

    @PutMapping(value = "v1/category")
    public ResponseEntity<CommonResponse<CategoryInfo>> updateCategory (@Valid @RequestBody UpdateCategoryRequest request) {
        CategoryDTO categoryDTO = categoryService.updateCategory(request);
        CategoryInfo categoryInfo = new CategoryInfo(categoryDTO);
        return ResponseEntity.ok(new CommonResponse<>(categoryInfo));
    }

    @DeleteMapping(value = "v1/category/{categoryId}")
    public ResponseEntity<?> deleteById (@PathVariable("categoryId") String categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
