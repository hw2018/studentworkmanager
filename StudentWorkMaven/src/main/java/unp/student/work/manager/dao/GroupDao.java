package unp.student.work.manager.dao;
import java.util.List;

import unp.student.work.manager.domain.Group;

public interface GroupDao{
	List findAll();
	void insert(Group group);
	void delete(Integer id);
	void update(Group group);
	Group findById(Integer id);
	List findByStuno(String id);
}
