package unp.student.work.manager.service;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.PersonPlan;

@Component
public class PersonPlanService
{
	@Resource
	private SessionFactory sessionFactory;
	
	public void save(PersonPlan personPlan)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.save(personPlan);
	}
	
	public void delete(String id)
	{
		Session s = sessionFactory.getCurrentSession(); 
		Query q = s.createQuery("delete from PersonPlan where id = ?").setParameter(0, Integer.parseInt(id));
		q.executeUpdate();
	}
	
	public void modify(PersonPlan personPlan)
	{
		Session s = sessionFactory.getCurrentSession(); 
		s.update(personPlan); 
	}
	
	public int[] getStatistics(String studentid)
	{
		int []n={0,0,0};  //分别存储已完成/未完成/总数
		Number number;
		Query q;
		
		Session s = sessionFactory.getCurrentSession();
		q = s.createQuery("select count(*) from PersonPlan where studentid=? and result='completed'").setParameter(0, studentid);
		number = (Number)q.uniqueResult();  
		n[0] = number.intValue();
		
		q = s.createQuery("select count(*) from PersonPlan where studentid=? and result='unfinished'").setParameter(0, studentid);
		number = (Number)q.uniqueResult();  
		n[1] = number.intValue(); 
		
		q = s.createQuery("select count(*) from PersonPlan where studentid=?").setParameter(0, studentid);
		number = (Number)q.uniqueResult(); 
		n[2] = number.intValue(); 
		
		return n;
	}
	
}
