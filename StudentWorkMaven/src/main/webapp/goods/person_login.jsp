<%@ page language="java" import="java.sql.*,java.net.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="common/head.jsp"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">   <!--定义基准路径  -->
<title>欢迎使用学生管理系统</title>
<script type="text/javascript">
		function error()
		{
			var error = "<%=session.getAttribute("error")%>";
			if(error==1)
			alert("账号或密码错误，请重新输入！");
		}
	</script>
<link rel="stylesheet" href="person/resources/css/style.css" type="text/css"	media="screen" />
</head>

<body onload="error()">
	<div style="position: absolute; left: 40%; top: 40%; ">
		<h3>欢迎使用学生管理系统</h3>
		
		<%session.setAttribute("error",0);%>
		
		<form name="form1" action="userValidate" method="post">
			<p>	账号：<input class="text-input large-input" type="text" name="username" />	</p>
			<p>	密码：<input class="text-input large-input" type="password" name="password" />	</p>
			<p>	<input class="button" type="submit" value="确定" /> <input	class="button" type="reset" value="取消" />	</p>
		</form>
	</div>
</body>
</html>