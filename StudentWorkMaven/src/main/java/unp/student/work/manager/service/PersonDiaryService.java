package unp.student.work.manager.service;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.PersonDiary;

@Component
public class PersonDiaryService
{
	@Resource
	private SessionFactory sessionFactory;
	
	public void save(PersonDiary personDiary)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.save(personDiary);
	}
	
	public void delete(String id)
	{
		Session s = sessionFactory.getCurrentSession(); 
		Query q = s.createQuery("delete from PersonDiary where id = ?");
		q.setParameter(0, Integer.parseInt(id));
		q.executeUpdate();
	}
	
	public void modify(PersonDiary personDiary)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.update(personDiary); 
	}
	
	public PersonDiary getPersonDiary(String id)
	{
		return (PersonDiary)sessionFactory.getCurrentSession().get(PersonDiary.class, Integer.parseInt(id));
	}
	
}
