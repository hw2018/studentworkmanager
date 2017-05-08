package unp.student.work.manager.model;
// default package



/**
 * late_person entity. @author MyEclipse Persistence Tools
 */

public class late_person  implements java.io.Serializable,Comparable<late_person> {


    // Fields    

     private Integer id;
     private late_info late_info;
     private PersonInfo personInfo;
     private String reason;
     private Integer status;


    // Constructors

    /** default constructor */
    public late_person() {
    }

    
    /** full constructor */
    public late_person(late_info late_info, PersonInfo personInfo, String reason, Integer status) {
        this.late_info = late_info;
        this.personInfo = personInfo;
        this.reason = reason;
        this.status = status;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public late_info getLate_info() {
        return this.late_info;
    }
    
    public void setLate_info(late_info late_info) {
        this.late_info = late_info;
    }

    public PersonInfo getPersonInfo() {
        return this.personInfo;
    }
    
    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }


	public int compareTo(late_person o) {
		// TODO Auto-generated method stub
		return this.id-o.getId();
	}
   








}