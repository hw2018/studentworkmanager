package unp.student.work.manager.service;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.PersonFavorite;
import unp.student.work.manager.domain.PersonLifeAccount;

@Component
public class PersonFavoriteService  //在其他类中使用的时候SessionUtil的对象必须由Spring注入生成，如果由自己new出来，那么得到的sessionFactory是null的
{
	@Resource
	private SessionFactory sessionFactory;
	
	public void save(PersonFavorite personFavorite)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.save(personFavorite);
	}
	
	public void delete(String id)
	{
		Session s = sessionFactory.getCurrentSession(); 
		Query q = s.createQuery("delete from PersonFavorite where id = ?");
		q.setParameter(0, Integer.parseInt(id));
		q.executeUpdate();
	}
	
	public void modify(PersonFavorite personFavorite)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.update(personFavorite); 
	}
	
}
