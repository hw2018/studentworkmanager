package unp.student.work.manager.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.CampusLostandfoundDao;
import unp.student.work.manager.domain.Lostandfound;
import unp.student.work.manager.service.*;
import unp.student.work.manager.utils.PageBean;

@Service("LostandfoundService")
public class CampusLostandfoundServiceImpl extends BaseServiceImpl<Lostandfound> implements CampusLostandfoundService {	
	@Autowired
	private CampusLostandfoundDao lostandfoundDao;
	
	public CampusLostandfoundServiceImpl() {
		super(Lostandfound.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List lostandfounds=lostandfoundDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=lostandfounds;
		pageBean.maxRowCount=(int) lostandfoundDao.findCount(Lostandfound.class);
		pageBean.countMaxPage();
		return pageBean;
				
	}
	
	@Override
	public void update(Lostandfound lostandfound){
		Lostandfound g=lostandfoundDao.get(Lostandfound.class, lostandfound.getId());
		g.setName(lostandfound.getName());
		g.setType(lostandfound.getType());
		g.setTradeplace(lostandfound.getTradeplace());
		g.setDescription(lostandfound.getDescription());
	}
	
}
