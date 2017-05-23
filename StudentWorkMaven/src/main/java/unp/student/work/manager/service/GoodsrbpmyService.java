package unp.student.work.manager.service;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import unp.student.work.manager.domain.Goodsrbpmy;

@Component
public class GoodsrbpmyService {
	@Resource
	private SessionFactory sessionFactory;

	public void save(Goodsrbpmy goodsrbpmy) {
		Session s = sessionFactory.getCurrentSession(); // 获取会话
		s.save(goodsrbpmy);
	}

	public void delete(String id) {
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("delete from Goodsrbpmy where id = ?");
		q.setParameter(0, Integer.parseInt(id));
		q.executeUpdate();
	}

	public void modify(Goodsrbpmy goodsrbpmy) {
		Session s = sessionFactory.getCurrentSession();
		s.update(goodsrbpmy);
	}

}
