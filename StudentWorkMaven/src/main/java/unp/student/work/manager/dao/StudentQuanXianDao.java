package unp.student.work.manager.dao;

import unp.student.work.manager.domain.StudentQuanxian;

public interface StudentQuanXianDao extends BaseDao<StudentQuanxian>{

	
	public StudentQuanxian getByStudent(String studentid);
}
