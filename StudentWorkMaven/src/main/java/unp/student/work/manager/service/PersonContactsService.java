package unp.student.work.manager.service;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.PersonContacts;

@Component
public class PersonContactsService
{
	@Resource
	private SessionFactory sessionFactory;
	
	public void save(PersonContacts personContacts)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.save(personContacts);
	}
	
	public void delete(String id)
	{
		Session s = sessionFactory.getCurrentSession(); 
		Query q = s.createQuery("delete from PersonContacts where id = ?");
		q.setParameter(0, Integer.parseInt(id));
		q.executeUpdate();
	}
	
	public void modify(PersonContacts personContacts)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.update(personContacts); 
	}
	
}
