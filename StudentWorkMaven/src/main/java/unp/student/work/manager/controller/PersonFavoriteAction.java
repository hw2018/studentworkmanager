package unp.student.work.manager.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.PersonFavorite;
import unp.student.work.manager.domain.PersonPersonInfo;
import unp.student.work.manager.service.PersonFavoriteService;

@Component
public class PersonFavoriteAction extends ActionSupport {
	private String id;
	private String name;
	private String url;
	private PersonPersonInfo personPersonInfo = new PersonPersonInfo();
	private PersonFavorite personFavorite = new PersonFavorite();
	
	@Resource
	private PersonFavoriteService personFavoriteService;

	public String add() throws Exception
	{
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //得到session的Map形式
		String studentid = (String)session.get("studentid");  //取出session中属性为studentid的值
		personPersonInfo.setStudentid(studentid);  //这里是获取当前session中的用户名的代码
		personFavorite.setName(name);
		personFavorite.setUrl(url);
		personFavorite.setPersonPersonInfo(personPersonInfo);
		personFavoriteService.save(personFavorite);
		
		return SUCCESS;
	}
	
	public String delete() throws Exception
	{
		//personFavorite.setId(id);
		personFavoriteService.delete(id);
		
		return SUCCESS;
	}
	
	public String modify() throws Exception
	{

		personFavorite.setId(Integer.parseInt(id));
		personFavorite.setName(name);
		personFavorite.setUrl(url);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> session = (Map)ActionContext.getContext().getSession();    //得到session的Map形式
		String studentid = (String)session.get("studentid");  //取出session中属性为studentid的值
		personPersonInfo.setStudentid(studentid);  //这里是获取当前session中的用户名的代码
		personFavorite.setPersonPersonInfo(personPersonInfo);
		personFavoriteService.modify(personFavorite);
		
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
