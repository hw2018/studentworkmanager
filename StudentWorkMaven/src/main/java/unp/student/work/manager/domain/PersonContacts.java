package unp.student.work.manager.domain;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="person_contacts")
public class PersonContacts{
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
	
	@Column(name="tel")
	private String tel;
	
	@Column(name="fixtel")
	private String fixtel;
	
	@Column(name="email")
	private String email;

	public PersonContacts() {
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFixtel() {
		return fixtel;
	}

	public void setFixtel(String fixtel) {
		this.fixtel = fixtel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	
	
}
	