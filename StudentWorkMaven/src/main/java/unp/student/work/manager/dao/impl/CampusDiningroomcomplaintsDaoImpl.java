package unp.student.work.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.domain.Diningroomcomplaints;
import unp.student.work.manager.dao.*;

@Repository("diningroomcomplaintsDao")
public class CampusDiningroomcomplaintsDaoImpl extends BaseDaoImpl<Diningroomcomplaints> implements CampusDiningroomcomplaintsDao {
	@Override
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from Diningroomcomplaints", pageNo, pageSize);
	}

}