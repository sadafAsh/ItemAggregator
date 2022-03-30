package com.soj.item.aggregator.rest.template.gateway.impl;

import com.soj.item.aggregator.dto.Category;
import com.soj.item.aggregator.dto.SubCategory;
import com.soj.item.aggregator.rest.template.gateway.CategoryGateway;
import com.soj.item.aggregator.rest.template.gateway.SubCategoryGateway;
import com.soj.item.aggregator.util.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.soj.item.aggregator.dto.Category.OBJECT_TYPE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CategoryGatewayImplTest {


    @MockBean
    private RestTemplate restTemplate;
    @Autowired
    private CategoryGateway categoryGateway;


    @Test
    void findAll() {

            Category category = new Category();
            category.setId(1l);
            category.setName("Chicken tandoori");
            List<Resource> resources = new ArrayList<>();
            Resource<Category> resource = new Resource<>(1l, OBJECT_TYPE, category);
            resources.add(resource);
            ParameterizedTypeReference<List<Resource<Category>>> typeReference=new ParameterizedTypeReference<List<Resource<Category>>>() {};
            ResponseEntity<List<Resource<Category>>> result=new ResponseEntity<>(HttpStatus.OK);

            when(restTemplate.exchange(Mockito.anyString(),
                    Mockito.<HttpMethod>any(),
                    Mockito.<HttpEntity<List<Resource>>>any(),
                    Mockito.<ParameterizedTypeReference<List<Resource<Category>>>>any())).
                    thenReturn(result);
            List<Resource<Category>> responseEntity=categoryGateway.findAll();
            Assertions.assertEquals(200,result.getStatusCodeValue());
        Assertions.assertEquals(1,resources.size());

    }

    @Test
    void getCategoryById() {
        Category category=new Category();
        category.setId(1l);
        Resource<Category> resource=new Resource<>(1l,OBJECT_TYPE,category);
        HttpHeaders headers=new HttpHeaders();
        ResponseEntity<Resource> entity=new ResponseEntity<Resource>(headers,HttpStatus.OK);
        when(restTemplate.exchange(Mockito.anyString(),
                Mockito.<HttpMethod>any(),
                Mockito.<HttpEntity>any(),
                Mockito.<Class<Resource>>any())).thenReturn(entity);
        Resource resource1=categoryGateway.getCategoryById(1l);
        Assertions.assertEquals(resource1,entity.getBody());
    }

    @Test
    void createCategory() {
        Category category = new Category();
            category.setId(1l);
            category.setName("Chicken tandoori");
            Resource<Category> resource = new Resource<>(1l, OBJECT_TYPE, category);
            HttpHeaders headers=new HttpHeaders();

            ResponseEntity<Resource> result=new ResponseEntity<>(resource,HttpStatus.OK);

            when(restTemplate.exchange(Mockito.anyString(),
                    Mockito.<HttpMethod>any(),
                    Mockito.<HttpEntity<Resource>>any(),
                    Mockito.<Class<Resource>>any())).
                    thenReturn(result);
            Resource<Category> responseEntity=categoryGateway.createCategory(resource);
            Assertions.assertEquals(responseEntity, result.getBody());
    }

    @Test
    void deleteCategory() {

            Category category = new Category();
            category.setId(1l);
            category.setName("Chicken tandoori");
            Resource<Category> resource = new Resource<>(1l, OBJECT_TYPE, category);
            HttpHeaders headers=new HttpHeaders();

            ResponseEntity<Resource> result=new ResponseEntity<>(resource,HttpStatus.OK);

            when(restTemplate.exchange(Mockito.anyString(),
                    Mockito.<HttpMethod>any(),
                    Mockito.<HttpEntity<Resource>>any(),
                    Mockito.<Class<Resource>>any())).
                    thenReturn(result);
            Resource<Category> responseEntity=categoryGateway.deleteCategory(1l);
            Assertions.assertEquals(responseEntity, result.getBody());
    }

    @Test
    void updateCategory() {

            Category category = new Category();
            category.setId(1l);
            category.setName("Chicken tandoori");
            Resource<Category> resource = new Resource<>(1l, OBJECT_TYPE, category);
            HttpHeaders headers=new HttpHeaders();

            ResponseEntity<Resource> result=new ResponseEntity<>(resource,HttpStatus.OK);

            when(restTemplate.exchange(Mockito.anyString(),
                    Mockito.<HttpMethod>any(),
                    Mockito.<HttpEntity<Resource>>any(),
                    Mockito.<Class<Resource>>any())).
                    thenReturn(result);
            Resource<Category> responseEntity=categoryGateway.updateCategory(1l,resource);
            Assertions.assertEquals(responseEntity, result.getBody());


        }


    }