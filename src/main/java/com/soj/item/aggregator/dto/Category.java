package com.soj.item.aggregator.dto;

import java.util.List;

public class Category {

    public static final String OBJECT_TYPE="category";

    private long id;
    private String name;
    private List<SubCategory> subCategories;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}

