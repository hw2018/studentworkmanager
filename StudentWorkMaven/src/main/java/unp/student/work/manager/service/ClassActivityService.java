package unp.student.work.manager.service;
import java.util.List;

import unp.student.work.manager.domain.ClassActivity;

import unp.student.work.manager.utils.PageBean;

public interface ClassActivityService extends BaseService<ClassActivity> {
	PageBean findByPage(int pageNo, int pageSize);
	public void update(ClassActivity classactivity);
	public PageBean findById(int pageNo, int pageSize);
}
