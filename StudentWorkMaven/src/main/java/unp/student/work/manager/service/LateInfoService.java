package unp.student.work.manager.service;

import java.util.List;


import unp.student.work.manager.model.late_info;
import unp.student.work.manager.utils.PageBean;

public interface LateInfoService {

	//晚点信息操作
	public PageBean findByPage(int pageno);//按页查询
	void add(late_info lateinfo,String id,String situation);//增加晚点信息
	void delete(late_info lateinfo);
	void update(late_info lateinfo,String situation);
	late_info get(int id);
	List findAll();
	Long findCount();
	
	//晚点具体信息 缺勤信息操作
	void deleteinfo(int lateinfoid,int latepersonid);
	void addinfo(int lateinfoid,String studentid);
	void updateinfo(int latepersonid,String reason );
	void dealinfo(int lateinfoid,int latepersonid);
}
