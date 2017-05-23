package unp.student.work.manager.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="apply_activity")
public class Activity {
@Override
	public String toString() {
		return "Activity [id=" + id + ", peoplenumber=" + peoplenumber + ", carnumber=" + carnumber + ", leadteacher="
				+ leadteacher + ", leadteacherphone=" + leadteacherphone + ", principal=" + principal + ", createTime="
				+ createTime + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int peoplenumber;
	private int carnumber;
	private String leadteacher;
	private int leadteacherphone;
	private String principal;
	private Date    createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPeoplenumber() {
		return peoplenumber;
	}
	public void setPeoplenumber(int peoplenumber) {
		this.peoplenumber = peoplenumber;
	}
	public int getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(int carnumber) {
		this.carnumber = carnumber;
	}
	public String getLeadteacher() {
		return leadteacher;
	}
	public void setLeadteacher(String leadteacher) {
		this.leadteacher = leadteacher;
	}
	public int getLeadteacherphone() {
		return leadteacherphone;
	}
	public void setLeadteacherphone(int leadteacherphone) {
		this.leadteacherphone = leadteacherphone;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Activity(int peoplenumber, int carnumber, String leadteacher, int leadteacherphone, String principal,Date createTime) {
		super();
		this.peoplenumber = peoplenumber;
		this.carnumber = carnumber;
		this.leadteacher = leadteacher;
		this.leadteacherphone = leadteacherphone;
		this.principal = principal;
		this.createTime = createTime;
	}
	public Activity() {
		super();
	}
}
