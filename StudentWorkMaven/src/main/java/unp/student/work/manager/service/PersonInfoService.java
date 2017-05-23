package unp.student.work.manager.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.PersonPersonInfo;

@Component
public class PersonInfoService  //在其他类中使用的时候SessionUtil的对象必须由Spring注入生成，如果由自己new出来，那么得到的sessionFactory是null的
{
	@Resource
	private SessionFactory sessionFactory;
	
	public PersonPersonInfo getPersonInfo(String studentid) 
	{  
		return (PersonPersonInfo)sessionFactory.getCurrentSession().get(PersonPersonInfo.class, studentid); 
	}
	
	public void save(PersonPersonInfo personPersonInfo)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.saveOrUpdate(personPersonInfo);  //如果此数据在数据库中已经存在，则update，否则save
	}
	
	public void addUser(PersonPersonInfo personPersonInfo)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.save(personPersonInfo);
	}
}
