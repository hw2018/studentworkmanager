package unp.student.work.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.ClassLeaveDao;

import unp.student.work.manager.domain.ClassLeave;

@Repository("classLeaveDao")
public class ClassLeaveDaoImpl extends BaseDaoImpl<ClassLeave> implements ClassLeaveDao {

	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from ClassLeave", pageNo, pageSize);
	}

	public List findById(int id, int pageSize){

		return findById( id, pageSize);
	}

}
