package unp.student.work.manager.dao.impl;

import java.util.List;




import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.ApplyScholarshipDao;
import unp.student.work.manager.domain.Scholarship;


@Repository("scholarshipDao")
public class ApplyScholarshipDaoImpl extends BaseDaoImpl<Scholarship> implements ApplyScholarshipDao {
	@Override
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from Scholarship", pageNo, pageSize);
	}
}
