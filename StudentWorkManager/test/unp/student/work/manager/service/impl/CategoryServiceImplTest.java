package unp.student.work.manager.service.impl;



import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import unp.student.work.manager.model.Category;
import unp.student.work.manager.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")
public class CategoryServiceImplTest {
	
	@Resource
	private CategoryService categoryService;
	@Test
	public void testSave() {
		categoryService.save(new Category("Ůʿ",true));
	}

}
