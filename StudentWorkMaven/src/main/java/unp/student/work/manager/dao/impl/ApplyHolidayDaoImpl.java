package unp.student.work.manager.dao.impl;
import java.util.List;




import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.ApplyHolidayDao;
import unp.student.work.manager.domain.Holiday;

@Repository("holidayDao")
public class ApplyHolidayDaoImpl extends BaseDaoImpl<Holiday> implements ApplyHolidayDao {
	
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from Holiday", pageNo, pageSize);
	}
}
