package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Entity.MItem;
import com.example.demo.Entity.MItemCategory;
import com.example.demo.Entity.Sample;
import com.example.demo.Form.CreateForm;
import com.example.demo.Form.SearchForm;
import com.example.demo.Form.UpdateForm;
import com.example.demo.Service.MItemCategoryService;
import com.example.demo.Service.MItemService;
import com.example.demo.Util.Csv;

@Controller
public class HeloController {
	
	@Autowired
	private MItemService mItemService;
	@Autowired
	private MItemCategoryService mItemCategoryService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model,@ModelAttribute SearchForm searchForm, @ModelAttribute UpdateForm updateForm) {
		model.addAttribute("items", mItemService.findList());
		model.addAttribute("category",mItemCategoryService.findList());
		//model.addAttribute("searchForm", searchForm);
		//model.addAttribute("updateForm", updateForm);
		List<MItemCategory> m = mItemCategoryService.findList();
		for(MItemCategory i : m) {
			System.out.println(i);
		}
		
		Sample<String> sample = new Sample<>();
		sample.setVal("A");
		String str = sample.getVal();
		System.out.println(str);
        //model.addAttribute("message", "Hello Springboot");
        return "index";
    }
	@RequestMapping(value = "/lay", method = RequestMethod.GET)
    public String lay() {

        //model.addAttribute("message", "Hello Springboot");
        return "app";
    }
	
	@RequestMapping(value = "/layout", method = RequestMethod.GET)
    public String layout() {

        //model.addAttribute("message", "Hello Springboot");
        return "layoutPractise";
    }
	
	@RequestMapping(value = "/index", params="search",method = RequestMethod.POST)
    public String serch(Model model,SearchForm searchForm) {
		int categoryId = searchForm.getItemCategoryId();
		int itemId = searchForm.getItemId();
		List<MItem> mItem = mItemService.searchItem(categoryId, itemId);
		
		model.addAttribute("msg","該当する条件はありません");
		model.addAttribute("result",mItem);
		model.addAttribute("items", mItemService.findList());
		model.addAttribute("category",mItemCategoryService.findList());
		model.addAttribute("searchForm", searchForm);
		//セレクトボックス値固定用
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("itemId", itemId);
        return "index";
    }
	
	@RequestMapping(value = "/index", params = "create", method = RequestMethod.POST)
	public String itemCreate(Model model,CreateForm createForm) {

		return "redirect:/itemCreate";
		//return getCreate(model,createForm);
	}
	
	@RequestMapping(value = "/index", params = "edit", method = RequestMethod.POST)
	public String upd(Model model,RedirectAttributes redirect,  UpdateForm updateForm) {
		
		int itemId = updateForm.getItemId();
		
		redirect.addAttribute("itemId",itemId);
		//List<MItem> mItem = mItemService.searchItem(categoryId, itemId);

		return "redirect:/itemUpdate";
		//return getCreate(model,createForm);
	}

	@RequestMapping(value = "/index", params = "csv", method = RequestMethod.POST)
	public String csv(Model model,RedirectAttributes redirect,  UpdateForm updateForm) {
		
		List<MItemCategory> m = mItemCategoryService.findList();
		Csv csv = new Csv();
		csv.exportCsv(m);

		return "redirect:/index";
		//return getCreate(model,createForm);
	}
	
	@RequestMapping(value = "/itemCreate",method = RequestMethod.GET)
	public String getCreate(Model model,CreateForm createForm) {
		
		List<MItemCategory> categoryList =  mItemCategoryService.findList();
		//categoryList.remove(categoryList.indexOf("全て"));
		model.addAttribute("items", mItemService.findList());
		model.addAttribute("category",categoryList);
		model.addAttribute("createForm",createForm);
		
		
		return "itemCreate";
	}
	
	@RequestMapping(value = "/itemCreate", params = "create",method = RequestMethod.POST)
	public String postCreate(Model model,@Validated CreateForm createForm,BindingResult result) {
		if (result.hasErrors() ) {
			model.addAttribute("items", mItemService.findList());
			model.addAttribute("category",mItemCategoryService.findList());
			model.addAttribute("createForm",createForm);
            return "itemCreate";
            
        }
		model.addAttribute("items", mItemService.findList());
		model.addAttribute("category",mItemCategoryService.findList());
		model.addAttribute("createForm",createForm);
		MItem mItem = new MItem(createForm.getItemCategoryId(),createForm.getItemName(),createForm.getPrice());
		mItemService.createItem(mItem);
		model.addAttribute("name",createForm.getItemName());
		model.addAttribute("price",createForm.getPrice());
		return "itemCreate";
	}
	
	@RequestMapping(value = "/itemCreate", params = "back",method = RequestMethod.POST)
	public String back(Model model,@Validated CreateForm createForm,BindingResult result) {
		
		
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/index", params = "delete",method = RequestMethod.POST)
    public String delete(Model model,UpdateForm updateForm) {
		mItemService.deleteItem(updateForm.getItemId());
        return "redirect:/index";
    }
	
	@RequestMapping(value = "/itemUpdate", method = RequestMethod.GET)
    public String update(Model model, @RequestParam("itemId") int itemId,UpdateForm updateForm) {
		
		MItem mItem = mItemService.selectItem(itemId);
		//model.addAttribute("item", mItem);
		model.addAttribute("itemId", itemId);
		model.addAttribute("name", mItem.getItemName());
		model.addAttribute("category", mItem.getItemCategoryName());
		model.addAttribute("price", mItem.getPrice());
		model.addAttribute("updateForm", updateForm);
        return "itemEdit";
    }
	
	@RequestMapping(value = "/itemUpdate/{id}", method = RequestMethod.GET)
    public String updatea(Model model, @PathVariable("id") int itemId,UpdateForm updateForm) {
		
		MItem mItem = mItemService.selectItem(itemId);
		//model.addAttribute("item", mItem);
		model.addAttribute("itemId", itemId);
		model.addAttribute("name", mItem.getItemName());
		model.addAttribute("category", mItem.getItemCategoryName());
		model.addAttribute("price", mItem.getPrice());
		model.addAttribute("updateForm", updateForm);
        return "itemEdit";
    }
	
	@RequestMapping(value = "/itemUpdate", params = "update",method = RequestMethod.POST)
    public String updatePost(Model model, @Validated UpdateForm updateForm, BindingResult result) {
		
		if (result.hasErrors() ) {
			
            return "itemEdit";
            
        }
		
		mItemService.updateItem(updateForm.getItemId(),updateForm.getItemName(),updateForm.getPrice());
		//MItem mItem = mItemService.selectItem(updateForm.getItemId());
		//model.addAttribute("item", mItem);
		model.addAttribute("name", updateForm.getItemName());
		model.addAttribute("category", updateForm.getCategoryName());
		model.addAttribute("price", updateForm.getPrice());
		model.addAttribute("msg", "更新しました");
		model.addAttribute("updateForm", updateForm);
        return "itemEdit";
    }
	
	@RequestMapping(value = "/itemUpdate",params="back", method = RequestMethod.POST)
    public String back() {
		
		return "redirect:/index";
    }

}
