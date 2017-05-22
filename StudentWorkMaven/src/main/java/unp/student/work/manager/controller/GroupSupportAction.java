package unp.student.work.manager.controller;

import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.dao.GroupMoneyDao;
import unp.student.work.manager.dao.GroupSupportDao;
import unp.student.work.manager.dao.impl.GroupMoneyDaoImpl;
import unp.student.work.manager.dao.impl.GroupSupportDaoImpl;
import unp.student.work.manager.domain.GroupMoney;
import unp.student.work.manager.domain.GroupSupport;

public class GroupSupportAction extends ActionSupport {
	private GroupSupport groupSupport;
	private GroupSupportDao groupSupportDao = new GroupSupportDaoImpl();
	private GroupMoney groupMoney =new GroupMoney();
	private GroupMoneyDao groupMoneyDao = new GroupMoneyDaoImpl();
	
	public GroupSupport getGroupSupport() {
		return groupSupport;
	}
	public void setGroupSupport(GroupSupport groupSupport) {
		this.groupSupport = groupSupport;
	}
	
	public String add(){
		groupSupportDao.insert(groupSupport);
		groupMoney.setGroupId(groupSupport.getGroupId());
		groupMoney.setMoney(groupSupport.getMoney());
		groupMoney.setMoneyIn(true);
		groupMoney.setMoneyOut(false);
		groupMoney.setText(groupSupport.getName());
		groupMoneyDao.insert(groupMoney);
		groupSupportDao.insert(groupSupport);
		return SUCCESS;
	}
	
	public String update(){
		groupSupportDao.update(groupSupport);
		return SUCCESS;
	}
}
