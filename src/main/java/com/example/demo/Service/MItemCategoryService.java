package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.MItemCategory;
import com.example.demo.Repository.ItemCategoryRepository;


@Service
public class MItemCategoryService {
	
	@Autowired
	private ItemCategoryRepository itemCategoryRepository;
	
//	@Transactional
//	public List<MItemCategory> findList(){
//		return itemCategoryRepository.findList();
//	}
	
	public List<MItemCategory> findList(){
		MItemCategory i = new MItemCategory();
		i.setItemCategoryId(0);
		i.setItemCategoryName("全て");
		List<MItemCategory> mItem = new ArrayList<MItemCategory>();
		mItem.add(i);
		List<MItemCategory> tmp = itemCategoryRepository.findList();
		tmp.add(0,i);
		//mItem.addAll(tmp);
		return tmp;
	}
	
}
