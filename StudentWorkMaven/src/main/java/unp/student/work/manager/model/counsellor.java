package unp.student.work.manager.model;
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


    // Constructors

    /** default constructor */
    public counsellor() {
    }

    
    /** full constructor */
    public counsellor(String name, Float score, String college, String term) {
        this.name = name;
        this.score = score;
        this.college = college;
        this.term = term;
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
   








}