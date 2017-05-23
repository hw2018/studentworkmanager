package unp.student.work.manager.service.impl;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.ApplySupportDao;
import unp.student.work.manager.domain.Support;
import unp.student.work.manager.service.ApplySupportService;
import unp.student.work.manager.utils.PageBean;


@Service("supportService")
public class ApplySupportServiceImpl extends BaseServiceImpl<Support> implements ApplySupportService {

	@Autowired
	private ApplySupportDao supportDao;
	public ApplySupportServiceImpl() {
		super(Support.class);
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
	}
	
	
	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List supports=supportDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=supports;
		pageBean.maxRowCount=(int) supportDao.findCount(Support.class);
		pageBean.countMaxPage();
		return pageBean;		
	}
	
	public void update(Support support){
		Support f=supportDao.get(Support.class, support.getId());
		f.setTerm(support.getTerm());
		f.setStudentID(support.getStudentID());
		f.setLevel(support.getLevel());				
		f.setProfession(support.getProfession());
		f.setSupsort(support.getSupsort());
	}
}
