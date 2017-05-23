package unp.student.work.manager.dao;

import java.sql.SQLException;
import java.util.List;

import unp.student.work.manager.domain.Diningroomcomplaints;

public interface CampusDiningroomcomplaintsDao extends BaseDao<Diningroomcomplaints>{
	List findByPage(int pageNo, int pageSize);
}
