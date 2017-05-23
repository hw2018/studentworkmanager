package unp.student.work.manager.dao.impl;

import org.springframework.stereotype.Repository;

import unp.student.work.manager.dao.StudentCounsellorDao;
import unp.student.work.manager.domain.counsellor;
import unp.student.work.manager.domain.student_counsellor;


@Repository("studentcounsellorDao")
public class WorkStudentCounsellorDaoImpl extends BaseDaoImpl<student_counsellor> implements StudentCounsellorDao {

	public student_counsellor getRecordByStudentAndTeacher(String studentid,
			int cid) {
		// TODO Auto-generated method stub
		String hql="from student_counsellor sc where sc.personInfo.studentid=:studentid and sc.counsellor.id=:cid";
		
		return (student_counsellor)getSession().createQuery(hql).setString("studentid", studentid)
				.setInteger("cid", cid).uniqueResult();
	}

	public long findByCounsellor(int cid) {
		// TODO Auto-generated method stub
		String hql="select count(*) from student_counsellor c where c.counsellor.id=:cid";
		
		return (Long)getSession().createQuery(hql).setInteger("cid", cid).uniqueResult();
	}
}
