package unp.student.work.manager.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.CampusEquityprotectDao;
import unp.student.work.manager.domain.Equityprotect;
import unp.student.work.manager.service.*;
import unp.student.work.manager.utils.PageBean;

@Service("equityprotectService")
public class CampusEquityprotectServiceImpl extends BaseServiceImpl<Equityprotect> implements CampusEquityprotectService {	
	@Autowired
	private CampusEquityprotectDao equityprotectDao;
	
	public CampusEquityprotectServiceImpl() {
		super(Equityprotect.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List equityprotects=equityprotectDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=equityprotects;
		pageBean.maxRowCount=(int) equityprotectDao.findCount(Equityprotect.class);
		pageBean.countMaxPage();
		return pageBean;
				
	}
	
	@Override
	public void update(Equityprotect equityprotect){
		Equityprotect f=equityprotectDao.get(Equityprotect.class, equityprotect.getId());
		f.setName(equityprotect.getName());
		f.setSex(equityprotect.getSex());
		f.setType(equityprotect.getType());
		f.setDescription(equityprotect.getDescription());
	}
	
}
