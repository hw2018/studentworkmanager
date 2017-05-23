package unp.student.work.manager.service.impl;

import unp.student.work.manager.dao.GroupDao;

import unp.student.work.manager.dao.impl.GroupDaoImpl;
import unp.student.work.manager.service.GroupService;
import unp.student.work.manager.utils.PageBean;

public class GroupServiceImpl implements GroupService {
	private GroupDao groupDao=new GroupDaoImpl();
	public PageBean getGroups(int pageNo) {
		/*PageBean pageBean=new PageBean();
		pageBean.data=groupDao.findByPage(pageNo, pageBean.rowsPerPage);
		pageBean.curPage=pageNo;
		pageBean.maxRowCount=groupDao.findRowCount();
		pageBean.countMaxPage();*/
		return null;
	}

}
