package unp.student.work.manager.service;
import java.util.List;

import unp.student.work.manager.domain.ClassLeave;
import unp.student.work.manager.utils.PageBean;

public interface ClassLeaveService extends BaseService<ClassLeave> {
	PageBean findByPage(int pageNo, int pageSize);
	public void update(ClassLeave classleave);
	public PageBean findById(int pageNo, int pageSize);
}
