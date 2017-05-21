package unp.student.work.manager.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import unp.student.work.manager.domain.PersonPersonInfo;
import unp.student.work.manager.domain.PersonPersonInfoDto;
import unp.student.work.manager.service.PersonInfoService;

@Component
public class PersonInfoAction extends ActionSupport {

	private PersonPersonInfoDto personPersonInfoDto;
	private PersonPersonInfo personPersonInfo;
	
	@Resource
	private PersonInfoService personInfoService;

	

	public String modify() throws Exception
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String pass= personPersonInfoDto.getBirthday(); 
		Date d = formatter.parse(pass);
		String password="123456";  //密码修改功能不应该放在我这一个子系统内，所以这里应该改成从数据库中获取studentid的密码
		
		personPersonInfo = new PersonPersonInfo(personPersonInfoDto.getStudentid(),personPersonInfoDto.getName(),personPersonInfoDto.getSex(),personPersonInfoDto.getIdcard(),personPersonInfoDto.getNation(),d,personPersonInfoDto.getPlaceofbirth(),personPersonInfoDto.getPoliticalstatus(),personPersonInfoDto.getMajorid(),personPersonInfoDto.getGrade(),personPersonInfoDto.getTel(),personPersonInfoDto.getEmail(),password,personPersonInfoDto.getCollege(),personPersonInfoDto.getStatus(),personPersonInfoDto.getBuild(),personPersonInfoDto.getHostel());
		personInfoService.save(personPersonInfo);
		
		return "success";
	}
	
	
	public PersonPersonInfoDto getPersonPersonInfoDto() {
		return personPersonInfoDto;
	}
	public void setPersonPersonInfoDto(PersonPersonInfoDto personPersonInfoDto) {
		this.personPersonInfoDto = personPersonInfoDto;
	}
	
	
	
}
