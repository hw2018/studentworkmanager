package unp.student.work.manager.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.ClassPositionDao;
import unp.student.work.manager.dao.UserDao;
import unp.student.work.manager.domain.ClassPosition;
import unp.student.work.manager.domain.PersonInfo;
import unp.student.work.manager.service.ClassPositionService;
import unp.student.work.manager.utils.PageBean;

@Service("classPositionService")
public class ClassPositionServiceImpl extends BaseServiceImpl<ClassPosition> implements ClassPositionService {	
	@Autowired
	private ClassPositionDao classPositionDao;
	

	
	public ClassPositionServiceImpl() {
		super(ClassPosition.class);
		// TODO Auto-generated constructor stub
	}
	

	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List funds=classPositionDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=funds;
		pageBean.maxRowCount=(int) classPositionDao.findCount(ClassPosition.class);
		pageBean.countMaxPage();
		return pageBean;
				
	}
	

	public void update(ClassPosition classposition){
		ClassPosition f=classPositionDao.get(ClassPosition.class, classposition.getId());
		f.setPosition(classposition.getPosition());
		f.setStudentid(classposition.getStudentid());
		f.setDate(classposition.getDate());
	}
	
	
	public PageBean findById(int id, int pageSize) {
		List funds=classPositionDao.findById(id, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.data=funds;
		pageBean.countMaxPage();
		return pageBean;
				
	}


	
}
