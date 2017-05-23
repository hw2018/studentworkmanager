<%@page import="unp.student.work.manager.utils.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
<%@page import="java.util.List,unp.student.work.manager.domain.Equityprotect"%>
<%@page import="unp.student.work.manager.dao.CampusEquityprotectDao"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!--定义基准路径  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示列表</title>
<%@ include file="../common/cssjs.inc"%>
</head>
<body>
	<h1 align="center">权益维护记录</h1>
	<table>
		<tr>
			<td>权益维护编号</td>
			<td>申请人姓名</td>
			<td>性别</td>
			<td>权益维护类型</td>
			<td>权益维护申请日期</td>
			
			<td>操作</td>
		</tr>
		<%-- jsp尽量不要调用service或者dao对象, 应该从request里取出对象 --%>
		<%
			//FundDao fundDao=new FundDaoJDBCImpl();
			//List<Fund> funds=fundDao.findAll();
			PageBean pageBean = (PageBean) request.getAttribute("pageBean"); //important!
		%>
		<s:iterator value="pageBean.data" var="f" status="st">
		<tr>
			<td><s:property value="#f.id"/></td>
			<td><s:property value="#f.name"/></td>
			<td>
				<s:if test='#f.sex=="M"'>
					男
				</s:if>
				<s:else>
					女
				</s:else>
			</td>
			<td>
				<s:if test='#f.type=="Y"'>
					财产
				</s:if>
				<s:if test='#f.type=="N"'>
					名誉
				</s:if>
				<s:if test='#f.type=="W"'>
					其他事件
				</s:if>
			</td>
			<td>
			<s:date name="#f.starttime" format="yyyy-MM-dd"/>
			
			<td><a href="equityprotect/updateEquityprotect.action?id=<s:property value='#f.id'/>">修改</a> 
			<a href="equityprotect/deleteEquityprotect.action?id=<s:property value='#f.id'/>">删除</a></td>
		</tr>
	</s:iterator>
		
	</table>
	<form name="PageForm" action="equityprotect/showEquityprotect.action" method="post">
					<%@ include file="../common/page.jsp"%>
	</form>
</body>
</html>