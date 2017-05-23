package unp.student.work.manager.service;

import java.util.List;



import unp.student.work.manager.domain.Equityprotect;
import unp.student.work.manager.utils.PageBean;

public interface CampusEquityprotectService extends BaseService<Equityprotect> {
	PageBean findByPage(int pageNo, int pageSize);
	public void update(Equityprotect equityprotect);
}
