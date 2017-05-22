package unp.student.work.manager.dao;

import java.util.List;
import unp.student.work.manager.domain.GroupSupport;

public interface GroupSupportDao {
	List findByGid(Integer id);
	void insert(GroupSupport groupSupport);
	void update(GroupSupport groupSupport);
	GroupSupport findById(Integer id);
	void delete(Integer id);
}
