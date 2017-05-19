package unp.student.work.manager.domain;
// default package



/**
 * counsellor entity. @author MyEclipse Persistence Tools
 */

public class counsellor  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Float score;
     private String college;
     private String term;
     private Integer major;
     private String grade;


    // Constructors

    /** default constructor */
    public counsellor() {
    }

	/** minimal constructor */
    public counsellor(String name, String college, String term, Integer major, String grade) {
        this.name = name;
        this.college = college;
        this.term = term;
        this.major = major;
        this.grade = grade;
    }
    
    /** full constructor */
    public counsellor(String name, Float score, String college, String term, Integer major, String grade) {
        this.name = name;
        this.score = score;
        this.college = college;
        this.term = term;
        this.major = major;
        this.grade = grade;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Float getScore() {
        return this.score;
    }
    
    public void setScore(Float score) {
        this.score = score;
    }

    public String getCollege() {
        return this.college;
    }
    
    public void setCollege(String college) {
        this.college = college;
    }

    public String getTerm() {
        return this.term;
    }
    
    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getMajor() {
        return this.major;
    }
    
    public void setMajor(Integer major) {
        this.major = major;
    }

    public String getGrade() {
        return this.grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
   








}