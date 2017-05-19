package unp.student.work.manager.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.ComprehensiveDao;
import unp.student.work.manager.domain.comprehensive;
import unp.student.work.manager.domain.comprehensive_record;

@Repository("comorehensiveDao")
public class ComprehensiveDaoImpl extends BaseDaoImpl<comprehensive> implements
		ComprehensiveDao {

	public List findPageByStudent(String studentid, int pageno) {
		// TODO Auto-generated method stub
		String hql="from comprehensive c where c.personInfo.studentid=:studentid";
		return getSession().createQuery(hql).setString("studentid", studentid)
				.setFirstResult((pageno-1)*10).setMaxResults(10).list();
	}

	public List findPageByManager(int pageno) {
		// TODO Auto-generated method stub
		String hql="from comprehensive c where c.status=0";
		return getSession().createQuery(hql)
				.setFirstResult((pageno-1)*10).setMaxResults(10).list();
	}

	public long findCountByStudent(String studentid) {
		// TODO Auto-generated method stub
		String hql="select count(*) from comprehensive c where c.personInfo.studentid=:studentid";
		return (Long)getSession().createQuery(hql).setString("studentid", studentid)
				.uniqueResult();
	}

	public long findCountByManager() {
		// TODO Auto-generated method stub
		String hql="select count(*) from comprehensive c where c.status!=0";
		return (Long)getSession().createQuery(hql)
				.uniqueResult();
	}

	
}
