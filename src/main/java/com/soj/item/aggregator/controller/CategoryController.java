package com.soj.item.aggregator.controller;

import com.soj.item.aggregator.dto.Category;
import com.soj.item.aggregator.service.CategoryService;
import com.soj.item.aggregator.service.impl.CategoryServiceImpl;
import com.soj.item.aggregator.util.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/template")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @RequestMapping("/category")
    public List<Resource<Category>> getAllCategoryList(){
        return categoryService.getAllList();
    }

    @GetMapping
    @RequestMapping("/category/{id}")
    public Resource<Category> getCategoryById(@PathVariable long id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/category")
    public Resource<Category> createNewCategory(@RequestBody Resource<Category> category){
        return categoryService.addNewCategory(category);
    }

    @RequestMapping(value = "/category/{id}",method = RequestMethod.DELETE)
    public Resource<Category> deleteCategoryById(@PathVariable long id){
        return categoryService.deleteCategoryById(id);
    }
@RequestMapping(value = "/category/{id}",method = RequestMethod.PUT)
    public Resource<Category> updateCategory(@PathVariable long id,@RequestBody Resource<Category> category){
        return categoryService.updateCategory(id,category);
}
}
