package unp.student.work.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.domain.Equityprotect;
import unp.student.work.manager.dao.*;

@Repository("equityprotectDao")
public class CampusEquityprotectDaoImpl extends BaseDaoImpl<Equityprotect> implements CampusEquityprotectDao {
	@Override
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from Equityprotect", pageNo, pageSize);
	}

}