package unp.student.work.manager.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.ClassHomeworkDao;
import unp.student.work.manager.dao.ClassPositionDao;
import unp.student.work.manager.dao.UserDao;
import unp.student.work.manager.domain.ClassHomework;
import unp.student.work.manager.domain.ClassPosition;
import unp.student.work.manager.domain.PersonInfo;
import unp.student.work.manager.service.ClassHomeworkService;
import unp.student.work.manager.service.ClassPositionService;
import unp.student.work.manager.utils.PageBean;

@Service("classHomeworkService")
public class ClassHomeworkServiceImpl extends BaseServiceImpl<ClassHomework> implements ClassHomeworkService {	
	@Autowired
	private ClassHomeworkDao classHomeworkDao;
	

	
	public ClassHomeworkServiceImpl() {
		super(ClassHomework.class);
		// TODO Auto-generated constructor stub
	}
	

	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List funds=classHomeworkDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=funds;
		pageBean.maxRowCount=(int) classHomeworkDao.findCount(ClassHomework.class);
		pageBean.countMaxPage();
		return pageBean;
				
	}
	
	
	public void update(ClassHomework classhomework){
		ClassHomework f=classHomeworkDao.get(ClassHomework.class, classhomework.getId());
		f.setCourse(classhomework.getCourse());
		f.setStudentid(classhomework.getStudentid());	
		f.setContent(classhomework.getContent());
		f.setStudentid(classhomework.getStudentid());
		f.setStartdate(classhomework.getStartdate());
		f.setDeadline(classhomework.getDeadline());
		f.setSubmit(classhomework.getSubmit());

	}
	
	
	public PageBean findById(int id, int pageSize) {
		List funds=classHomeworkDao.findById(id, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.data=funds;
		pageBean.countMaxPage();
		return pageBean;
				
	}


	
}
