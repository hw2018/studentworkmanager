package unp.student.work.manager.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="group_meeting")
public class GroupMeeting {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer groupId;
	
	private String name;
	private Date startTime;
	private Boolean st;
	private String text;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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
	public GroupMeeting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupMeeting(Integer id,Integer groupId,String name,Date startTime,Boolean st,String text) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.name = name;
		this.st = st;
		this.startTime = startTime;
		this.text = text;
		// TODO Auto-generated constructor stub
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
}
