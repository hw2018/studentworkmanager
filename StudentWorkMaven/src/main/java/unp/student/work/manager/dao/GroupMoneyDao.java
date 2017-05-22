package unp.student.work.manager.dao;
import java.util.List;

import unp.student.work.manager.domain.GroupMoney;

public interface GroupMoneyDao {
	List findByGid(Integer id);
	void insert(GroupMoney groupMoney);
	GroupMoney findById(Integer id);
	void delete(Integer id);
	Integer totalOfGroup(Integer id);
}
