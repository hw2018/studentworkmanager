<%@page import="org.apache.struts2.components.Else"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
<%@page import="java.util.List,unp.student.work.manager.domain.GroupMoney" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>社团资金流动页面</title>
<%@ include file="../common/cssjs.inc"%>
</head>
<body>
<h1 align="center">社团资金流动表</h1>
	<table>
		<tr>
			<td>社团编号</td>
			<td>金额</td>
			<td>用途</td>
			<td>备注</td>
		</tr>
		<%
		Integer qx = (Integer)session.getAttribute("qx");
		List<GroupMoney> groupMoneys=(List<GroupMoney>)request.getAttribute("groupMoneys");
		for(GroupMoney groupMoney : groupMoneys){%>
		<tr>
			<td><%=groupMoney.getGroupId() %></td>
			<td><%=groupMoney.getMoney() %></td>
			<%if(groupMoney.isMoneyIn()==true){%>
			<td><%="进账" %></td>
			<%}if(groupMoney.isMoneyIn()==false){%>
			<td><%="支出" %></td>
			<%} %>
			<td><%=groupMoney.getText() %></td>
		</tr>
		<%}%>
		</table>
<p>总剩余金额：<%=request.getAttribute("totalmoney") %></p>
<%if(qx == 1) {%>
<h1><a href="GroupMoney?type=2&id=<%=request.getParameter("id")%>" target="dmMain">添加</a></h1>
<%} %>
</body>
</html>