package com.soj.item.aggregator.controller;

import com.soj.item.aggregator.dto.SubCategory;
import com.soj.item.aggregator.service.SubCategoryService;
import com.soj.item.aggregator.util.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("template")
public class SubCategoryController {

    @Autowired
     private SubCategoryService subCategoryService;

@GetMapping
    @RequestMapping(value = "/subCategory/{id}")
    public Resource<SubCategory> getById(@PathVariable long id) {
    return subCategoryService.getSubCategory(id);
}
  @GetMapping
          @RequestMapping(value = "/subCategory")
  public List<Resource<SubCategory>> findAllSubCategory(){
      return subCategoryService.getListAllSubCategory();
    }
@PostMapping(value = "/subCategory")
    public Resource<SubCategory> addNewSubCategory(@RequestBody Resource<SubCategory> subCategory){
    return subCategoryService.createNewSubCategory(subCategory);
}


    @RequestMapping(value = "/subCategory/{id}",method = RequestMethod.DELETE)
    public Resource<SubCategory> deleteSubCategoryById(@PathVariable long id){
    return subCategoryService.deleteSubCategory(id);
}
@RequestMapping(value ="/subCategory/{id}",method = RequestMethod.PUT)
    public Resource<SubCategory> updateSubCategoryById(@PathVariable long id,@RequestBody Resource<SubCategory> subCategory){
    return subCategoryService.updateSubCategoryById(subCategory,id);
}

}


