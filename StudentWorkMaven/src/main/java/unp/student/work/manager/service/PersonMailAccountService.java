package unp.student.work.manager.service;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.dao.PersonMailAccountDao;
import unp.student.work.manager.domain.PersonMailAccount;

@Component
public class PersonMailAccountService
{
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private PersonMailAccountDao personMailAccountDao;
	
	
	public void save(PersonMailAccount personMailAccount)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.save(personMailAccount);
	}
	
	public void delete(String id)
	{
		Session s = sessionFactory.getCurrentSession(); 
		Query q = s.createQuery("delete from PersonMailAccount where id = ?");
		q.setParameter(0, Integer.parseInt(id));
		q.executeUpdate();
	}
	
	
	public void modify(PersonMailAccount personMailAccount)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.update(personMailAccount); 
	}
	
	public PersonMailAccount getAccount(String address)
	{
		return personMailAccountDao.getAccount(address);
	}
}
