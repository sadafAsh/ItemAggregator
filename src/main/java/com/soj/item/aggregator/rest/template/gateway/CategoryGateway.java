package com.soj.item.aggregator.rest.template.gateway;


import com.soj.item.aggregator.dto.Category;
import com.soj.item.aggregator.util.Resource;

import java.util.List;

public interface CategoryGateway {

    public List<Resource<Category>> findAll();
    public Resource getCategoryById(long id);
    public Resource createCategory(Resource<Category> category);
    public Resource deleteCategory(long id);
    public Resource updateCategory(long id ,Resource<Category> category);

}
