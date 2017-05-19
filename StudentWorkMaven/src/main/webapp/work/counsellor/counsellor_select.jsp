<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="unp.student.work.manager.domain.counsellor" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'counsellor_select.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="counsellor/select_counsellor.action">
    <table id="InstructorJudgeStudentPointTable" style="margin-left: 12px; margin-top: 10px;">
    <tbody>
    	<tr>
    		<th style="width:80px;">选择</th>
    		<th style="width:120px;">姓名</th>
    	</tr>
    	<c:forEach var="item" items="${counsellor }">
    	<tr>
    		<td><input  value="${item.id }" name="select"   type="radio"></td>
    		<td>${item.name }</td>
    	</tr>
    	</c:forEach>
    	
   </tbody>
   </table>
   	<input type="submit" value="确定"> 
   </form>
  </body>
  <script>
  			
  
  </script>
</html>
