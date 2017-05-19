package unp.student.work.manager.service.impl;

import static org.junit.Assert.*;

import java.io.File;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import unp.student.work.manager.service.CounsellorService;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")
public class CounsellorServiceImplTest {

	@Resource
	private CounsellorService counsellorService;
	@Test
	public void testFindCounsellorByStudent() {
		counsellorService.findCounsellorByStudent("221400405");
	}
	
	@Test
	public void testfindProplem() {
		//System.out.println(this.getClass().getClassLoader().getResource("/").getPath());
		System.out.println(getClass().getClassLoader().getResource(""));
		counsellorService.findProblem();
		File directory = new File("");//设定为当前文件夹
		try{
		    System.out.println(directory.getCanonicalPath());//获取标准的路径
		    System.out.println(directory.getAbsolutePath());//获取绝对路径
		}catch(Exception e){} 
	}
	
	@Test
	public void testfindResult(){

		counsellorService.findResult("221400405", 1);
		
	}
	@Test
	public void testaddRecord(){
		//counsellorService.findResult("221400401", 1);
		
	}
}
