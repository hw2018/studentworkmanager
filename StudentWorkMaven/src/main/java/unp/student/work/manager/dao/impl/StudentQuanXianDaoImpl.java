package unp.student.work.manager.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.StudentQuanXianDao;
import unp.student.work.manager.domain.StudentQuanxian;


@Repository("studentQuanXianDao")
public class StudentQuanXianDaoImpl extends BaseDaoImpl<StudentQuanxian> implements
		StudentQuanXianDao {

	public StudentQuanxian getByStudent(String studentid) {
		// TODO Auto-generated method stub
		String hql="from StudentQuanxian s where s.studentid=:studentid";
		return (StudentQuanxian)getSession().createQuery(hql).setString("studentid", studentid).uniqueResult();
	}

	
}
