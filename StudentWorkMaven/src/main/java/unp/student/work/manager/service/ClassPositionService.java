package unp.student.work.manager.service;
import java.util.List;

import unp.student.work.manager.domain.ClassPosition;
import unp.student.work.manager.utils.PageBean;

public interface ClassPositionService extends BaseService<ClassPosition> {
	PageBean findByPage(int pageNo, int pageSize);
	public void update(ClassPosition classposition);
	public PageBean findById(int pageNo, int pageSize);
}
