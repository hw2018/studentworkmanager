package unp.student.work.manager.service;

import unp.student.work.manager.domain.PersonInfo;

public interface UserService {
	
	boolean validate(String username,String password);

}
