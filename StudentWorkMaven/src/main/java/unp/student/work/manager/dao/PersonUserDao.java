package unp.student.work.manager.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.PersonPersonInfo;

@Component
public class PersonUserDao 
{
	@Resource
	private SessionFactory sessionFactory;
	
	public boolean checkStudent(String studentid, String password)throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from PersonPersonInfo p where p.studentid=? and p.password=?").setParameter(0, studentid).setParameter(1, password);;
		//��setParameter���ص���Query�����Կ���һֱǶ����ȥ
		PersonPersonInfo personPersonInfo = null;
		personPersonInfo = (PersonPersonInfo)q.uniqueResult();
		if(personPersonInfo!=null)
			return true;
		else
			return false;
	}
	
	public boolean checkTeacher(String studentid, String password)throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from PersonPersonInfo p where p.studentid=? and p.password=?").setParameter(0, studentid).setParameter(1, password);;
		//��setParameter���ص���Query�����Կ���һֱǶ����ȥ
		PersonPersonInfo personPersonInfo = null;
		personPersonInfo = (PersonPersonInfo)q.uniqueResult();
		if(personPersonInfo!=null)
			return true;
		else
			return false;
	}
	
	/*public int passwordModify(String username, String password) throws Exception
	{
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("update User set password=? where name=?");
		q.setParameter(0, password).setParameter(1, username);
		Transaction tx = session.beginTransaction();
		int line = q.executeUpdate();
		tx.commit();
		HibernateUtil.closeSession();
		return line;
	}*/
	
	public boolean checkExist(String studentid)throws Exception
	{
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from PersonPersonInfo p where p.studentid=?").setParameter(0, studentid);
		//��setParameter���ص���Query�����Կ���һֱǶ����ȥ
		PersonPersonInfo personPersonInfo = null;
		personPersonInfo = (PersonPersonInfo)q.uniqueResult();
		if(personPersonInfo!=null)
			return true;
		else
			return false;
	}
}
