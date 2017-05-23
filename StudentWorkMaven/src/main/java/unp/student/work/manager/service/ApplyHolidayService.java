package unp.student.work.manager.service;

import unp.student.work.manager.domain.*;

import unp.student.work.manager.utils.PageBean;



public interface ApplyHolidayService extends BaseService<Holiday> {
	PageBean findByPage(int pageNo, int pageSize);
	public void update(Holiday holiday);

}
