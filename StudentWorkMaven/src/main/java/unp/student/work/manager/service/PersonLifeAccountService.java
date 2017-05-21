package unp.student.work.manager.service;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.PersonLifeAccount;

@Component
public class PersonLifeAccountService
{
	@Resource
	private SessionFactory sessionFactory;
	
	public void save(PersonLifeAccount personLifeAccount)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.save(personLifeAccount);
	}
	
	public void delete(String id)
	{
		Session s = sessionFactory.getCurrentSession(); 
		Query q = s.createQuery("delete from PersonLifeAccount where id = ?");
		q.setParameter(0, Integer.parseInt(id));
		q.executeUpdate();
	}
	
	
	public void modify(PersonLifeAccount personLifeAccount)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.update(personLifeAccount); 
	}
}
