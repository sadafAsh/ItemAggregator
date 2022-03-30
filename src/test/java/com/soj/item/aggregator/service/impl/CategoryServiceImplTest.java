package com.soj.item.aggregator.service.impl;

import com.soj.item.aggregator.dto.Category;
import com.soj.item.aggregator.dto.SubCategory;
import com.soj.item.aggregator.rest.template.gateway.CategoryGateway;
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
class CategoryServiceImplTest {


    @MockBean
    private CategoryGateway categoryGateway;
    @Autowired
    private CategoryService categoryService;

    @Test
    void getAllList() {


        Category category=new Category();
        category.setId(1l);
        Resource<Category> resource=new Resource<>(1l,OBJECT_TYPE,category);
        List<Resource<Category>> resources=new ArrayList<>();
        resources.add(resource);
        when(categoryGateway.findAll()).thenReturn(resources);
        List<Resource<Category>> resource1=categoryService.getAllList();
        Assertions.assertEquals(1,resource1.size());
    }

    @Test
    void getCategory() {
        Category category=new Category();
        category.setId(1l);
        Resource<Category> resource=new Resource<>(1l,OBJECT_TYPE,category);
        when(categoryGateway.getCategoryById(1l)).thenReturn(resource);
        Resource resource1=categoryService.getCategory(1l);
        Assertions.assertEquals(1l, resource.getId());
    }

    @Test
    void addNewCategory() {

        Category category=new Category();
        category.setId(1l);
        category.setName("chicken tandoori");
        Resource<Category> resource=new Resource<>(1l,OBJECT_TYPE,category);
        when(categoryGateway.createCategory(any())).thenReturn(resource);
        Resource resource1=categoryService.addNewCategory(resource);
        Assertions.assertEquals(1l, resource1.getId());
    }

    @Test
    void deleteCategoryById() {

        Category category=new Category();
        category.setId(1l);
        Resource<Category> resource=new Resource<>(1l,OBJECT_TYPE,category);
        when(categoryGateway.deleteCategory(1l)).thenReturn(resource);
        Resource resource1=categoryService.deleteCategoryById(1l);
        Assertions.assertEquals(1l, resource.getId());
    }

    @Test
    void updateCategory() {
        Category category=new Category();
        category.setId(1l);
        category.setName("chicken tandoori");
        Resource<Category> resource=new Resource<>(1l,OBJECT_TYPE,category);
        when(categoryGateway.updateCategory(anyLong(),any())).thenReturn(resource);
        Resource resource1=categoryService.updateCategory(1l,resource);
        Assertions.assertEquals(1l, resource1.getId());
        Assertions.assertEquals(resource.getAttribute(),resource1.getAttribute());


        }
}