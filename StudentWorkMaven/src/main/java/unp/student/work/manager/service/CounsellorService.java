package unp.student.work.manager.service;

import java.util.List;

import unp.student.work.manager.domain.student_counsellor;

public interface CounsellorService {
	
	public List findCounsellorByStudent(String studentid);
	
	
	public List findProblem();
	
	public List findResult(String studentid,int select);
	
	
	public void addRecord(String studentid,float[] score,int select);
	
	

}
