package unp.student.work.manager.domain;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="person_favorite")
public class PersonFavorite{
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
	
	@Column(name="url")
	private String url;
	

	public PersonFavorite() {
		super();
	}

	public PersonFavorite(PersonPersonInfo personPersonInfo, String name, String url) {
		super();
		this.personPersonInfo = personPersonInfo;
		this.name = name;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
	