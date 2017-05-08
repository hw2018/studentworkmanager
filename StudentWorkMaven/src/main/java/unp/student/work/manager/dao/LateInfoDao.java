package unp.student.work.manager.dao;

import java.util.List;

import unp.student.work.manager.model.late_info;
import unp.student.work.manager.utils.PageBean;

public interface LateInfoDao extends BaseDao<late_info> {
	
	public List findByPage(int pageno);


}
