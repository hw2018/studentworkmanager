package unp.student.work.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.ApplyScholarshipDao;
import unp.student.work.manager.domain.Scholarship;
import unp.student.work.manager.service.ApplyScholarshipService;
import unp.student.work.manager.utils.PageBean;

@Service("scholarshipService")
public class ApplyScholarshipServiceImpl extends BaseServiceImpl<Scholarship> implements ApplyScholarshipService {

	@Autowired
	private ApplyScholarshipDao scholarshipDao;
	public ApplyScholarshipServiceImpl() {
		super(Scholarship.class);
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
	}
	
	
	public PageBean findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		List scholarships=scholarshipDao.findByPage(pageNo, pageSize);
		PageBean pageBean=new PageBean();
		pageBean.curPage=pageNo;
		pageBean.data=scholarships;
		pageBean.maxRowCount=(int) scholarshipDao.findCount(Scholarship.class);
		pageBean.countMaxPage();
		return pageBean;		
	}
	
	public void update(Scholarship scholarship){
		Scholarship f=scholarshipDao.get(Scholarship.class, scholarship.getId());
		f.setTerm(scholarship.getTerm());
		f.setStudentID(scholarship.getStudentID());
		f.setProfession(scholarship.getProfession());
		f.setSchsort(scholarship.getSchsort());
	}
}
