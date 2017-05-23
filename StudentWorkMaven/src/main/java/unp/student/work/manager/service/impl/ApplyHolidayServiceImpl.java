package unp.student.work.manager.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.ApplyHolidayDao;
import unp.student.work.manager.domain.Holiday;
import unp.student.work.manager.service.ApplyHolidayService;
import unp.student.work.manager.utils.PageBean;


@Service("holidayService")
public class ApplyHolidayServiceImpl extends BaseServiceImpl<Holiday> implements ApplyHolidayService {

	@Autowired
	private ApplyHolidayDao holidayDao;
	public ApplyHolidayServiceImpl() {
		super(Holiday.class);
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
	}
	
	
	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List activities=holidayDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=activities;
		pageBean.maxRowCount=(int) holidayDao.findCount(Holiday.class);
		pageBean.countMaxPage();
		return pageBean;		
	}
	
	public void update(Holiday holiday){
		Holiday f=holidayDao.get(Holiday.class, holiday.getId());
		/*
		f.setPeoplenumber(holiday.getPeoplenumber());
		f.setCarnumber(holiday.getCarnumber());
		f.setLeadteacher(holiday.getLeadteacher());
		f.setLeadteacherphone(holiday.getLeadteacherphone());
		f.setPrincipal(holiday.getPrincipal());
		*/
	}
}
