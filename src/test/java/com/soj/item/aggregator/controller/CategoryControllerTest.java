package com.soj.item.aggregator.controller;

import com.soj.item.aggregator.dto.Category;
import com.soj.item.aggregator.dto.SubCategory;
import com.soj.item.aggregator.service.CategoryService;
import com.soj.item.aggregator.util.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.soj.item.aggregator.dto.Category.OBJECT_TYPE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CategoryControllerTest {
    @Autowired
    private CategoryController categoryController;
    @MockBean
    private CategoryService categoryService;

    @Test
    void getAllCategoryList() {
        Category category=new Category();
        category.setId(1l);
        Resource<Category> resource=new Resource<>(1l, OBJECT_TYPE,category);
        List<Resource<Category>> resources=new ArrayList<>();
        resources.add(resource);
        when(categoryService.getAllList()).thenReturn(resources);
        List<Resource<Category>> resource1=categoryController.getAllCategoryList();
        Assertions.assertEquals(1,resource1.size());

    }

    @Test
    void getCategoryById() {
        Category category=new Category();
        category.setId(1l);
        Resource<Category> resource=new Resource<>(1l,OBJECT_TYPE,category);
        when(categoryService.getCategory(1l)).thenReturn(resource);
        Resource resource1=categoryController.getCategoryById(1l);
        Assertions.assertEquals(1l, resource.getId());
    }

    @Test
    void createNewCategory() {
        Category category=new Category();
        category.setId(1l);
        Resource<Category> resource=new Resource<>(1l, OBJECT_TYPE,category);
        when(categoryService.addNewCategory(any())).thenReturn(resource);
        Resource resource1=categoryController.createNewCategory(resource);
        Assertions.assertEquals(1l, resource1.getId());

    }

    @Test
    void deleteCategoryById() {
        Category category=new Category();
        category.setId(1l);
        Resource<Category> resource=new Resource<>(1l, OBJECT_TYPE,category);
        when(categoryService.deleteCategoryById(1l)).thenReturn(resource);
        Resource resource1=categoryController.deleteCategoryById(1l);
        Assertions.assertEquals(1l, resource.getId());
    }

    @Test
    void updateCategory() {
        Category category=new Category();
        category.setId(1l);
        category.setName("chicken tandoori");
        Resource<Category> resource=new Resource<>(1l, OBJECT_TYPE,category);
        when(categoryService.updateCategory(anyLong(),any())).thenReturn(resource);
        Resource resource1=categoryController.updateCategory(1l,resource);
        Assertions.assertEquals(1l, resource1.getId());
        Assertions.assertEquals(resource.getAttribute(),resource1.getAttribute());

    }
}