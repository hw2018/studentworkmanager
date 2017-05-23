package unp.student.work.manager.dao;

import java.sql.SQLException;
import java.util.List;

import unp.student.work.manager.domain.Equityprotect;

public interface CampusEquityprotectDao extends BaseDao<Equityprotect>{
	List findByPage(int pageNo, int pageSize);
}
