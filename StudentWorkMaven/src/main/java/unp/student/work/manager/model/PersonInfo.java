package unp.student.work.manager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PersonInfo entity. @author MyEclipse Persistence Tools
 */

public class PersonInfo implements java.io.Serializable {

	// Fields

	private String studentid;
	private String name;
	private String sex;
	private String idcard;
	private String nation;
	private Date birthday;
	private String placeofbirth;
	private String politicalstatus;
	private Integer majorid;
	private String grade;
	private String tel;
	private String email;
	private String password;
	private String college;
	private Integer status;
	private Integer build;
	private Integer hostel;
	private Integer dormId;
	private Set late_infos = new HashSet(0);
	private Set late_persons = new HashSet(0);
	private Set social_pratices = new HashSet(0);
	private Set comprehensive_records = new HashSet(0);


	// Constructors

	/** default constructor */
	public PersonInfo() {
	}

	/** minimal constructor */
	public PersonInfo(String name, String sex, String idcard, String nation,
			Date birthday, String placeofbirth, String politicalstatus,
			Integer majorid, String grade, String tel, String email,
			String password, String college, Integer status, Integer build,
			Integer hostel, Integer dormId) {
		this.name = name;
		this.sex = sex;
		this.idcard = idcard;
		this.nation = nation;
		this.birthday = birthday;
		this.placeofbirth = placeofbirth;
		this.politicalstatus = politicalstatus;
		this.majorid = majorid;
		this.grade = grade;
		this.tel = tel;
		this.email = email;
		this.password = password;
		this.college = college;
		this.status = status;
		this.build = build;
		this.hostel = hostel;
		this.dormId = dormId;
	}

	/** full constructor */
	public PersonInfo(String name, String sex, String idcard, String nation,
			Date birthday, String placeofbirth, String politicalstatus,
			Integer majorid, String grade, String tel, String email,
			String password, String college, Integer status, Integer build,
			Integer hostel, Integer dormId, Set classPositions,
			Set workLateInfos, Set workLatePersons, Set classLeaves,
			Set workSocialPratices, Set classActivities,
			Set workComprehensiveRecords, Set classHomeworkAbsences) {
		this.name = name;
		this.sex = sex;
		this.idcard = idcard;
		this.nation = nation;
		this.birthday = birthday;
		this.placeofbirth = placeofbirth;
		this.politicalstatus = politicalstatus;
		this.majorid = majorid;
		this.grade = grade;
		this.tel = tel;
		this.email = email;
		this.password = password;
		this.college = college;
		this.status = status;
		this.build = build;
		this.hostel = hostel;
		this.dormId = dormId;
		this.late_infos=workLateInfos;
		this.comprehensive_records=workComprehensiveRecords;
		this.late_persons=workLatePersons;
		this.social_pratices=workSocialPratices;

		

	}

	// Property accessors

	public String getStudentid() {
		return this.studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPlaceofbirth() {
		return this.placeofbirth;
	}

	public void setPlaceofbirth(String placeofbirth) {
		this.placeofbirth = placeofbirth;
	}

	public String getPoliticalstatus() {
		return this.politicalstatus;
	}

	public void setPoliticalstatus(String politicalstatus) {
		this.politicalstatus = politicalstatus;
	}

	public Integer getMajorid() {
		return this.majorid;
	}

	public void setMajorid(Integer majorid) {
		this.majorid = majorid;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getBuild() {
		return this.build;
	}

	public void setBuild(Integer build) {
		this.build = build;
	}

	public Integer getHostel() {
		return this.hostel;
	}

	public void setHostel(Integer hostel) {
		this.hostel = hostel;
	}

	public Integer getDormId() {
		return this.dormId;
	}

	public void setDormId(Integer dormId) {
		this.dormId = dormId;
	}

	public Set getLate_infos() {
		return late_infos;
	}

	public void setLate_infos(Set late_infos) {
		this.late_infos = late_infos;
	}

	public Set getLate_persons() {
		return late_persons;
	}

	public void setLate_persons(Set late_persons) {
		this.late_persons = late_persons;
	}

	public Set getSocial_pratices() {
		return social_pratices;
	}

	public void setSocial_pratices(Set social_pratices) {
		this.social_pratices = social_pratices;
	}

	public Set getComprehensive_records() {
		return comprehensive_records;
	}

	public void setComprehensive_records(Set comprehensive_records) {
		this.comprehensive_records = comprehensive_records;
	}




}