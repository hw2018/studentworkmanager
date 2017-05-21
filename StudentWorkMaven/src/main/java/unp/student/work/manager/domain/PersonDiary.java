package unp.student.work.manager.domain;

import java.util.Date;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="person_diary")
public class PersonDiary{
	@Id
	//@GenericGenerator(name="assigned",strategy="assigned")
	//@GeneratedValue(generator="assigned")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="studentid")
	private PersonPersonInfo personPersonInfo;
	
	@Column(name="name")
	private String name;
	
	@Column(name="content")
	private String content;
	
	@Column(name="createtime")
	private Date createtime;
	
	
	public PersonDiary() {
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




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public Date getCreatetime() {
		return createtime;
	}




	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	


	
	
}
	