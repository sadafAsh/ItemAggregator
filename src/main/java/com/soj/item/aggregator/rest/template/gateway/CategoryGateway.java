package com.soj.item.aggregator.rest.template.gateway;


import com.soj.item.aggregator.dto.Category;
import com.soj.item.aggregator.util.Resource;

import java.util.List;

public interface CategoryGateway {

    public List<Resource<Category>> findAll();
    public Resource<Category> getCategoryById(long id);
    public Resource<Category> createCategory(Resource<Category> category);
    public Resource<Category> deleteCategory(long id);
    public Resource<Category> updateCategory(long id ,Resource<Category> category);

}
