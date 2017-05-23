package unp.student.work.manager.dao;

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.PersonMailAccount;

@Component
public class PersonMailAccountDao
{

	@Resource
	private SessionFactory sessionFactory;

	public PersonMailAccountDao()  
	{
		//getCurrentSession不能放到构造方法中？ 
	}
	
	public List<PersonMailAccount> getAccounts(String studentid)  //根据指定studentid获得该用户的所有邮箱账号
	{

		Session s = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked") //告诉编译器忽略指定的警告，如果没有这一句，编译器会警告funds是unchecked的
		List<PersonMailAccount> personMailAccounts = s.createQuery("from PersonMailAccount where studentid=?").setParameter(0, studentid).list();
			
		return personMailAccounts;	
	
	}
	
	public PersonMailAccount getAccount(String address)
	{
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from PersonMailAccount where address = ?").setParameter(0, address);
		return (PersonMailAccount)q.uniqueResult();
	}
	
	
	
}