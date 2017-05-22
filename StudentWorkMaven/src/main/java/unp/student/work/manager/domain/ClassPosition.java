package unp.student.work.manager.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="class_position")
public class ClassPosition {
	@Id
	@GeneratedValue
	private Integer id;
	private String position;
    //
	private String studentid;
   // @ManyToOne(targetEntity=PersonInfo.class)
   // @JoinColumn(name="studentid",nullable=false)
   // private PersonInfo person;
    private String date;
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
    
    

}
