package unp.student.work.manager.dao;

import java.util.List;

import unp.student.work.manager.domain.counsellor;

public interface CounsellorDao extends BaseDao<counsellor> {

	
	public List findByInfomation(String college,String term,int major,String grade);
	
	
}
