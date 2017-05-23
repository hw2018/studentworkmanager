<%@page import="unp.student.work.manager.utils.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
<%@page import="java.util.List,unp.student.work.manager.domain.Diningroomcomplaints"%>
<%@page import="unp.student.work.manager.dao.CampusDiningroomcomplaintsDao"%>
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
	<h1 align="center">食堂投诉记录</h1>
	<table>
		<tr>
			<td>食堂投诉编号</td>
			<td>投诉人姓名</td>
			<td>食堂名称</td>
			<td>投诉类型</td>
			<td>投诉日期</td>
			
			<td>操作</td>
		</tr>
		<%-- jsp尽量不要调用service或者dao对象, 应该从request里取出对象 --%>
		<%
			//FundDao fundDao=new FundDaoJDBCImpl();
			//List<Fund> funds=fundDao.findAll();
			PageBean pageBean = (PageBean) request.getAttribute("pageBean"); //important!
		%>
		<s:iterator value="pageBean.data" var="h" status="st">
		<tr>
			<td><s:property value="#h.id"/></td>
			<td><s:property value="#h.name"/></td>
			<td><s:property value="#h.diningroom"/></td>
			<td>
				<s:if test='#h.type=="S"'>
					食品质量
				</s:if>
				<s:if test='#h.type=="D"'>
					收费
				</s:if>
				<s:if test='#h.type=="X"'>
					其他
				</s:if>
			</td>
			<td>
			<s:date name="#h.time" format="yyyy-MM-dd"/>
			
			<td><a href="diningroomcomplaints/updateDiningroomcomplaints.action?id=<s:property value='#h.id'/>">修改</a> 
			<a href="diningroomcomplaints/deleteDiningroomcomplaints.action?id=<s:property value='#h.id'/>">删除</a></td>
		</tr>
	</s:iterator>
		
	</table>
	<form name="PageForm" action="diningroomcomplaints/showDiningroomcomplaints.action" method="post">
					<%@ include file="../common/page.jsp"%>
	</form>
</body>
</html>