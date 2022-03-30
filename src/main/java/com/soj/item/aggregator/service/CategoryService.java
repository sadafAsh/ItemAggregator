package com.soj.item.aggregator.service;

import com.soj.item.aggregator.dto.Category;
import com.soj.item.aggregator.util.Resource;

import java.util.List;

public interface CategoryService {

    public List<Resource<Category>> getAllList();
    public Resource<Category> getCategory(long id);
    public Resource<Category> addNewCategory(Resource<Category> category);
    public Resource<Category> deleteCategoryById(long id);
    public Resource<Category> updateCategory(long id,Resource<Category> category);

}
