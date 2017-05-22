package unp.student.work.manager.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.DormRecordDao;
import unp.student.work.manager.domain.DormRecord;
@Repository("dormrecordDao")
public class DormRecordDaoImpl extends BaseDaoImpl<DormRecord> implements DormRecordDao {

	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from DormRecord", pageNo, pageSize);
	}
}
