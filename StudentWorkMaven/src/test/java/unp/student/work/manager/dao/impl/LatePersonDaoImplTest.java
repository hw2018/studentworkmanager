package unp.student.work.manager.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.objectweb.asm.tree.IntInsnNode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import unp.student.work.manager.dao.WorkLatePersonDao;
import unp.student.work.manager.domain.late_person;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")
public class LatePersonDaoImplTest {

	@Resource
	private WorkLatePersonDao latePersonDao;
	@Test
	public void testFindPageByManager() {
		List l=latePersonDao.findPageByManager("221400405", 1);
		for(int i=0;i<l.size();i++){
			late_person late_person=(late_person)l.get(i);
			System.out.println(late_person.getId());
		}
	}

	@Test
	public void testFindPageByStudent() {
		List l=latePersonDao.findPageByStudent("221400401", 1);
		for(int i=0;i<l.size();i++){
			late_person late_person=(late_person)l.get(i);
			System.out.println(late_person.getId());
		}
	}
	@Test
	public void testFindPageByLateInfo() {
		List l=latePersonDao.findPageByLateInfo(2, 1);
		for(int i=0;i<l.size();i++){
			late_person late_person=(late_person)l.get(i);
			System.out.println(late_person.getId());
		}
	}
	
	@Test
	public void testFindCountByLateInfo() {
		//System.out.println(latePersonDao.findCountByLateInfo(6, 1));
		
	}
}
