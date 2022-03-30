package com.soj.item.aggregator.service.impl;

import com.soj.item.aggregator.dto.SubCategory;
import com.soj.item.aggregator.rest.template.gateway.SubCategoryGateway;
import com.soj.item.aggregator.service.SubCategoryService;
import com.soj.item.aggregator.util.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.soj.item.aggregator.dto.SubCategory.OBJECT_TYPE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class SubCategoryServiceImplTest {

    @MockBean
    private SubCategoryGateway subCategoryGateway;
    @Autowired
    private SubCategoryService subCategoryService;


    @Test
    void getSubCategory() {
        SubCategory subCategory=new SubCategory();
        subCategory.setId(1l);
        Resource<SubCategory> resource=new Resource<>(1l,OBJECT_TYPE,subCategory);
        when(subCategoryGateway.getSubCategory(1l)).thenReturn(resource);
        Resource resource1=subCategoryService.getSubCategory(1l);
        Assertions.assertEquals(1l, resource.getId());
    }

    @Test
    void getListAllSubCategory() {

        SubCategory subCategory=new SubCategory();
        subCategory.setId(1l);
        Resource<SubCategory> resource=new Resource<>(1l,OBJECT_TYPE,subCategory);
        List<Resource<SubCategory>> resources=new ArrayList<>();
        resources.add(resource);
        when(subCategoryGateway.findAllSubCategory()).thenReturn(resources);
        List<Resource<SubCategory>> resource1=subCategoryService.getListAllSubCategory();
        Assertions.assertEquals(1,resource1.size());

    }

    @Test
    void deleteSubCategory() {

        SubCategory subCategory=new SubCategory();
        subCategory.setId(1l);
        Resource<SubCategory> resource=new Resource<>(1l,OBJECT_TYPE,subCategory);
        when(subCategoryGateway.deleteSubCategoryById(1l)).thenReturn(resource);
        Resource resource1=subCategoryService.deleteSubCategory(1l);
        Assertions.assertEquals(1l, resource.getId());

    }

    @Test
    void updateSubCategoryById() {

        SubCategory subCategory=new SubCategory();
        subCategory.setId(1l);
        subCategory.setName("chicken tandoori");
        Resource<SubCategory> resource=new Resource<>(1l,OBJECT_TYPE,subCategory);
        when(subCategoryGateway.updateSubCategory(any(),anyLong())).thenReturn(resource);
        Resource resource1=subCategoryService.updateSubCategoryById(resource,1l);
        Assertions.assertEquals(1l, resource1.getId());
        Assertions.assertEquals(resource.getAttribute(),resource1.getAttribute());
    }

    @Test
    void createNewSubCategory() {

        SubCategory subCategory=new SubCategory();
        subCategory.setId(1l);
        Resource<SubCategory> resource=new Resource<>(1l,OBJECT_TYPE,subCategory);
        when(subCategoryGateway.addNewSubCategory(any())).thenReturn(resource);
        Resource resource1=subCategoryService.createNewSubCategory(resource);
        Assertions.assertEquals(1l, resource1.getId());
    }
}