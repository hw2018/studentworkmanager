package unp.student.work.manager.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.DormInfoDao;
import unp.student.work.manager.domain.DormInfo;
import unp.student.work.manager.service.DormInfoService;
import unp.student.work.manager.utils.PageBean;

@Service("dorminfoService")
public class DormInfoServiceImpl extends BaseServiceImpl<DormInfo> implements DormInfoService {

	@Autowired
	private DormInfoDao dorminfoDao;
	
	public DormInfoServiceImpl() {
		super(DormInfo.class);
		// TODO Auto-generated constructor stub
	}
	
	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List dorminfos=dorminfoDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=dorminfos;
		pageBean.maxRowCount=(int) dorminfoDao.findCount(DormInfo.class);
		pageBean.countMaxPage();
		return pageBean;
				
	}
	
	public void update(DormInfo dorminfo){
		DormInfo d=dorminfoDao.get(DormInfo.class, dorminfo.getId());
		d.setDormId(dorminfo.getDormId());
		d.setLocationId(dorminfo.getLocationId());
		d.setStuNumber(dorminfo.getStuNumber());
		
	}
	
	
	
	

}
