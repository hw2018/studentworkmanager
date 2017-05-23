package unp.student.work.manager.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.ClassChuqinDao;
import unp.student.work.manager.dao.ClassPositionDao;
import unp.student.work.manager.dao.UserDao;
import unp.student.work.manager.domain.ClassChuqin;
import unp.student.work.manager.domain.ClassPosition;
import unp.student.work.manager.domain.PersonInfo;
import unp.student.work.manager.service.ClassChuqinService;
import unp.student.work.manager.service.ClassPositionService;
import unp.student.work.manager.utils.PageBean;

@Service("classChuqinService")
public class ClassChuqinServiceImpl extends BaseServiceImpl<ClassChuqin> implements ClassChuqinService {	
	@Autowired
	private ClassChuqinDao classChuqinDao;
	

	
	public ClassChuqinServiceImpl() {
		super(ClassChuqin.class);
		// TODO Auto-generated constructor stub
	}
	

	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List funds=classChuqinDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=funds;
		pageBean.maxRowCount=(int) classChuqinDao.findCount(ClassChuqin.class);
		pageBean.countMaxPage();
		return pageBean;
				
	}
	

	public void update(ClassChuqin classchuqin){
		ClassChuqin f=classChuqinDao.get(ClassChuqin.class, classchuqin.getId());
		f.setCourse(classchuqin.getCourse());
		f.setStudentid(classchuqin.getStudentid());
		f.setDate(classchuqin.getDate());
	}
	
	
	public PageBean findById(int id, int pageSize) {
		List funds=classChuqinDao.findById(id, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.data=funds;
		pageBean.countMaxPage();
		return pageBean;
				
	}


	
}
