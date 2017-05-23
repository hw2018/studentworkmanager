package unp.student.work.manager.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.WorkComprehensiveDao;
import unp.student.work.manager.dao.WorkComprehensiveRecordDao;
import unp.student.work.manager.domain.comprehensive;
import unp.student.work.manager.domain.comprehensive_record;


@Repository("comprehensiveRecordDao")
public class WorkComprehensiveRecordDaoImpl extends BaseDaoImpl<comprehensive_record> implements
		WorkComprehensiveRecordDao{

	public List findByPage(int pageno) {
		String hql="from comprehensive_record li";
		return getSession().createQuery(hql).setFirstResult((pageno-1)*10)
				.setMaxResults(10).list();
	}

	public comprehensive_record findByStudent(String studentid) {
		// TODO Auto-generated method stub
		String hql="from comprehensive_record cr where cr.personInfo.studentid=:studentid";
		return (comprehensive_record)getSession().createQuery(hql).setString("studentid", studentid).uniqueResult();
	}

	

}
