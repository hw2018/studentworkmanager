package unp.student.work.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.ClassPositionDao;
import unp.student.work.manager.domain.ClassPosition;

@Repository("classPositionDao")
public class ClassPositionDaoImpl extends BaseDaoImpl<ClassPosition> implements ClassPositionDao {
	
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from ClassPosition", pageNo, pageSize);
	}
	
	public List findById(int id, int pageSize){

		return findById( id, pageSize);
	}

}
