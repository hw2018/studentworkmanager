package unp.student.work.manager.dao;

import java.sql.SQLException;
import java.util.List;

import unp.student.work.manager.domain.Lostandfound;

public interface CampusLostandfoundDao extends BaseDao<Lostandfound>{
	List findByPage(int pageNo, int pageSize);
}
