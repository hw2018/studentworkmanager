package unp.student.work.manager.service;


import unp.student.work.manager.domain.DormRecord;
import unp.student.work.manager.utils.PageBean;

public interface DormRecordService extends BaseService<DormRecord> {
	PageBean findByPage(int pageNo, int pageSize);
	public void update(DormRecord dormrecord);

}
