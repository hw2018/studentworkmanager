package unp.student.work.manager.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.CategoryDao;
import unp.student.work.manager.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	@Resource
	 private SessionFactory sessionFactory;
	
	 protected Session getSession() {  
	        //从当前线程获取session，如果没有则创建一个新的session  
	        return sessionFactory.getCurrentSession();  
	    }

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		getSession().save(category);
		
	} 

}
