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

import unp.student.work.manager.domain.ClassHomework;

import unp.student.work.manager.domain.PersonInfo;
import unp.student.work.manager.service.ClassHomeworkService;
import unp.student.work.manager.utils.PageBean;

@Scope("prototype")
@Controller("classHomeworkAction")
public class ClassHomeworkAction extends ActionSupport {
	private Integer id;
	private Integer pageNo=1;
	private PageBean pageBean;
	private ClassHomework classhomework;
	private String course;
    private String content;
	private String studentid;
	private Date startdate;
	private Date deadline;
	private String submit;

	// @ManyToOne(targetEntity=PersonInfo.class)
    //@JoinColumn(name="studentid",referencedColumnName="studentid",nullable=false)
   // private PersonInfo person;
	@Resource
	private ClassHomeworkService classhomeworkService;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ClassHomework getClasshomework() {
		return classhomework;
	}
	public void setClasshomework(ClassHomework classhomework) {
		this.classhomework = classhomework;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}


	
	
	
	public String update(){
		classhomework=classhomeworkService.findById(id);
		return "update";
	}
	public String add(){
		//Fund fund=new Fund(0, fundName, fundDes, fundPrice, fundStatus, new Date());
		classhomeworkService.save(classhomework);
		return SUCCESS;
	}
	public String show(){
		pageBean=classhomeworkService.findByPage(pageNo, 10);
		Map<String ,Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("pageBean", pageBean);
		return "show";
	}
	
	public String save(){
		classhomeworkService.update(classhomework);
		return SUCCESS;
	}
	
	public String delete(){
		classhomeworkService.deleteById(id);
		return SUCCESS;
	}
	
	public String search(){
		pageBean=classhomeworkService.findById(id, 10);
		Map<String ,Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("pageBean", pageBean);
		return "show";
	}
	
}
