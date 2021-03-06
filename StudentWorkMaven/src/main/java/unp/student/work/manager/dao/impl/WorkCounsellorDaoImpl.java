package unp.student.work.manager.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.WorkCounsellorDao;
import unp.student.work.manager.domain.counsellor;


@Repository("counsellorDao")
public class WorkCounsellorDaoImpl extends BaseDaoImpl<counsellor> implements WorkCounsellorDao {

	
	public List findByInfomation(String college, String term, int major,
			String grade) {
		// TODO Auto-generated method stub
		String hql="from counsellor c where c.college=:college and c.term=:term and c.major=:major and c.grade=:grade";
		return getSession().createQuery(hql).setString("college", college)
				.setString("term", term).setString("grade", grade)
				.setInteger("major", major).list();
	}

	

}
