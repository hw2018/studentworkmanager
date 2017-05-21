package unp.student.work.manager.domain;

import java.util.Date;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="person_finance")
public class PersonFinance{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="studentid")
	private PersonPersonInfo personPersonInfo;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="money")
	private String money;

	@Column(name="createtime")
	private Date createtime;
	
	@Column(name="remark")
	private String remark;
	
	public PersonFinance() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PersonPersonInfo getPersonPersonInfo() {
		return personPersonInfo;
	}

	public void setPersonPersonInfo(PersonPersonInfo personPersonInfo) {
		this.personPersonInfo = personPersonInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
	
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
	