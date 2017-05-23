<%@ page language="java" import="
java.sql.*,
java.net.*,
java.util.List,
java.util.Iterator,
unp.student.work.manager.domain.PersonPersonInfo,
org.hibernate.Session,org.hibernate.Query" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">	
<link rel="stylesheet" href="person/resources/css/style.css" type="text/css"	media="screen" />
<style type="text/css">
li.list{
	line-height:30px;
	font-size:1.4em;
	margin-left:40px;
	list-style:none;
}

html{overflow-x:hidden;}
table{border:thin solid black;}
</style>


</head>
<body style="background-color:dee6f2">

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<h1 align="center">欢迎使用福州大学学生综合管理系统！</h1>
<h1 align="center">For Teacher</h1>

</body>
</html>












