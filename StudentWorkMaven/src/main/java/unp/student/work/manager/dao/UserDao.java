package unp.student.work.manager.dao;

import unp.student.work.manager.domain.PersonInfo;

public interface UserDao  {

	public PersonInfo get(String  studentid);
}
