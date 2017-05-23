package unp.student.work.manager.dao;

import java.util.List;

import unp.student.work.manager.domain.Holiday;




public interface ApplyHolidayDao extends BaseDao<Holiday> {
	List findByPage(int pageNo, int pageSize);

}
