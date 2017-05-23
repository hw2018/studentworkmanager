package unp.student.work.manager.dao;

import java.util.List;
import unp.student.work.manager.domain.GroupWork;

public interface GroupWorkDao {
	List findByGid(Integer id);
	void insert(GroupWork groupWork);
	void update(GroupWork groupWork);
	GroupWork findById(Integer id);
	void delete(Integer id);
	GroupWork findByGIdAndTime(Integer id,Integer time);
}
