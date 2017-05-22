package unp.student.work.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.DormInfoDao;
import unp.student.work.manager.domain.DormInfo;

@Repository("dorminfoDao")
public class DormInfoDaoImpl extends BaseDaoImpl<DormInfo> implements DormInfoDao {
	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return findByPage("from DormInfo", pageNo, pageSize);
	}

}
