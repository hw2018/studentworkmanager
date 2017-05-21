package unp.student.work.manager.service.impl;

import java.util.List;

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
	public List<StudentQuanxian> query(String studentid, int pageno, int size) {
		// TODO Auto-generated method stub
		return studentQuanXianDao.query(studentid, pageno, size);
	}
	
	
	public Long findCount(){
		return studentQuanXianDao.findCount(StudentQuanxian.class);
	}
	public void save(StudentQuanxian sq) {
		// TODO Auto-generated method stub
		studentQuanXianDao.save(sq);
		
	}
	public void update(StudentQuanxian sq) {
		// TODO Auto-generated method stub
		studentQuanXianDao.update(sq);
	}
	public void deleteByIds(String ids) {
		// TODO Auto-generated method stub
		studentQuanXianDao.deleteByIds(ids);
	}


}
