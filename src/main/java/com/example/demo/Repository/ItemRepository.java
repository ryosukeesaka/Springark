package com.example.demo.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.MItem;

@Mapper
public interface ItemRepository {

	List<MItem> findList();

	List<MItem> searchItem(int categoryId, int itemId);
	
	MItem selectItem(int itemId);
	
	//void createItem(int categoryId, String itemName, int price);
	void createItem(MItem mItem);
	
	void updateItem(int itemId, String itemName, int price);
	
	void deleteItem(int itemId);
	

}