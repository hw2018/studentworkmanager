package unp.student.work.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.ClassActivityDao;
import unp.student.work.manager.domain.ClassActivity;

@Repository("classActivityDao")
public class ClassActivityDaoImpl extends BaseDaoImpl<ClassActivity> implements ClassActivityDao {

	
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from ClassActivity", pageNo, pageSize);
	}

	
	public List findById(int id, int pageSize){

		return findById( id, pageSize);
	}

}
