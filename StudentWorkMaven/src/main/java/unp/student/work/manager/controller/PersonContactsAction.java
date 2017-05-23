package unp.student.work.manager.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.PersonContacts;
import unp.student.work.manager.domain.PersonPersonInfo;
import unp.student.work.manager.service.PersonContactsService;


@Component
public class PersonContactsAction extends ActionSupport {
	private String id;
	private String name;
	private String tel;
	private String fixtel;
	private String email;
	private PersonPersonInfo personPersonInfo = new PersonPersonInfo();
	private PersonContacts personContacts = new PersonContacts();
	
	@Resource
	private PersonContactsService personContactsService;

	public String add() throws Exception
	{
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //得到session的Map形式
		String studentid = (String)session.get("studentid");  //取出session中属性为studentid的值
		personPersonInfo.setStudentid(studentid);  //这里是获取当前session中的用户名的代码
		personContacts.setName(name);
		personContacts.setTel(tel);
		personContacts.setFixtel(fixtel);
		personContacts.setEmail(email);
		personContacts.setPersonPersonInfo(personPersonInfo);
		personContactsService.save(personContacts);
		
		return SUCCESS;
	}


	
	
	public String delete() throws Exception
	{
		personContactsService.delete(id);
		
		return SUCCESS;
	}
	
	
	public String modify() throws Exception
	{

		personContacts.setId(Integer.parseInt(id));
		personContacts.setName(name);
		personContacts.setTel(tel);
		personContacts.setFixtel(fixtel);
		personContacts.setEmail(email);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //得到session的Map形式
		String studentid = (String)session.get("studentid");  //取出session中属性为studentid的值
		personPersonInfo.setStudentid(studentid);  //这里是获取当前session中的用户名的代码
		personContacts.setPersonPersonInfo(personPersonInfo);
		
		personContactsService.modify(personContacts);
		
		return SUCCESS;
	}
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
