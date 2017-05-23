<%@ page language="java" import="
unp.student.work.manager.domain.PersonPersonInfo,
unp.student.work.manager.service.PersonInfoService,
org.springframework.context.ApplicationContext,
org.springframework.context.support.ClassPathXmlApplicationContext,
org.hibernate.Session" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">   <!--定义基准路径  -->
<style type="text/css">
td,th{
	line-height:30px;
	font-size:1.4em;
	margin-left:40px;
	list-style:none;
	border-width:1px;
	border-style:solid;
	border-color:black;
}
table{
	border-collapse:collapse;
	
}

</style>

<style type="text/css">
html{overflow-x:hidden }
</style>

</head>
<body style="background-color:dee6f2">

<br/><br/>
<h1 align="center">注册个人信息</h1><br/>

<form name="info" method="post" action="userRegister">
<table align="center" style="table-layout:fixed">
<tr><td width="120">学号：</td><td><input name="personPersonInfoDto2.studentid"  type="text" size="30" style="background-color: transparent;border:none;"/></td>											<td width="120">姓名：</td><td><input name="personPersonInfoDto2.name" type="text" size="30" style="background-color: transparent;border:none;"/></td></tr>
<tr><td width="120">性别：</td><td><input name="personPersonInfoDto2.sex"  type="text" size="30" style="background-color: transparent;border:none;"/></td>		<td width="120">民族：</td><td><input name="personPersonInfoDto2.nation"  type="text" size="30" style="background-color: transparent;border:none;"/></td></tr>
<tr><td width="120">籍贯：</td><td><input name="personPersonInfoDto2.placeofbirth"  type="text" size="30" style="background-color: transparent;border:none;"/></td>		<td width="120">出生年月：</td><td><input name="personPersonInfoDto2.birthday" type="text" size="30" style="background-color: transparent;border:none;"/></td></tr>
<tr><td width="120">年级：</td><td><input name="personPersonInfoDto2.grade"  type="text" size="30" style="background-color: transparent;border:none;"/></td>		<td width="120">政治状态：</td><td><input name="personPersonInfoDto2.politicalstatus" type="text" size="30" style="background-color: transparent;border:none;"/></td></tr>
<tr><td width="120">学院：</td><td><input name="personPersonInfoDto2.college"  type="text" size="30" style="background-color: transparent;border:none;"/></td>		<td width="120">专业编号：</td><td><input name="personPersonInfoDto2.majorid" type="text" size="30" style="background-color: transparent;border:none;"/></td></tr>
<tr><td width="120">手机：</td><td><input name="personPersonInfoDto2.tel"  type="text" size="30" style="background-color: transparent;border:none;"/></td>		<td width="120">电子邮箱：</td><td><input name="personPersonInfoDto2.email" type="text" size="30" style="background-color: transparent;border:none;"/></td></tr>
<tr><td width="120">楼号：</td><td><input name="personPersonInfoDto2.build"  type="text" size="30" style="background-color: transparent;border:none;"/></td>		<td width="120">宿舍号：</td><td><input name="personPersonInfoDto2.hostel" type="text" size="30" style="background-color: transparent;border:none;"/></td></tr>
<tr><td width="120">身份证号：</td><td><input name="personPersonInfoDto2.idcard"  type="text" size="30" style="background-color: transparent;border:none;"/></td>	<td width="120">在校状态：</td><td><input name="personPersonInfoDto2.status" type="text" size="30" style="background-color: transparent;border:none;"/></td></tr>
<tr><td width="120">密码：</td><td><input name="personPersonInfoDto2.password"  type="text" size="30" style="background-color: transparent;border:none;"/></td>	</tr>

</table>
<br/>
<center><input type="submit" value="提交"/>&#12288&#12288&#12288&#12288&#12288&#12288<a href="person/person_login.jsp"><input type="button" value="取消"/></a></center>
</form>


</body>
</html>












