package unp.student.work.manager.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.smtp.SMTPSaslAuthenticator;
import com.sun.mail.smtp.SMTPTransport;

import unp.student.work.manager.domain.PersonMailAccount;
import unp.student.work.manager.domain.PersonPersonInfo;

import unp.student.work.manager.service.PersonMailAccountService;



import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.http.*;
import javax.servlet.*;


@Component
public class PersonMailAccountAction extends ActionSupport {
	private String studentid;
	private String id;
	private String address;
	private String account;
	private String password;
	private String remark;
	private PersonMailAccount personMailAccount = new PersonMailAccount();
	private PersonPersonInfo personPersonInfo = new PersonPersonInfo();
	
	
	private String from;
	private String to;
	private String subject;
	private String content;
	
	@Resource
	private PersonMailAccountService personMailAccountService;
	
	
	public String add() throws Exception
	{
		personPersonInfo.setStudentid(studentid);  //这里是获取当前session中的用户名的代码
		personMailAccount.setAddress(address);
		personMailAccount.setAccount(account);
		personMailAccount.setPassword(password);
		personMailAccount.setRemark(remark);
		personMailAccount.setPersonPersonInfo(personPersonInfo);
		
		personMailAccountService.save(personMailAccount);
		
		return SUCCESS;
	}

	
	
	public String delete() throws Exception
	{
		personMailAccountService.delete(id);
		
		return SUCCESS;
	}
	
	
	public String modify() throws Exception
	{
		personPersonInfo.setStudentid(studentid); 
		personMailAccount.setId(Integer.parseInt(id));
		personMailAccount.setAddress(address);
		personMailAccount.setAccount(account);
		personMailAccount.setPassword(password);
		personMailAccount.setRemark(remark);
		personMailAccount.setPersonPersonInfo(personPersonInfo);
		personMailAccountService.modify(personMailAccount);
		
		return SUCCESS;
	}
	
	public String send() throws Exception
	{
		
		PersonMailAccount personMailAccount = personMailAccountService.getAccount(from);
		final String username = personMailAccount.getAccount();
		final String passwd = personMailAccount.getPassword();
		String host=null;
		String address = personMailAccount.getAddress();
		if(address.contains("@163.com")) host = "smtp.163.com";  //用于支持163.com邮箱
		else if(address.contains("@163.net"))host="smtp.163.net";//用于支持163.net邮箱
		else if(address.contains("@126.com"))host="smtp.126.com";//用于支持126.com邮箱
		else if(address.contains("@qq.com"))host="smtp.qq.com";	 //用于支持qq.com邮箱
		else if(address.contains("@foxmail.com"))host="smtp.exmail.qq.com";  //用于支持foxmail.com邮箱
		else if(address.contains("@yeah.net"))host="smtp.yeah.net";  //用于支持yeah.net邮箱
		else if(address.contains("@sohu.com"))host="smtp.sohu.com";  //用于支持sohu.com邮箱
		else if(address.contains("@sina.com"))host="smtp.sina.com.cn"; //用于支持sina.com邮箱
		
		Properties props = System.getProperties();// 获取系统属性对象
		props.setProperty("mail.smtp.host",host); // 设置发信的主机
		props.setProperty("mail.transport.protocol","smtp");
		props.setProperty("mail.smtp.auth","true"); 
		
		
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
	        protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(username,passwd);}});// 获取默认的Jsp页面的Session对象。
		
		try
		{
		   //只发送文本邮件的代码 
		   MimeMessage message = new MimeMessage(session);// 创建MimeMessage对象【该对象存储了一封邮件的所有内容】。    
		   
		   message.setFrom(new InternetAddress(from)); // 设置发送者
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));// 设置接收者
		   message.setSubject(subject);// 设置邮件主题Subject
		   message.setText(content); //设置邮件正文内容
		   message.setSentDate(new Date()); //设置发送日期
		   message.saveChanges();
		   
		   Transport.send(message);// 发送消息
		   return "success";//如果能运行到这里说明邮件发送成功
		   
		}
		catch(MessagingException mex) 
		{
		   mex.printStackTrace();
		   return "failure";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
	
	
	public String getFrom() {
		return from;
	}



	public void setFrom(String from) {
		this.from = from;
	}



	public String getTo() {
		return to;
	}



	public void setTo(String to) {
		this.to = to;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}

	
}
