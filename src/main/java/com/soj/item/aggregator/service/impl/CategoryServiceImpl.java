package com.soj.item.aggregator.service.impl;

import com.soj.item.aggregator.dto.Category;
import com.soj.item.aggregator.rest.template.gateway.CategoryGateway;
import com.soj.item.aggregator.service.CategoryService;
import com.soj.item.aggregator.util.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryGateway categoryGateway;


    @Override
    public List<Resource<Category>> getAllList() {
        return categoryGateway.findAll();
    }

    @Override
    public Resource<Category> getCategory(long id) {
        return categoryGateway.getCategoryById(id);
    }

    @Override
    public Resource<Category> addNewCategory(Resource<Category> category) {
        return categoryGateway.createCategory(category);
    }

    @Override
    public Resource<Category> deleteCategoryById(long id) {
        return categoryGateway.deleteCategory(id);
    }

    @Override
    public Resource<Category> updateCategory(long id, Resource<Category> category) {
        return categoryGateway.updateCategory(id,category);
    }
}
