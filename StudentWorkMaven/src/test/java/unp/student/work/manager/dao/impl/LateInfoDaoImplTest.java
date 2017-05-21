package unp.student.work.manager.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import unp.student.work.manager.dao.WorkLateInfoDao;
import unp.student.work.manager.domain.late_info;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")
public class LateInfoDaoImplTest {

	@Resource
	private WorkLateInfoDao lateInfoDao=new WorkLateInfoDaoImpl();
	@Test
	public void testFindByPage() {
		List<late_info> list=(List<late_info>)lateInfoDao.findByPage(1);
		for(late_info late_info:list){
			System.out.println(late_info.getNum()+"   "+late_info.getPersonInfo().getStudentid());
		}
	}

	@Test
	public void testFindCount() {
	}

	@Test
	public void testsave() {
		lateInfoDao.save(new late_info());
	}
}
