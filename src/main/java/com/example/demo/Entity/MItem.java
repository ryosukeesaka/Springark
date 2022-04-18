package com.example.demo.Entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="m_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MItem implements Serializable {
//	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
	private int itemId;
	
	private String itemCategoryName;
	
	private int itemCategoryId;
	
	private String itemName;
	
	private int price;
	
	private String registerDate;
	
	private String updateDate;
	
	private String deleteFlg = "0";
	
	private String updatePerson;
	
	private String registerPerson;
	
	public MItem(int itemCategoryId, String itemName,int price) {
		this.itemCategoryId = itemCategoryId;
		this.itemName = itemName;
		this.price = price;
		//this.deleteFlg = "0";
	}
	
	
	
	

}
