package unp.student.work.manager.service;

import java.io.Serializable;

import java.util.List;


/*
 * 通用Service
 */
public interface BaseService<T> {
	
	/** 
     * 将实体对象保存到数据库中 
     * @param t 待保存的实体对象 
     * @return 实体对象的ID 
     */  
    Serializable save(T t); 
    
    /** 
     * 根据Id查询实体对象 
     * @param id 表记录中的对应的id字段 
     * @return 对应的实体对�? 
     */  
    T findById(Serializable id);  
   
    /** 
     * 保存或更新一个实体对象到表记录中 
     * @param t 待更新的实体对象 
     */       
    void delete(T t);      
    /** 
     * 根据id删除�?条记�? 
     * @param id 待删除记录id 
     * @return 是否删除成功（id是否有效�? 
     */  
    public void deleteById(Serializable id);  
    /** 
     * 加载�?有记录集�? 
     * @return �?有记录集�? 
     */  
    
    public List<T> findAll();  
    
    
    /** 
     * 获取总记录数 
     * @return 总数 
     */  
    public long getTotalCount();

}
