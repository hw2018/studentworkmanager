package unp.student.work.manager.controller;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;





import org.springframework.stereotype.Controller;

import unp.student.work.manager.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Iterator;
import java.util.Map;

@Controller("userAction")
public class UserAction extends ActionSupport {
	private String userName;
	private String password;
	
	@Resource
	private UserService userService;
	// String user;
	public String login(){

		boolean flag=userService.validate(userName, password);	
		if (flag) {
			//3. 把用户名放入session�?
			ActionContext actionContext=ActionContext.getContext();
			Map session=actionContext.getSession();
			session.put("user", userName);
			//HttpSession session=request.getSession();
			//session.setAttribute("user", userName);
			return "success";
		}else
			return "login";		
	}
	
	public String logout(){
			ActionContext actionContext=ActionContext.getContext();
			Map session=actionContext.getSession();
			session.remove("user");			
			return "login";
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
