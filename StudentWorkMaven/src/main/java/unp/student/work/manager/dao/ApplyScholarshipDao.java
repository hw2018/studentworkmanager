package unp.student.work.manager.dao;

import java.util.List;

import unp.student.work.manager.domain.Scholarship;


public interface ApplyScholarshipDao extends BaseDao<Scholarship> {
	List findByPage(int pageNo, int pageSize);
}
