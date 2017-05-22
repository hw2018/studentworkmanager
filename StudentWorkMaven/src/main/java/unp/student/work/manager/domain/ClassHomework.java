package unp.student.work.manager.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="class_homework")
public class ClassHomework {
	@Id
	@GeneratedValue
	private Integer id;
	private String course;
    private String content;
    
	private String studentid;
    //@ManyToOne(targetEntity=PersonInfo.class)
   // @JoinColumn(name="studentid",nullable=false)
   // private PersonInfo person;
	private Date startdate;
	private Date deadline;
	private String submit;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	//public PersonInfo getPerson() {
	//	return person;
	//}
	//public void setPerson(PersonInfo person) {
	//	this.person = person;
	//}
	
	public Date getStartdate() {
		return startdate;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
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

	
}
