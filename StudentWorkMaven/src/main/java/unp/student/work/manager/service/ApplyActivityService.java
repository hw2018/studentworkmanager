package unp.student.work.manager.service;

import unp.student.work.manager.domain.*;

import unp.student.work.manager.utils.PageBean;



public interface ApplyActivityService extends BaseService<Activity>{
	PageBean findByPage(int pageNo, int pageSize);
	public void update(Activity activity);
}
