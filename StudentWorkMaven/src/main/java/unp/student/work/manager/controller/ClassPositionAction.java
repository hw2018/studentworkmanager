package unp.student.work.manager.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.ClassPosition;
import unp.student.work.manager.domain.PersonInfo;
import unp.student.work.manager.service.ClassPositionService;
import unp.student.work.manager.utils.PageBean;

@Scope("prototype")
@Controller("classPositionAction")
public class ClassPositionAction extends ActionSupport {
	private Integer id;
	private Integer pageNo=1;
	private String position;
	private PageBean pageBean;
	private ClassPosition classposition;
    //
	private String studentid;
  

	// @ManyToOne(targetEntity=PersonInfo.class)
    //@JoinColumn(name="studentid",referencedColumnName="studentid",nullable=false)
   // private PersonInfo person;
    private String date;
	@Resource
	private ClassPositionService classpositionService;
	
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	//public PersonInfo getPerson() {
	//	return person;
	//}

	//public void setPerson(PersonInfo person) {
	//	this.person = person;
	//}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

	public ClassPosition getClassposition() {
		return classposition;
	}

	public void setClassposition(ClassPosition classposition) {
		this.classposition = classposition;
	}

	public String update(){
		classposition=classpositionService.findById(id);
		return "update";
	}
	public String add(){
		//Fund fund=new Fund(0, fundName, fundDes, fundPrice, fundStatus, new Date());
		classpositionService.save(classposition);
		return SUCCESS;
	}
	public String show(){
		pageBean=classpositionService.findByPage(pageNo, 10);
		Map<String ,Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("pageBean", pageBean);
		return "show";
	}
	
	public String save(){
		classpositionService.update(classposition);
		return SUCCESS;
	}
	
	public String delete(){
		classpositionService.deleteById(id);
		return SUCCESS;
	}
	
	public String search(){
		pageBean=classpositionService.findById(id, 10);
		Map<String ,Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("pageBean", pageBean);
		return "show";
	}
	
}
