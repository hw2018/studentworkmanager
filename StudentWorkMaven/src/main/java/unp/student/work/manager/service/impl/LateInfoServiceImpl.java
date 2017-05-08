package unp.student.work.manager.service.impl;

import java.util.List;





import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.LateInfoDao;
import unp.student.work.manager.dao.LatePersonDao;
import unp.student.work.manager.dao.UserDao;
import unp.student.work.manager.model.late_info;
import unp.student.work.manager.model.late_person;
import unp.student.work.manager.service.LateInfoService;
import unp.student.work.manager.utils.PageBean;

@Service("lateInfoService")
public class LateInfoServiceImpl implements LateInfoService {
	
	@Resource
	private LateInfoDao lateInfoDao;
	@Resource
	private UserDao userDao;
	@Resource
	private LatePersonDao  latepersonDao;

	public PageBean findByPage(int pageno) {
		// TODO Auto-generated method stub
		
		PageBean pageBean=new PageBean();
		pageBean.setData(lateInfoDao.findByPage(pageno));
		pageBean.setMaxPage((int)(lateInfoDao.findCount(late_info.class)/10)+1);
		pageBean.setCurPage(pageno);
		return pageBean;
	}

	public void add(late_info lateinfo,String id,String situation) {
		// TODO Auto-generated method stub
		//添加晚点信息时级联添加晚点具体信息记录
		lateinfo.setPersonInfo(userDao.get(id));
		String [] persons=situation.split(",");
		lateinfo.setNum(persons.length);
		int lid=(Integer)lateInfoDao.save(lateinfo);
		for(String studentid:persons){
			late_person latePerson=new late_person();
			latePerson.setPersonInfo(userDao.get(studentid));
			latePerson.setLate_info(lateInfoDao.get(late_info.class, lid));
			latepersonDao.save(latePerson);
		}
	}

	public void delete(late_info lateinfo) {
		// TODO Auto-generated method stub
		lateInfoDao.delete(late_info.class,lateinfo.getId());
	}

	public void update(late_info lateinfo ,String situation) {
		// TODO Auto-generated method stub
		if(situation==null){
			//删除bylateinfoid  所有的lateperson
		}
		
		
		String [] persons=situation.split(",");
		lateinfo.setNum(persons.length);
		lateInfoDao.update(lateinfo);
		lateinfo=lateInfoDao.get(late_info.class,lateinfo.getId() );
		//System.out.println(lateinfo.getTime());
		Set latePersons=lateinfo.getLate_persons();
		Object[] late_persons=latePersons.toArray();
		for(String studentid:persons){//判断是否已经有了  未实现没有的删除
			
			//System.out.println(studentid);
			int i=0;
			for(;i<late_persons.length;i++){
				if(((late_person) late_persons[i]).getPersonInfo().getStudentid().equals(studentid)){
					break;
				}
			}
			if(i==late_persons.length){//如果没有 添加
				late_person late_person1=new late_person();
				late_person1.setLate_info(lateinfo);
				late_person1.setPersonInfo(userDao.get(studentid));
			//	System.out.println(late_person1.getLate_info().getId()+late_person1.getPersonInfo().getStudentid());
				latepersonDao.save(late_person1);
			}
		}
		
		//hasSet实现
		
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long findCount() {
		// TODO Auto-generated method stub
		return lateInfoDao.findCount(late_info.class);
	}

	public late_info get(int id) {
		// TODO Auto-generated method stub
		
		return lateInfoDao.get(late_info.class,id);
	}

	public void deleteinfo(int lateinfoid,int latepersonid) {
		// TODO Auto-generated method stub
		
		//删除晚点具体信息时级联更新晚点信息
		late_info late_info1=lateInfoDao.get(late_info.class, lateinfoid);
		late_info1.setNum(late_info1.getNum()-1);
		lateInfoDao.update(late_info1);
		latepersonDao.delete(late_person.class, latepersonid);
		
	}

	public void addinfo(int lateinfoid,String studentid) {
		
		//添加晚点具体信息时级联更新晚点信息
		late_info late_info1=lateInfoDao.get(late_info.class, lateinfoid);
		late_info1.setNum(late_info1.getNum()+1);
		lateInfoDao.update(late_info1);
		late_person latePerson=new late_person();
		latePerson.setLate_info(lateInfoDao.get(late_info.class, lateinfoid));
		latePerson.setPersonInfo(userDao.get(studentid));
		latepersonDao.save(latePerson);
		
		// TODO Auto-generated method stub
		
		
	}

	public void updateinfo(int latepersonid, String reason) {
		// TODO Auto-generated method stub
		
		late_person late_person1=latepersonDao.get(late_person.class, latepersonid);
		late_person1.setReason(reason);
		late_person1.setStatus(0);
		latepersonDao.update(late_person1);
		
	}

	public void dealinfo(int lateinfoid, int latepersonid) {
		// TODO Auto-generated method stub
		//处理晚点具体信息时级联更新晚点信息
		late_info late_info1=lateInfoDao.get(late_info.class, lateinfoid);
		late_info1.setNum(late_info1.getNum()-1);
		lateInfoDao.update(late_info1);
		
		late_person late_person1=latepersonDao.get(late_person.class, latepersonid);
		late_person1.setStatus(1);
		latepersonDao.update(late_person1);
		
	}

}
