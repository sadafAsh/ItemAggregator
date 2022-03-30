package com.soj.item.aggregator.rest.template.gateway;

import com.soj.item.aggregator.dto.SubCategory;
import com.soj.item.aggregator.util.Resource;

import java.util.List;

public interface SubCategoryGateway {

    public Resource<SubCategory> getSubCategory(long id);
    public List<Resource<SubCategory>> findAllSubCategory();
    public Resource<SubCategory> addNewSubCategory(Resource<SubCategory> subCategory);
    public Resource<SubCategory> deleteSubCategoryById(long id);
    public Resource<SubCategory> updateSubCategory(Resource<SubCategory> subCategory,long id);
}
