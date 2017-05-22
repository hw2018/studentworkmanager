package unp.student.work.manager.service;
import java.util.List;

import unp.student.work.manager.domain.ClassChuqin;
import unp.student.work.manager.utils.PageBean;

public interface ClassChuqinService extends BaseService<ClassChuqin> {
	PageBean findByPage(int pageNo, int pageSize);
	public void update(ClassChuqin classchuqin);
	public PageBean findById(int pageNo, int pageSize);
}
