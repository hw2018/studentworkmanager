package unp.student.work.manager.domain;
// default package

import java.util.Date;


/**
 * social_pratice entity. @author MyEclipse Persistence Tools
 */

public class social_pratice  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private PersonInfo personInfo;
     private String pratice;
     private Integer isVolunteer;
     private Date time;
     private String place;


    // Constructors

    /** default constructor */
    public social_pratice() {
    }

    
    /** full constructor */
    public social_pratice(PersonInfo personInfo, String pratice, Integer isVolunteer, Date time, String place) {
        this.personInfo = personInfo;
        this.pratice = pratice;
        this.isVolunteer = isVolunteer;
        this.time = time;
        this.place = place;
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

    public String getPratice() {
        return this.pratice;
    }
    
    public void setPratice(String pratice) {
        this.pratice = pratice;
    }

    public Integer getIsVolunteer() {
        return this.isVolunteer;
    }
    
    public void setIsVolunteer(Integer isVolunteer) {
        this.isVolunteer = isVolunteer;
    }

    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return this.place;
    }
    
    public void setPlace(String place) {
        this.place = place;
    }
   








}