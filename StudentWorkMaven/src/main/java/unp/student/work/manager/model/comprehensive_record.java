package unp.student.work.manager.model;
// default package



/**
 * comprehensive_record entity. @author MyEclipse Persistence Tools
 */

public class comprehensive_record  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private PersonInfo personInfo;
     private Integer addorsub;
     private Float score;
     private String record;
     private Float totalscore;
     private String reason;
     private Integer status;


    // Constructors

    /** default constructor */
    public comprehensive_record() {
    }

    
    /** full constructor */
    public comprehensive_record(PersonInfo personInfo, Integer addorsub, Float score, String record, Float totalscore, String reason, Integer status) {
        this.personInfo = personInfo;
        this.addorsub = addorsub;
        this.score = score;
        this.record = record;
        this.totalscore = totalscore;
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

    public PersonInfo getPersonInfo() {
        return this.personInfo;
    }
    
    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public Integer getAddorsub() {
        return this.addorsub;
    }
    
    public void setAddorsub(Integer addorsub) {
        this.addorsub = addorsub;
    }

    public Float getScore() {
        return this.score;
    }
    
    public void setScore(Float score) {
        this.score = score;
    }

    public String getRecord() {
        return this.record;
    }
    
    public void setRecord(String record) {
        this.record = record;
    }

    public Float getTotalscore() {
        return this.totalscore;
    }
    
    public void setTotalscore(Float totalscore) {
        this.totalscore = totalscore;
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
   








}