package unp.student.work.manager.service.impl;

import java.net.URL;
import java.util.Collection;

import javax.annotation.Resource;
import javax.xml.registry.JAXRException;
import javax.xml.registry.LifeCycleManager;
import javax.xml.registry.infomodel.Association;
import javax.xml.registry.infomodel.Classification;
import javax.xml.registry.infomodel.Concept;
import javax.xml.registry.infomodel.ExternalIdentifier;
import javax.xml.registry.infomodel.ExternalLink;
import javax.xml.registry.infomodel.InternationalString;
import javax.xml.registry.infomodel.Key;
import javax.xml.registry.infomodel.Organization;
import javax.xml.registry.infomodel.PersonName;
import javax.xml.registry.infomodel.Slot;
import javax.xml.registry.infomodel.User;

import org.springframework.stereotype.Service;

import unp.student.work.manager.dao.UserDao;
import unp.student.work.manager.domain.PersonInfo;
import unp.student.work.manager.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	public boolean validate(String username, String password) {
		// TODO Auto-generated method stub
		if(userDao.get(username)==null){
			return false;
		}
		PersonInfo personInfo=userDao.get(username);
		
		if(password.equals(personInfo.getPassword())){
			return true;
		}
		return false;
	}



	

}
