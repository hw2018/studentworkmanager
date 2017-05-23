package unp.student.work.manager.service;

import java.util.List;



import unp.student.work.manager.domain.Lostandfound;
import unp.student.work.manager.utils.PageBean;


public interface CampusLostandfoundService extends BaseService<Lostandfound> {
	PageBean findByPage(int pageNo, int pageSize);
	public void update(Lostandfound lostandfound);
}
