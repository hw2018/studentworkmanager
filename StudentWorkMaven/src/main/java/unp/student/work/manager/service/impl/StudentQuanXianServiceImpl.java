package unp.student.work.manager.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.StudentQuanXianDao;
import unp.student.work.manager.domain.StudentQuanxian;
import unp.student.work.manager.service.StudentQuanXianService;

@Service("studentQuanXianService")
public class StudentQuanXianServiceImpl implements StudentQuanXianService {

	@Resource
	private StudentQuanXianDao studentQuanXianDao;
	public StudentQuanxian getByStduent(String studentid) {
		// TODO Auto-generated method stub
		return studentQuanXianDao.getByStudent(studentid);
	}

}
