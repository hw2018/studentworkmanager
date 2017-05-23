package unp.student.work.manager.controller;

import com.opensymphony.xwork2.ActionSupport;

import org.junit.runner.Request;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.stereotype.Component;

import unp.student.work.manager.dao.GStudentDao;
import unp.student.work.manager.dao.impl.GStudentDaoImpl;
import unp.student.work.manager.domain.GStudent;

@Component
public class GStudentAction extends ActionSupport {
	private GStudent groupStudent;

	private GStudentDao gStudentDao=new GStudentDaoImpl();
	
	public String add(){
		System.out.println(groupStudent.getGroupId());
		System.out.println(groupStudent.getJob());
		System.out.println(groupStudent.getStuno());
		gStudentDao.insert(groupStudent);
		return SUCCESS;
	}
	
	public String update(){
		System.out.println(groupStudent.getGroupId());
		System.out.println(groupStudent.getId());
		System.out.println(groupStudent.getStuno());
		System.out.println(groupStudent.getJob());
		gStudentDao.update(groupStudent);
		return SUCCESS;
	}
	
	public String delete(){
		gStudentDao.delete(groupStudent.getId());
		return SUCCESS;
	}

	public GStudent getGroupStudent() {
		return groupStudent;
	}

	public void setGroupStudent(GStudent groupStudent) {
		this.groupStudent = groupStudent;
	}
	
}
