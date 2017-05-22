package unp.student.work.manager.controller;

import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.dao.GroupMoneyDao;
import unp.student.work.manager.dao.impl.GroupMoneyDaoImpl;
import unp.student.work.manager.domain.GroupMoney;

public class GroupMoneyAction extends ActionSupport {
	private GroupMoney groupMoney;
	private GroupMoneyDao groupMoneyDao = new GroupMoneyDaoImpl();
	public GroupMoney getGroupMoney() {
		return groupMoney;
	}

	public void setGroupMoney(GroupMoney groupMoney) {
		this.groupMoney = groupMoney;
	}
	public String add(){
		System.out.println(groupMoney.getGroupId());
		System.out.println(groupMoney.getMoney());
		System.out.println(groupMoney.getText());
		System.out.println(groupMoney.isMoneyIn());
		System.out.println(groupMoney.isMoneyOut());
		groupMoneyDao.insert(groupMoney);
		return SUCCESS;
	}
}
