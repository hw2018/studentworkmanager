package unp.student.work.manager.controller;

import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.dao.GroupWorkDao;
import unp.student.work.manager.dao.impl.GroupWorkDaoImpl;
import unp.student.work.manager.domain.GroupWork;

public class GroupWorkAction extends ActionSupport {
	private GroupWork groupWork;
	private GroupWorkDao groupWorkDao = new GroupWorkDaoImpl();
	
	public String update(){
		System.out.println(groupWork.getPlace());
		System.out.println(groupWork.getStuno());
		System.out.println(groupWork.getGroupId());
		System.out.println(groupWork.getTime());
		System.out.println(groupWork.getId());
		Integer gid = groupWork.getGroupId();
		Integer time = groupWork.getTime();
		if(groupWorkDao.findByGIdAndTime(gid, time)==null)
			groupWorkDao.insert(groupWork);
		else
			groupWorkDao.update(groupWork);
		return SUCCESS;
	}
	
	public GroupWork getGroupWork() {
		return groupWork;
	}
	public void setGroupWork(GroupWork groupWork) {
		this.groupWork = groupWork;
	}
}
