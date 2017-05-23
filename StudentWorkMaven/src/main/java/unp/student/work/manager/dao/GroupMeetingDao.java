package unp.student.work.manager.dao;
import java.util.List;

import unp.student.work.manager.domain.GroupMeeting;

public interface GroupMeetingDao {
	List findByGid(Integer id);
	void insert(GroupMeeting groupMeeting);
	void update(GroupMeeting groupMeeting);
	GroupMeeting findById(Integer id);
	void delete(Integer id);
}
