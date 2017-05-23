package unp.student.work.manager.service.impl;

import java.io.Serializable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import unp.student.work.manager.dao.BaseDao;
import unp.student.work.manager.service.BaseService;
import unp.student.work.manager.utils.PageBean;
public  class BaseServiceImpl<T> implements BaseService<T> { 		  
	    @Autowired  
	    private BaseDao<T> baseDao;   	    
	    private Class<T>  classT;
	    
	    public BaseServiceImpl(Class classT) {
			// TODO Auto-generated constructor stub
	    	this.classT=classT;
		}
	    public Serializable save(T t) {  
	        return baseDao.save(t);  
	    }  
	  
	    public T findById(Serializable id) {  
	        return baseDao.get(classT, id);  
	    }  	  
	  
	    public void delete(T t) {  
	        baseDao.delete(t);  
	    }  
	  
	    public void deleteById(Serializable id) {  
	         baseDao.delete(classT, id);  
	    }  
	  
	    public List<T> findAll() {  
	        return baseDao.findAll(classT);  
	    }

		public long getTotalCount() {
			// TODO Auto-generated method stub
			return baseDao.findCount(classT);
		}

	}
