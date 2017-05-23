package unp.student.work.manager.service;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.PersonFinance;

@Component
public class PersonFinanceService
{
	@Resource
	private SessionFactory sessionFactory;
	
	public void save(PersonFinance personFinance)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.save(personFinance);
	}
	
	public void delete(String id)
	{
		Session s = sessionFactory.getCurrentSession(); 
		Query q = s.createQuery("delete from PersonFinance where id = ?").setParameter(0, Integer.parseInt(id));
		q.executeUpdate();
	}
	
	public void modify(PersonFinance personFinance)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.update(personFinance); 
	}
	
	public int[] getStatistics(String studentid)
	{
		int []n={0,0,0};
		int temp=0;
		Iterator it = null;
		PersonFinance personFinance;
		Session s = sessionFactory.getCurrentSession();
		
		Query q = s.createQuery("from PersonFinance where studentid=? and type='income'").setParameter(0, studentid);
		List<PersonFinance> personFinances = q.list();
		it = personFinances.iterator();
		
		while(it.hasNext()) 
		{
			personFinance = (PersonFinance) it.next();
			temp+=Integer.parseInt(personFinance.getMoney());
		}
			
			//temp+=Integer.parseInt(((PersonFinance)(it.next())).getMoney()); 
		n[0]=temp;
		temp=0;
		
		q = s.createQuery("from PersonFinance where studentid=? and type='outcome'").setParameter(0, studentid);
		personFinances = q.list();
		it = personFinances.iterator();
		
		while(it.hasNext()) temp+=Integer.parseInt(((PersonFinance)(it.next())).getMoney()); n[1]=temp;
		temp=0;
		
		
		q = s.createQuery("from PersonFinance where studentid=? and type='borrow'").setParameter(0, studentid);
		personFinances = q.list();
		it = personFinances.iterator();
		
		while(it.hasNext()) temp+=Integer.parseInt(((PersonFinance)(it.next())).getMoney()); n[2]=temp;
		
		return n;
	}
	
}
