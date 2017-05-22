package unp.student.work.manager.service;

import java.util.List;

import unp.student.work.manager.domain.DormInfo;
import unp.student.work.manager.utils.PageBean;

public interface DormInfoService extends BaseService<DormInfo> {
	PageBean findByPage(int pageNo, int pageSize);
	public void update(DormInfo dorminfo);

}
