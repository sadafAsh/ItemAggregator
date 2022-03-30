package com.soj.item.aggregator.service;

import com.soj.item.aggregator.dto.SubCategory;
import com.soj.item.aggregator.util.Resource;

import java.util.List;

public interface SubCategoryService {

    public Resource<SubCategory> getSubCategory(long id);
public List<Resource<SubCategory>> getListAllSubCategory();
public Resource<SubCategory> createNewSubCategory(Resource<SubCategory> subCategory);
public Resource<SubCategory> deleteSubCategory(long id);
public Resource<SubCategory> updateSubCategoryById(Resource<SubCategory> subCategory,long id);
}
