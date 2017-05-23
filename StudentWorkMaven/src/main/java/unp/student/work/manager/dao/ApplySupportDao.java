package unp.student.work.manager.dao;

import java.util.List;

import unp.student.work.manager.domain.Support;



public interface ApplySupportDao extends BaseDao<Support> {
	List findByPage(int pageNo, int pageSize);

}
