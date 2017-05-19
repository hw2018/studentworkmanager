package unp.student.work.manager.domain;
// default package



/**
 * student_counsellor entity. @author MyEclipse Persistence Tools
 */

public class student_counsellor  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private counsellor counsellor;
     private PersonInfo personInfo;
     private Float score;
     private String value;


    // Constructors

    /** default constructor */
    public student_counsellor() {
    }

    
    /** full constructor */
    public student_counsellor(counsellor counsellor, PersonInfo personInfo, Float score, String value) {
        this.counsellor = counsellor;
        this.personInfo = personInfo;
        this.score = score;
        this.value = value;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public counsellor getCounsellor() {
        return this.counsellor;
    }
    
    public void setCounsellor(counsellor counsellor) {
        this.counsellor = counsellor;
    }

    public PersonInfo getPersonInfo() {
        return this.personInfo;
    }
    
    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public Float getScore() {
        return this.score;
    }
    
    public void setScore(Float score) {
        this.score = score;
    }

    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
   








}