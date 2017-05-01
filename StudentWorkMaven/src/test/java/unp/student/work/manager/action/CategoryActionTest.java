package unp.student.work.manager.action;

import static org.junit.Assert.*;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import unp.student.work.manager.controller.CategoryAction;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")
public class CategoryActionTest {

	@Resource
	private CategoryAction categoryAction;
	@Test
	public void testSave() {
		categoryAction.save();
	}

}
