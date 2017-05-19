package unp.student.work.manager.domain;
// default package



/**
 * comprehensive entity. @author MyEclipse Persistence Tools
 */

public class comprehensive  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private PersonInfo personInfo;
     private String record;
     private String reason;
     private Integer status;
     private Float last;
     private Float final_;


    // Constructors

    /** default constructor */
    public comprehensive() {
    }

	/** minimal constructor */
    public comprehensive(PersonInfo personInfo, String record, Float last, Float final_) {
        this.personInfo = personInfo;
        this.record = record;
        this.last = last;
        this.final_ = final_;
    }
    
    /** full constructor */
    public comprehensive(PersonInfo personInfo, String record, String reason, Integer status, Float last, Float final_) {
        this.personInfo = personInfo;
        this.record = record;
        this.reason = reason;
        this.status = status;
        this.last = last;
        this.final_ = final_;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public PersonInfo getPersonInfo() {
        return this.personInfo;
    }
    
    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public String getRecord() {
        return this.record;
    }
    
    public void setRecord(String record) {
        this.record = record;
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

    public Float getLast() {
        return this.last;
    }
    
    public void setLast(Float last) {
        this.last = last;
    }

    public Float getFinal_() {
        return this.final_;
    }
    
    public void setFinal_(Float final_) {
        this.final_ = final_;
    }
   








}