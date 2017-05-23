package unp.student.work.manager.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.CampusDiningroomcomplaintsDao;
import unp.student.work.manager.domain.Diningroomcomplaints;
import unp.student.work.manager.service.*;
import unp.student.work.manager.utils.PageBean;

@Service("diningroomcomplaintsService")
public class CampusDiningroomcomplaintsServiceImpl extends BaseServiceImpl<Diningroomcomplaints> implements CampusDiningroomcomplaintsService {	
	@Autowired
	private CampusDiningroomcomplaintsDao diningroomcomplaintsDao;
	
	public CampusDiningroomcomplaintsServiceImpl() {
		super(Diningroomcomplaints.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List diningroomcomplaintss=diningroomcomplaintsDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=diningroomcomplaintss;
		pageBean.maxRowCount=(int) diningroomcomplaintsDao.findCount(Diningroomcomplaints.class);
		pageBean.countMaxPage();
		return pageBean;
				
	}
	
	@Override
	public void update(Diningroomcomplaints diningroomcomplaints){
		Diningroomcomplaints h=diningroomcomplaintsDao.get(Diningroomcomplaints.class, diningroomcomplaints.getId());
		h.setName(diningroomcomplaints.getName());
		h.setDiningroom(diningroomcomplaints.getDiningroom());
		h.setType(diningroomcomplaints.getType());
		h.setReason(diningroomcomplaints.getReason());
	}
	
}
