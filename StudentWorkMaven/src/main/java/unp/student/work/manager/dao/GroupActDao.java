package unp.student.work.manager.dao;
import java.util.List;

import unp.student.work.manager.domain.GroupAct;

public interface GroupActDao {
	List findByGid(Integer id);
	void insert(GroupAct groupAct);
	void update(GroupAct groupAct);
	void delete(Integer id);
	GroupAct findById(Integer id);
}
