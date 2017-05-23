package unp.student.work.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.domain.Lostandfound;
import unp.student.work.manager.dao.*;

@Repository("lostandfoundDao")
public class CampusLostandfoundDaoImpl extends BaseDaoImpl<Lostandfound> implements CampusLostandfoundDao {
	@Override
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from Lostandfound", pageNo, pageSize);
	}

}