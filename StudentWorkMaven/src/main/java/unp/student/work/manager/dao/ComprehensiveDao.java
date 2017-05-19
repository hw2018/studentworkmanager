package unp.student.work.manager.dao;

import java.util.List;

import unp.student.work.manager.domain.comprehensive;
import unp.student.work.manager.domain.comprehensive_record;

public interface ComprehensiveDao extends BaseDao<comprehensive> {
	
	public List findPageByStudent(String studentid,int pageno);
	public List findPageByManager(int pageno);
	
	
	public long findCountByStudent(String studentid);
	public long findCountByManager();
}
