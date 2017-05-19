package unp.student.work.manager.domain;
// default package



/**
 * comprehensive_record entity. @author MyEclipse Persistence Tools
 */

public class comprehensive_record  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private PersonInfo personInfo;
     private Float score;


    // Constructors

    /** default constructor */
    public comprehensive_record() {
    }

	/** minimal constructor */
    public comprehensive_record(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
    
    /** full constructor */
    public comprehensive_record(PersonInfo personInfo, Float score) {
        this.personInfo = personInfo;
        this.score = score;
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

    public Float getScore() {
        return this.score;
    }
    
    public void setScore(Float score) {
        this.score = score;
    }
   








}