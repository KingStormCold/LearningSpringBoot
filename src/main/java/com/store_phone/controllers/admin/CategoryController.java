package com.store_phone.controllers.admin;

import com.store_phone.dtos.CategoryDTO;
import com.store_phone.dtos.UserDTO;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.category.CategoryInfo;
import com.store_phone.response.user.UserInfo;
import com.store_phone.resquest.category.AddCategoryRequest;
import com.store_phone.resquest.category.UpdateCategoryRequest;
import com.store_phone.resquest.user.AddUserRequest;
import com.store_phone.resquest.user.UpdateUserRequest;
import com.store_phone.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "v1/category/findAll")
    public ResponseEntity<CommonResponse<ResultDataPaging<CategoryInfo>>> findAll(Pageable pageable) {
        return ResponseEntity.ok(new CommonResponse<>(categoryService.findAll(pageable)));
    }

    @GetMapping(value = "v1/category/{categoryId}")
    public ResponseEntity<CommonResponse<CategoryInfo>> findById(@PathVariable("categoryId") String categoryId) {
        CategoryDTO categoryDTO = categoryService.getCategoryInfo(categoryId);
        CategoryInfo categoryInfo = new CategoryInfo(categoryDTO);
        return ResponseEntity.ok(new CommonResponse<>(categoryInfo));
    }

    @PostMapping(value = "/v1/category/create")
    public ResponseEntity<CommonResponse<CategoryDTO>> addCategory (@Valid @RequestBody AddCategoryRequest request) {
        return ResponseEntity.ok(new CommonResponse<>(categoryService.addCategory(request)));
    }

    @PutMapping(value = "v1/category/update")
    public ResponseEntity<CommonResponse<CategoryInfo>> updateUser(@Valid @RequestBody UpdateCategoryRequest request) {
        CategoryDTO categoryDTO = categoryService.updateCategory(request);
        CategoryInfo categoryInfo = new CategoryInfo(categoryDTO);
        return ResponseEntity.ok(new CommonResponse<>(categoryInfo));
    }

    @DeleteMapping(value = "v1/category/delete/{categoryId}")
    public ResponseEntity<?> deleteById(@PathVariable("categoryId") String categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
