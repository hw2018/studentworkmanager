package unp.student.work.manager.dao;

import java.util.List;

import unp.student.work.manager.domain.Activity;


public interface ApplyActivityDao extends BaseDao<Activity> {
	List findByPage(int pageNo, int pageSize);
/*	List findAll();    //鑾峰彇鎵�湁鐨勫熀閲戣褰�杩斿洖Fund瀵硅薄鍒楄〃
	void insert(Activity activity);    //鎻掑叆涓�潯鍩洪噾璁板綍
	void delete(int activityNo);    //鎸変富閿垹闄や竴鏉″熀閲戣褰�
	void update(Activity activity);    //鏇存柊涓�潯鍩洪噾璁板綍
	Activity findById(int activityNo);  //鎸変富閿煡鎵惧熀閲戣褰曪紝杩斿洖Fund瀵硅薄
	List findByPage(int pageNo, int pageSize); //鑾峰彇涓�〉鐨勫熀閲戣褰�杩斿洖Fund瀵硅薄鍒楄〃
	int  findRowCount();    //鏌ユ壘璁板綍鎬绘暟
*/}
