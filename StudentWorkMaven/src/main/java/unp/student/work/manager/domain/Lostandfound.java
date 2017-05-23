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
@Table(name="campus_lost_and_found")
public class Lostandfound {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name",unique=true)
	private String  name;
	private String schoolId1;
	private String  type;
	private Date lostdate;
	private String  description;
	private Date    releasedate;
	private Date  finddate;
	private String  findname;
	private String  tradetype;
	private String  tradeplace;
	
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
	public String getSchoolId1() {
		return schoolId1;
	}
	public void setSchoolId1(String schoolId1) {
		this.schoolId1 = schoolId1;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getLostdate() {
		return lostdate;
	}
	public void setLostdate(Date lostdate) {
		this.lostdate = lostdate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getFinddate() {
		return finddate;
	}
	public void setFinddate(Date finddate) {
		this.finddate = finddate;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	public String getFindname() {
		return findname;
	}
	public void setFindname(String findname) {
		this.findname = findname;
	}
	public String getTradetype() {
		return tradetype;
	}
	public void setTradetype(String tradetype) {
		this.tradetype = tradetype;
	}
	public String getTradeplace() {
		return tradeplace;
	}
	public void setTradeplace(String tradeplace) {
		this.tradeplace = tradeplace;
	}
	
	
	
	
	
	
	
	
	public Lostandfound(Integer id, String name, String schoolId1, String type, Date lostdate, String description, 
			Date finddate, Date releasedate, String findname, String tradetype, String tradeplace) {
		super();
		this.id = id;
		this.name = name;
		this.schoolId1 = schoolId1;
		this.type = type;
		this.lostdate = lostdate;
		this.description = description;
		this.finddate = finddate;
		this.releasedate = releasedate;
		this.findname = findname;
		this.tradetype = tradetype;
		this.tradeplace = tradeplace;
	}
	public Lostandfound() {
		super();
	}	
}

