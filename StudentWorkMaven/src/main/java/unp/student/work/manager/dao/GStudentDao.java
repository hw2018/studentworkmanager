package unp.student.work.manager.dao;
//社团成员Dao

import java.util.List;

import unp.student.work.manager.domain.GStudent;

public interface GStudentDao {
	List findByGid(Integer id);
	void insert(GStudent gStudent);
	void delete(Integer id);
	void update(GStudent gStudent);
	GStudent findById(Integer id);
	List findByStuno(String id);
}
