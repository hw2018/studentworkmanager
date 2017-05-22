package unp.student.work.manager.dao;

import java.util.List;

import unp.student.work.manager.domain.DormRecord;

public interface DormRecordDao extends BaseDao<DormRecord> {
	List findByPage(int pageNo, int pageSize);
}
