package unp.student.work.manager.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="class_chuqin")
public class ClassChuqin {
	@Id
	@GeneratedValue
	private Integer id;
	private String course;
    //
	private String studentid;
   // @ManyToOne(targetEntity=PersonInfo.class)
   // @JoinColumn(name="studentid",nullable=false)
   // private PersonInfo person;
    private Date date;
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

    
    

}
