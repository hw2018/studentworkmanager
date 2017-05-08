package unp.student.work.manager.service;

import java.util.List;


import unp.student.work.manager.model.late_info;
import unp.student.work.manager.utils.PageBean;

public interface LateInfoService {

	public PageBean findByPage(int pageno);
	void add(late_info lateinfo,String id,String situation);
	void delete(late_info lateinfo);
	void update(late_info lateinfo,String situation);
	late_info get(int id);
	List findAll();
	Long findCount();
	
	void deleteinfo(int lateinfoid,int latepersonid);
	void addinfo(int lateinfoid,String studentid);
	void updateinfo(int latepersonid,String reason );
	void dealinfo(int lateinfoid,int latepersonid);
}
