<%@page import="unp.student.work.manager.domain.GroupSupport"%>
<%@page import="unp.student.work.manager.utils.PageBean"%>
<%@page import="java.util.List,unp.student.work.manager.domain.*" %>
<%@page import="unp.student.work.manager.dao.*" %>
<%@page import="unp.student.work.manager.dao.impl.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>社团赞助信息页面</title>
<%@ include file="../common/cssjs.inc"%>
</head>
<body>
<h1 align="center">赞助信息</h1>
	<table>
		<tr>
			<td>社团编号</td>
			<td>活动编号</td>
			<td>赞助商</td>
			<td>金额</td>
			<td>操作</td>
		</tr>
		<%
		Integer qx = (Integer)session.getAttribute("qx");
		List<GroupSupport> groupSupports=(List<GroupSupport>)request.getAttribute("gsupportList");
		for(GroupSupport groupSupport : groupSupports){%>
		<tr>
			<td><%=groupSupport.getGroupId() %></td>
			<td><%=groupSupport.getActId() %></td>
			<td><%=groupSupport.getName() %></td>
			<td><%=groupSupport.getMoney() %></td>
			<td>
			<%request.setAttribute("id", groupSupport.getGroupId()); %>
			<a href="GroupSupport?type=4&gsupportid=<%=groupSupport.getId() %>">查看</a> 
			<%if(qx == 1){ %>
			<a href="GroupSupport?type=2&gsupportid=<%=groupSupport.getId() %>">修改</a> 
			<%} %>
		</tr>
		<%
		}%>
	</table>
	<%if(qx == 1){ %>
	<h1><a href="GroupSupport?type=3" target="dmMain">添加</a></h1>
	<%} %>

</body>
</html>