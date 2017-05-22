package unp.student.work.manager.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.ClassActivityDao;
import unp.student.work.manager.dao.UserDao;
import unp.student.work.manager.domain.ClassActivity;
import unp.student.work.manager.domain.PersonInfo;
import unp.student.work.manager.service.ClassActivityService;
import unp.student.work.manager.utils.PageBean;

@Service("classActivityService")
public class ClassActivityServiceImpl extends BaseServiceImpl<ClassActivity> implements ClassActivityService {	
	@Autowired
	private ClassActivityDao classActivityDao;
	

	
	public ClassActivityServiceImpl() {
		super(ClassActivity.class);
		// TODO Auto-generated constructor stub
	}
	

	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List funds=classActivityDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=funds;
		pageBean.maxRowCount=(int) classActivityDao.findCount(ClassActivity.class);
		pageBean.countMaxPage();
		return pageBean;
				
	}
	
	
	public void update(ClassActivity classactivity){
		ClassActivity f=classActivityDao.get(ClassActivity.class, classactivity.getId());
		f.setName(classactivity.getName());
		f.setStudentid(classactivity.getStudentid());
		f.setPlace(classactivity.getPlace());
		f.setContent(classactivity.getContent());
		f.setDate(classactivity.getDate());
		f.setNumber(classactivity.getNumber());
		f.setMaster(classactivity.getMaster());
	}
	
	
	public PageBean findById(int id, int pageSize) {
		List funds=classActivityDao.findById(id, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.data=funds;
		pageBean.countMaxPage();
		return pageBean;
		
		//public Void add(ClassActivity classactivity,String id) {
			
			
		//}
			
				
	}


	
}
