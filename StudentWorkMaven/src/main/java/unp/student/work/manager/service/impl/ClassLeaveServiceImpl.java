package unp.student.work.manager.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.ClassLeaveDao;
import unp.student.work.manager.dao.UserDao;
import unp.student.work.manager.domain.ClassLeave;
import unp.student.work.manager.domain.PersonInfo;
import unp.student.work.manager.service.ClassLeaveService;
import unp.student.work.manager.utils.PageBean;

@Service("classLeaveService")
public class ClassLeaveServiceImpl extends BaseServiceImpl<ClassLeave> implements ClassLeaveService {	
	@Autowired
	private ClassLeaveDao classLeaveDao;
	

	
	public ClassLeaveServiceImpl() {
		super(ClassLeave.class);
		// TODO Auto-generated constructor stub
	}
	
	
	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List funds=classLeaveDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=funds;
		pageBean.maxRowCount=(int) classLeaveDao.findCount(ClassLeave.class);
		pageBean.countMaxPage();
		return pageBean;
				
	}
	
	
	public void update(ClassLeave classleave){
		ClassLeave f=classLeaveDao.get(ClassLeave.class, classleave.getId());
		f.setLeavedate(classleave.getLeavedate());
		f.setLeavereason(classleave.getLeavereason());
		f.setAgree(classleave.getAgree());
		f.setBackdate(classleave.getBackdate());
		f.setStudentid(classleave.getStudentid());
		f.setInstructor(classleave.getInstructor());
	}
	
	
	public PageBean findById(int id, int pageSize) {
		List funds=classLeaveDao.findById(id, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.data=funds;
		pageBean.countMaxPage();
		return pageBean;
				
	}


	
}
