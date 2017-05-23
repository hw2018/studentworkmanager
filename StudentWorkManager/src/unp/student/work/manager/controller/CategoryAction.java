package unp.student.work.manager.controller;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;

import unp.student.work.manager.model.Category;
import unp.student.work.manager.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;

@Controller("categoryAction")
public class CategoryAction extends ActionSupport {

	@Resource
	private CategoryService categoryService;
	
	public String save(){
		System.out.println(categoryService);
		categoryService.save(new Category("¶ùÍ¯",false));
		return "index";
	}
}
