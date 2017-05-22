package unp.student.work.manager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="group_thing")
public class GroupThing {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer groupId;
	private String name;
	private boolean status;
	private String current_user;
	private String now_user;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCurrent_user() {
		return current_user;
	}
	public void setCurrent_user(String current_user) {
		this.current_user = current_user;
	}
	public String getNow_user() {
		return now_user;
	}
	public void setNow_user(String now_user) {
		this.now_user = now_user;
	}
	public GroupThing(Integer id, Integer groupId, String name, boolean status, String current_user, String now_user) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.name = name;
		this.status = status;
		this.current_user = current_user;
		this.now_user = now_user;
	}
	public GroupThing(){
		super();
	}
}
