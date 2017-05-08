package unp.student.work.manager.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.LateInfoDao;
import unp.student.work.manager.model.late_info;

@Repository("lateInfoDao")
public class LateInfoDaoImpl  extends BaseDaoImpl<late_info> implements LateInfoDao{


	public List findByPage(int pageno) {
		// TODO Auto-generated method stub
		String hql="from late_info li";
		return getSession().createQuery(hql).setFirstResult((pageno-1)*10)
				.setMaxResults(10).list();
	}
	
}
