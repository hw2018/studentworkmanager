package unp.student.work.manager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import unp.student.work.manager.dao.PersonUserDao;
import unp.student.work.manager.domain.PersonPersonInfo;
import unp.student.work.manager.domain.PersonPersonInfoDto2;
import unp.student.work.manager.service.PersonInfoService;

@Component
public class PersonUserAction extends ActionSupport 
{
	private String studentid;
	private String password;
	PersonPersonInfoDto2 personPersonInfoDto2;
	PersonPersonInfo personPersonInfo;
	
	@Resource
	PersonUserDao personUserDao;
	
	@Resource
	PersonInfoService personInfoService;
	
	public String userValidate() throws Exception 
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(personUserDao.checkStudent(studentid, password)) 
		{
			session.put("studentid",studentid);	//验证成功，把用户名放入session中
			session.put("error",0);
			return "student";
		}
		else if(personUserDao.checkTeacher(studentid, password))
		{
			session.put("studentid",studentid);	//验证成功，把用户名放入session中
			session.put("error",0);
			return "teacher";
		}
		else
		{
			session.put("error",1); //System.out.println("验证失败！");
			return "failure";
		}	
	}
	
	public String userExit() throws Exception   //处理用户退出
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("studentid");   //移除session中的用户信息
		return "success";
	}
	
	public String userRegister() throws Exception   //处理用户注册
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String pass= personPersonInfoDto2.getBirthday(); 
		Date d = formatter.parse(pass);

		personPersonInfo = new PersonPersonInfo(personPersonInfoDto2.getStudentid(),personPersonInfoDto2.getName(),personPersonInfoDto2.getSex(),personPersonInfoDto2.getIdcard(),personPersonInfoDto2.getNation(),d,personPersonInfoDto2.getPlaceofbirth(),personPersonInfoDto2.getPoliticalstatus(),personPersonInfoDto2.getMajorid(),personPersonInfoDto2.getGrade(),personPersonInfoDto2.getTel(),personPersonInfoDto2.getEmail(),personPersonInfoDto2.getPassword(),personPersonInfoDto2.getCollege(),personPersonInfoDto2.getStatus(),personPersonInfoDto2.getBuild(),personPersonInfoDto2.getHostel());
		boolean flag = personInfoService.addUser(personPersonInfo);
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(flag)
		{
			session.put("exist",0);
			return "success";
		}
		else
		{
			session.put("exist",1);
			return "duplication";
		}
	}
	
	/*public String passwordModify() throws Exception   //处理密码修改
	{
		int line = new UserDao().passwordModify(username,password);  //调用userDao的方法执行数据库语句
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("pmbeacon",line);
		
		return "passwordmodify";
	}*/
	
	
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
	
	public String getPassword()
	{
		return password;
	}
	

	public void setPassword(String password)
	{
		this.password = password;
	}

	public PersonPersonInfoDto2 getPersonPersonInfoDto2() {
		return personPersonInfoDto2;
	}

	public void setPersonPersonInfoDto2(PersonPersonInfoDto2 personPersonInfoDto2) {
		this.personPersonInfoDto2 = personPersonInfoDto2;
	}

	
	
	
}
