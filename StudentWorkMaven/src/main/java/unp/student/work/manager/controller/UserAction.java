package unp.student.work.manager.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;







import org.springframework.stereotype.Controller;

import unp.student.work.manager.domain.StudentQuanxian;
import unp.student.work.manager.service.StudentQuanXianService;
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
	
	@Resource
	private StudentQuanXianService studentQuanXianService;
	// String user;
	public String login(){

		boolean flag=userService.validate(userName, password);	
		if (flag) {
			//3. 鎶婄敤鎴峰悕鏀惧叆session涓?
			ActionContext actionContext=ActionContext.getContext();
			Map session=actionContext.getSession();
			session.put("user", userName);
			//权限加入session
			StudentQuanxian studentQuanxian=studentQuanXianService.getByStduent(userName);
			if(studentQuanxian==null){
				session.put("quanxian", "000000");
			}else{
			session.put("quanxian", studentQuanxian.getQuanxian());
			}
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
