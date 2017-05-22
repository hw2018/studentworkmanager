package unp.student.work.manager.controller;

import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.dao.GroupMeetingDao;
import unp.student.work.manager.dao.impl.GroupMeetingDaoImpl;
import unp.student.work.manager.domain.GroupMeeting;

public class GroupMeetingAction extends ActionSupport {
	private GroupMeeting groupMeeting;
	public GroupMeeting getGroupMeeting() {
		return groupMeeting;
	}
	public void setGroupMeeting(GroupMeeting groupMeeting) {
		this.groupMeeting = groupMeeting;
	}
	private GroupMeetingDao groupMeetingDao=new GroupMeetingDaoImpl();
	
	public String add(){
		groupMeetingDao.insert(groupMeeting);
		return SUCCESS;
	}
	public String update(){
		groupMeetingDao.update(groupMeeting);
		return SUCCESS;
	}
}
