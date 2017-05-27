package unp.student.work.manager.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.dao.PersonUserDao;
import unp.student.work.manager.domain.PersonPersonInfo;

@Component
public class PersonInfoService  //����������ʹ�õ�ʱ��SessionUtil�Ķ��������Springע�����ɣ�������Լ�new��������ô�õ���sessionFactory��null��
{
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private PersonUserDao personUserDao;
	
	public PersonPersonInfo getPersonInfo(String studentid) 
	{  
		return (PersonPersonInfo)sessionFactory.getCurrentSession().get(PersonPersonInfo.class, studentid); 
	}
	
	public void save(PersonPersonInfo personPersonInfo)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.saveOrUpdate(personPersonInfo);  //��������������ݿ����Ѿ����ڣ���update������save
	}

	public boolean addUser(PersonPersonInfo personPersonInfo) throws Exception
	{
		Session s = sessionFactory.getCurrentSession(); 
		if(personUserDao.checkExist(personPersonInfo.getStudentid()))  //��ʾ�û��Ѿ�����
			return false;
		else
		{
			s.save(personPersonInfo);
			return true;
		}
			
	}
}
