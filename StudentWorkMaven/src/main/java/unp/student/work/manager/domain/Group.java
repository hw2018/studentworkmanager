package unp.student.work.manager.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="group_info")

public class Group{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //社团自增长id
	private String name; //社团名字
	private String res; //社团负责人
	private String description; //社团的描述
	private Date createTime; //添加该信息的时间
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
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", desription=" + description + ", res=" + res + ", createTime=" + createTime
				+ "]";
	}
	public Group(Integer id, String name, String description, String res, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.res = res;
		this.createTime = createTime;
	}
	public Group(){
		super();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}