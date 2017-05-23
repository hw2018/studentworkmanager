<%@page import="unp.student.work.manager.utils.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
<%@page import="java.util.List,unp.student.work.manager.domain.ClassChuqin"%>
<%@page import="unp.student.work.manager.dao.ClassChuqinDao"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!--定义基准路径  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../common/cssjs.inc"%>
</head>
<body>

	<h5 align="left">查询出勤信息：</h5>
<form name="form1" method="post" onsubmit="" action="search_classChuqin.action" style="padding:15px;border:thin dashed black;">
<table><tr>
<td>
<div>出勤信息编号：<input class="text-input medium-input" name="body" id="name1" type="text" maxlength="100" size="30" /></div><br/>
<input class="button" type="submit" value="查询" />
</td>



</tr></table>
</form>
    
	<h1 align="center">出勤信息查询结果</h1>
	<table>
		<tr>
		    <td>编号</td>
			<td>课程名称</td>
			<td>缺勤学生</td>
			<td>缺勤时间</td>
			<td>操作</td>
		</tr>
		<%-- jsp尽量不要调用service或者dao对象, 应该从request里取出对象 --%>
		<%
			//FundDao fundDao=new FundDaoJDBCImpl();
			//List<Fund> funds=fundDao.findAll();
			PageBean pageBean = (PageBean) request.getAttribute("pageBean"); //important!
		%>

		
		<s:iterator value="#request.pageBean.data" var="f" status="st">
		<tr>
			<td><s:property value="#f.id"/></td>
			<td><s:property value="#f.course"/></td>
			<td><s:property value="#f.studentid"/></td>
			<td><s:property value="#f.date"/></td>
			<td><a href="update_classChuqin.action?id=<s:property value='#f.id'/>">修改</a> 
			<a href="delete_classChuqin.action?id=<s:property value='#f.id'/>">删除</a></td>
		</tr>
	</s:iterator>
		
	</table>

	
	<form name="PageForm" action="show_classChuqin.action" method="post">
					<%@ include file="../common/page.jsp"%>
					
	</form>
</body>
</html>