package unp.student.work.manager.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import unp.student.work.manager.service.WorkLateInfoService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")
public class LateInfoServiceImplTest {

	@Resource
	private WorkLateInfoService lateInfoService;
	@Test
	public void testShowInfo() {
		lateInfoService.showInfo(1, 2);
	}

}
