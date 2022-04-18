package com.example.demo.Form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class CreateForm {
	
	private int itemId;
	
	private int itemCategoryId;
	
	@NotEmpty(message="商品名が入力されていません。")
    @Size(min=1,max=100,message="商品名は100文字以内です。")
	private String itemName;

	@Range(min= 10 , max= 9999,message="値段は10円以上、9999円以内です。" )
	private int price;
	
	private String deleteFlg;

}
