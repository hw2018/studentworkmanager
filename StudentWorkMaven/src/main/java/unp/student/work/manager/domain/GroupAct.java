package unp.student.work.manager.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="group_act")
public class GroupAct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer groupId;
	private String name;
	private Date actTime;
	private Boolean st;
	private String text;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getActTime() {
		return actTime;
	}
	public void setActTime(Date actTime) {
		this.actTime = actTime;
	}
	public Boolean getSt() {
		return st;
	}
	public void setSt(Boolean st) {
		this.st = st;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public GroupAct(){
		super();
	}
	
	public GroupAct(Integer id,Integer groupId,String name,Date actTime,Boolean st,String text){
		super();
		this.id = id;
		this.groupId = groupId;
		this.name = name;
		this.actTime = actTime;
		this.st = st;
		this.text = text;
	}

}
