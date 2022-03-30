package com.soj.item.aggregator.rest.template.gateway.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soj.item.aggregator.dto.SubCategory;
import com.soj.item.aggregator.rest.template.gateway.SubCategoryGateway;
import com.soj.item.aggregator.util.Resource;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.soj.item.aggregator.dto.SubCategory.OBJECT_TYPE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class SubCategoryGatewayImplTest {


    @MockBean
    private RestTemplate restTemplate;
    @Autowired
    private SubCategoryGateway subCategoryGateway;



    @Test
    void getSubCategoryById()  {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(1l);
        subCategory.setName("Chicken tandoori");
        Resource<SubCategory> resource = new Resource<>(1l, OBJECT_TYPE, subCategory);
        HttpHeaders headers=new HttpHeaders();

        ResponseEntity<Resource> result=new ResponseEntity<>(resource,HttpStatus.OK);

        when(restTemplate.exchange(Mockito.anyString(),
                Mockito.<HttpMethod>any(),
                Mockito.<HttpEntity<Resource>>any(),
                Mockito.<Class<Resource>>any())).
                thenReturn(result);
        Resource<SubCategory> responseEntity=subCategoryGateway.getSubCategory(1l);
        Assertions.assertEquals(responseEntity, result.getBody());
    }

    @Test
    void getAllSubCategory() {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(1l);
        subCategory.setName("Chicken tandoori");
        List<Resource> resources = new ArrayList<>();
        Resource<SubCategory> resource = new Resource<>(1l, OBJECT_TYPE, subCategory);
        resources.add(resource);
        ParameterizedTypeReference<List<Resource<SubCategory>>> typeReference=new ParameterizedTypeReference<List<Resource<SubCategory>>>() {};
        ResponseEntity<List<Resource<SubCategory>>> result=new ResponseEntity<>(HttpStatus.OK);

        when(restTemplate.exchange(Mockito.anyString(),
                Mockito.<HttpMethod>any(),
                Mockito.<HttpEntity<List<Resource>>>any(),
                Mockito.<ParameterizedTypeReference<List<Resource<SubCategory>>>>any())).
                thenReturn(result);
        List<Resource<SubCategory>> responseEntity=subCategoryGateway.findAllSubCategory();
        Assertions.assertEquals(200,result.getStatusCodeValue());

Assertions.assertEquals(1,resources.size());



}

@Test
void deleteSUBCategory(){

    SubCategory subCategory = new SubCategory();
    subCategory.setId(1l);
    subCategory.setName("Chicken tandoori");
    Resource<SubCategory> resource = new Resource<>(1l, OBJECT_TYPE, subCategory);
    HttpHeaders headers=new HttpHeaders();

    ResponseEntity<Resource> result=new ResponseEntity<>(resource,HttpStatus.OK);

    when(restTemplate.exchange(Mockito.anyString(),
            Mockito.<HttpMethod>any(),
            Mockito.<HttpEntity<Resource>>any(),
            Mockito.<Class<Resource>>any())).
            thenReturn(result);
    Resource<SubCategory> responseEntity=subCategoryGateway.deleteSubCategoryById(1l);
    Assertions.assertEquals(responseEntity, result.getBody());
}

    @Test
    void postSubCategory()  {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(1l);
            subCategory.setName("Chicken tandoori");
        Resource<SubCategory> resource = new Resource<>(1l, OBJECT_TYPE, subCategory);
        HttpHeaders headers=new HttpHeaders();

        ResponseEntity<Resource> result=new ResponseEntity<>(resource,HttpStatus.OK);

        when(restTemplate.exchange(Mockito.anyString(),
                Mockito.<HttpMethod>any(),
                Mockito.<HttpEntity<Resource>>any(),
                Mockito.<Class<Resource>>any())).
                thenReturn(result);
        Resource<SubCategory> responseEntity=subCategoryGateway.addNewSubCategory(resource);
        Assertions.assertEquals(responseEntity, result.getBody());
    }
@Test
    void updateSubCategory()  {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(1l);
        subCategory.setName("Chicken tandoori");
        Resource<SubCategory> resource = new Resource<>(1l, OBJECT_TYPE, subCategory);
        HttpHeaders headers=new HttpHeaders();

        ResponseEntity<Resource> result=new ResponseEntity<>(resource,HttpStatus.OK);

        when(restTemplate.exchange(Mockito.anyString(),
                Mockito.<HttpMethod>any(),
                Mockito.<HttpEntity<Resource>>any(),
                Mockito.<Class<Resource>>any())).
                thenReturn(result);
        Resource<SubCategory> responseEntity=subCategoryGateway.updateSubCategory(resource,1l);
        Assertions.assertEquals(responseEntity, result.getBody());
    }


}