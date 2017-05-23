package unp.student.work.manager.dao.impl;

import java.util.List;




import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.ApplyActivityDao;
import unp.student.work.manager.domain.Activity;


@Repository("activityDao")
public class ApplyActivityDaoImpl extends BaseDaoImpl<Activity> implements ApplyActivityDao {
	
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from Activity", pageNo, pageSize);
	}

}
