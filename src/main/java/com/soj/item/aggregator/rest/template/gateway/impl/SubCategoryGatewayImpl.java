package com.soj.item.aggregator.rest.template.gateway.impl;

import com.soj.item.aggregator.config.AggregatorConfig;
import com.soj.item.aggregator.dto.SubCategory;
import com.soj.item.aggregator.rest.template.gateway.SubCategoryGateway;
import com.soj.item.aggregator.util.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component

public class SubCategoryGatewayImpl implements SubCategoryGateway {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AggregatorConfig aggregator;




    public String getUrl(){
        String contextPath=aggregator.getContextPath();
        String url=aggregator.getBaseUrl();
        String subCategory=aggregator.getSubcategory();
        return url+contextPath+subCategory;
    }

    @Override
    public Resource<SubCategory> getSubCategory(long id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<SubCategory> entity = new HttpEntity<>( headers);
        return restTemplate.exchange(getUrl()+id,HttpMethod.GET,entity,Resource.class).getBody();

    }

    @Override
    public List<Resource<SubCategory>> findAllSubCategory() {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Resource<SubCategory>>> entity=new HttpEntity<>(headers);
        return restTemplate.exchange(getUrl(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<Resource<SubCategory>>>() {}).getBody();

    }

    @Override
    public Resource<SubCategory> deleteSubCategoryById(long id) {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Resource<SubCategory>> entity=new HttpEntity<>(headers);
        return restTemplate.exchange(getUrl()+id,HttpMethod.DELETE,entity,Resource.class).getBody();
    }

    @Override
    public Resource<SubCategory> updateSubCategory(Resource<SubCategory> subCategory,long id) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Resource<SubCategory>> entity=new HttpEntity<>(subCategory,headers);
        return restTemplate.exchange(getUrl()+id,HttpMethod.PUT,entity,Resource.class).getBody();
    }

    @Override
    public Resource<SubCategory> addNewSubCategory(Resource subCategory1) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Resource<SubCategory>> entity=new HttpEntity<>(subCategory1,headers);
        return   restTemplate.exchange(getUrl(),HttpMethod.POST,entity,Resource.class).getBody();


    }





}
