package unp.student.work.manager.domain;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="group_money")
public class GroupMoney {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer groupId;
	private Integer money;
	private boolean moneyIn;
	private boolean moneyOut;
	private String text;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public boolean isMoneyIn() {
		return moneyIn;
	}
	public void setMoneyIn(boolean moneyIn) {
		this.moneyIn = moneyIn;
	}
	public boolean isMoneyOut() {
		return moneyOut;
	}
	public void setMoneyOut(boolean moneyOut) {
		this.moneyOut = moneyOut;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public GroupMoney(Integer id, Integer groupId, Integer money, boolean moneyIn, boolean moneyOut, String text) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.money = money;
		this.moneyIn = moneyIn;
		this.moneyOut = moneyOut;
		this.text = text;
	}
	public GroupMoney(){
		super();
	}
	
}
