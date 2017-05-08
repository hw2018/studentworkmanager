package unp.student.work.manager.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.UserDao;
import unp.student.work.manager.model.PersonInfo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public PersonInfo get(String studentid) {
		// TODO Auto-generated method stub
		
		return (PersonInfo)sessionFactory.getCurrentSession().get(PersonInfo.class, studentid);
	}


}