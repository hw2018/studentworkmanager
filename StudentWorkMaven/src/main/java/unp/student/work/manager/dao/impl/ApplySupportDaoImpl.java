package unp.student.work.manager.dao.impl;

import java.util.List;




import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.ApplySupportDao;
import unp.student.work.manager.domain.Support;



@Repository("supportDao")
public class ApplySupportDaoImpl extends BaseDaoImpl<Support> implements ApplySupportDao {
	
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from Support", pageNo, pageSize);
	}
}
