package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.MItem;
import com.example.demo.Repository.ItemRepository;

@Service
public class MItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Transactional
	public List<MItem> findList(){
		return itemRepository.findList();
	}
	@Transactional
	public List<MItem> searchItem(int categoryId,int itemId){
		return itemRepository.searchItem(categoryId, itemId);
	}
	public MItem selectItem(int itemId) {
		return itemRepository.selectItem(itemId);
	}
	@Transactional
	public void createItem(MItem mItem) {
		itemRepository.createItem(mItem);
	}
	@Transactional
	public void updateItem(int itemId, String itemName, int price) {
		itemRepository.updateItem(itemId, itemName, price);
	}
	@Transactional
	public void deleteItem(Integer itemId){
		itemRepository.deleteItem(itemId);
	}

}
