package unp.student.work.manager.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.PersonFavorite;
import unp.student.work.manager.domain.PersonLifeAccount;
import unp.student.work.manager.domain.PersonPersonInfo;
import unp.student.work.manager.service.PersonFavoriteService;
import unp.student.work.manager.service.PersonLifeAccountService;

@Component
public class PersonLifeAccountAction extends ActionSupport {
	private String id;
	private String body;
	private String account;
	private String password;
	private String remark;
	private PersonLifeAccount personLifeAccount = new PersonLifeAccount();
	private PersonPersonInfo personPersonInfo = new PersonPersonInfo();
	
	@Resource
	private PersonLifeAccountService personLifeAccountService;

	public String add() throws Exception
	{
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //得到session的Map形式
		String studentid = (String)session.get("studentid");  //取出session中属性为studentid的值
		personPersonInfo.setStudentid(studentid);  //这里是获取当前session中的用户名的代码
		personLifeAccount.setBody(body);
		personLifeAccount.setAccount(account);
		personLifeAccount.setPassword(password);
		personLifeAccount.setRemark(remark);
		personLifeAccount.setPersonPersonInfo(personPersonInfo);
		
		personLifeAccountService.save(personLifeAccount);
		
		return SUCCESS;
	}

	
	
	public String delete() throws Exception
	{
		personLifeAccountService.delete(id);
		
		return SUCCESS;
	}
	
	
	public String modify() throws Exception
	{
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //得到session的Map形式
		String studentid = (String)session.get("studentid");  //取出session中属性为studentid的值
		personPersonInfo.setStudentid(studentid);  //这里是获取当前session中的用户名的代码
		
		personLifeAccount.setId(Integer.parseInt(id));
		personLifeAccount.setBody(body);
		personLifeAccount.setAccount(account);
		personLifeAccount.setPassword(password);
		personLifeAccount.setRemark(remark);
		personLifeAccount.setPersonPersonInfo(personPersonInfo);
		personLifeAccountService.modify(personLifeAccount);
		
		return SUCCESS;
	}
	
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
