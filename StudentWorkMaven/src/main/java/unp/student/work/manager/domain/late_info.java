package unp.student.work.manager.domain;
// default package

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * late_info entity. @author MyEclipse Persistence Tools
 */

public class late_info  implements java.io.Serializable,Comparable<late_info> {


    // Fields    

     private Integer id;
     private PersonInfo personInfo;
     private Integer num;
     private Date time;
     private Set late_persons = new HashSet(0);


    // Constructors

    /** default constructor */
    public late_info() {
    }

	/** minimal constructor */
    public late_info(PersonInfo personInfo, Integer num, Date time) {
        this.personInfo = personInfo;
        this.num = num;
        this.time = time;
    }
    
    /** full constructor */
    public late_info(PersonInfo personInfo, Integer num, Date time, Set late_persons) {
        this.personInfo = personInfo;
        this.num = num;
        this.time = time;
        this.late_persons = late_persons;
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

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getTime() {
    
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }

    public Set getLate_persons() {
    	TreeSet<late_person> late_persons=new TreeSet<late_person>(this.late_persons);
        return late_persons;
    }
    
    public void setLate_persons(Set late_persons) {
        this.late_persons = late_persons;
    }

	public int compareTo(late_info o) {
		// TODO Auto-generated method stub
		return this.id-o.getId();
	}
   








}