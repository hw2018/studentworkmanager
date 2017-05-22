package unp.student.work.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.ClassChuqinDao;
import unp.student.work.manager.domain.ClassChuqin;

@Repository("classChuqinDao")
public class ClassChuqinDaoImpl extends BaseDaoImpl<ClassChuqin> implements ClassChuqinDao {

	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from ClassChuqin", pageNo, pageSize);
	}

	public List findById(int id, int pageSize){

		return findById( id, pageSize);
	}

}
