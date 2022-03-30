package com.soj.item.aggregator.rest.template.gateway.impl;

import com.soj.item.aggregator.config.AggregatorConfig;
import com.soj.item.aggregator.dto.Category;

import com.soj.item.aggregator.rest.template.gateway.CategoryGateway;

import com.soj.item.aggregator.util.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryGatewayImpl implements CategoryGateway {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AggregatorConfig aggregator;

    public String getUrl(){
        String contextPath=aggregator.getContextPath();
        String url=aggregator.getBaseUrl();
        String category=aggregator.getCategory();
        return url+contextPath+category;
    }


    @Override
    public List<Resource<Category>> findAll() {
        HttpHeaders headers=new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Resource<Category>>> entity=new HttpEntity<>(headers);
        return restTemplate.exchange(getUrl(), HttpMethod.GET, entity, new ParameterizedTypeReference<List<Resource<Category>>>() {
        }).getBody();

    }

    @Override
    public Resource getCategoryById(long id) {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Resource<Category>> entity=new HttpEntity<>(headers);
        return restTemplate.exchange(getUrl()+id, HttpMethod.GET,entity,Resource.class).getBody();
    }

    @Override
    public Resource createCategory(Resource<Category> category) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Resource<Category>> entity=new HttpEntity<>(category,headers);
        return restTemplate.exchange(getUrl(),HttpMethod.POST,entity,Resource.class).getBody();
    }

    @Override
    public Resource deleteCategory(long id) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Resource<Category>> entity=new HttpEntity<>(headers);
        return restTemplate.exchange(getUrl()+id,HttpMethod.DELETE,entity,Resource.class).getBody();
    }

    @Override
    public Resource updateCategory(long id, Resource<Category> category) {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Resource<Category>> entity=new HttpEntity<>(category,headers);
        return restTemplate.exchange(getUrl()+id,HttpMethod.PUT,entity,Resource.class).getBody();

    }

}
