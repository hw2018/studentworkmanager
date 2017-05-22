package unp.student.work.manager.service;
import java.util.List;

import unp.student.work.manager.domain.ClassHomework;
import unp.student.work.manager.utils.PageBean;

public interface ClassHomeworkService extends BaseService<ClassHomework> {
	PageBean findByPage(int pageNo, int pageSize);
	public void update(ClassHomework classhomework);
	public PageBean findById(int pageNo, int pageSize);
}
