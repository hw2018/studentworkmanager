package unp.student.work.manager.dao;

import java.util.List;

import unp.student.work.manager.domain.GroupThing;

public interface GroupThingDao {
	List findByGid(Integer id);
	GroupThing findBy(Integer id);
	void insert(GroupThing groupThing);
	void upadate(GroupThing groupThing);
	void delete(GroupThing groupThing);

}
