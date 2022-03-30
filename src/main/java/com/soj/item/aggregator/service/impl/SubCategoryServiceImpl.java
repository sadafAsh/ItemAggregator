package com.soj.item.aggregator.service.impl;

import com.soj.item.aggregator.dto.SubCategory;
import com.soj.item.aggregator.rest.template.gateway.SubCategoryGateway;
import com.soj.item.aggregator.service.SubCategoryService;
import com.soj.item.aggregator.util.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryGateway subCategoryGateway;


    @Override
    public Resource<SubCategory> getSubCategory(long id) {
         return subCategoryGateway.getSubCategory(id);

    }

    @Override
    public List<Resource<SubCategory>> getListAllSubCategory() {
        return subCategoryGateway.findAllSubCategory();
    }

    @Override
    public Resource<SubCategory> deleteSubCategory(long id) {
        return subCategoryGateway.deleteSubCategoryById(id);
    }

    @Override
    public Resource<SubCategory> updateSubCategoryById(Resource<SubCategory> subCategory, long id) {
        return subCategoryGateway.updateSubCategory(subCategory,id);
    }

    @Override
    public Resource<SubCategory> createNewSubCategory(Resource subCategory) {
        return subCategoryGateway.addNewSubCategory(subCategory);
    }
}
