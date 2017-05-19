package unp.student.work.manager.dao;

import java.util.List;

import unp.student.work.manager.domain.comprehensive;
import unp.student.work.manager.domain.comprehensive_record;

public interface ComprehensiveRecordDao extends BaseDao<comprehensive_record> {
	
	public List findByPage(int pageno);

	public comprehensive_record findByStudent(String studentid); 
}
