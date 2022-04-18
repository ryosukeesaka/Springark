package com.example.demo.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.MItemCategory;

@Mapper
public interface ItemCategoryRepository {

	List<MItemCategory> findList();
}
