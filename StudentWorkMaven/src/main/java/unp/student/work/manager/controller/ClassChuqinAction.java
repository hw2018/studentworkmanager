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

import unp.student.work.manager.domain.ClassChuqin;
import unp.student.work.manager.domain.PersonInfo;
import unp.student.work.manager.service.ClassChuqinService;
import unp.student.work.manager.utils.PageBean;

@Scope("prototype")
@Controller("classChuqinAction")
public class ClassChuqinAction extends ActionSupport {
	private Integer id;
	private Integer pageNo=1;
	private PageBean pageBean;
	private ClassChuqin classchuqin;
	private String studentid;
	private String course;
    private Date date;

	// @ManyToOne(targetEntity=PersonInfo.class)
    //@JoinColumn(name="studentid",referencedColumnName="studentid",nullable=false)
   // private PersonInfo person;
	@Resource
	private ClassChuqinService classchuqinService;
	
	
	
	public ClassChuqin getClasschuqin() {
		return classchuqin;
	}

	public void setClasschuqin(ClassChuqin classchuqin) {
		this.classchuqin = classchuqin;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

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


	public String update(){
		classchuqin=classchuqinService.findById(id);
		return "update";
	}
	public String add(){
		//Fund fund=new Fund(0, fundName, fundDes, fundPrice, fundStatus, new Date());
		classchuqinService.save(classchuqin);
		return SUCCESS;
	}
	public String show(){
		pageBean=classchuqinService.findByPage(pageNo, 10);
		Map<String ,Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("pageBean", pageBean);
		return "show";
	}
	
	public String save(){
		classchuqinService.update(classchuqin);
		return SUCCESS;
	}
	
	public String delete(){
		classchuqinService.deleteById(id);
		return SUCCESS;
	}
	
	public String search(){
		pageBean=classchuqinService.findById(id, 10);
		Map<String ,Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("pageBean", pageBean);
		return "show";
	}
	
}
