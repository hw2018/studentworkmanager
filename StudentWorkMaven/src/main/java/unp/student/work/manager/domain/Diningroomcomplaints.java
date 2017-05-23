package unp.student.work.manager.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity 
@Table(name="campus_diningroom_complaints")
public class Diningroomcomplaints {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name",unique=true)
	private String  name;
	private String  diningroom;
	private String schoolId2;
	private Date time;
	private String type;
	private String  reason;
	
	
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
	public String getDiningroom() {
		return diningroom;
	}
	public void setDiningroom(String diningroom) {
		this.diningroom = diningroom;
	}
	public String getSchoolId2() {
		return schoolId2;
	}
	public void setSchoolId2(String schoolId2) {
		this.schoolId2 = schoolId2;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	public Diningroomcomplaints(Integer id, String name, String diningroom, String schoolId2, Date time, String type, String reason ) {
		super();
		this.id = id;
		this.name = name;
		this.diningroom = diningroom;
		this.schoolId2 = schoolId2;
		this.time = time;
		this.type = type;
		this.reason = reason;
	}
	public Diningroomcomplaints() {
		super();
	}	
}

