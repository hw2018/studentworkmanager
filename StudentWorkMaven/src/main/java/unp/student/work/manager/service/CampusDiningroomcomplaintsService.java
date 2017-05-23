package unp.student.work.manager.service;

import java.util.List;



import unp.student.work.manager.domain.Diningroomcomplaints;
import unp.student.work.manager.utils.PageBean;


public interface CampusDiningroomcomplaintsService extends BaseService<Diningroomcomplaints> {
	PageBean findByPage(int pageNo, int pageSize);
	public void update(Diningroomcomplaints diningroomcomplaints);
}
