<%@page import="unp.student.work.manager.domain.GroupSupport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>社团赞助详情页面</title>
<%@ include file="../common/cssjs.inc"%>
</head>
<body>
<% 
	GroupSupport groupSupport = (GroupSupport) request.getAttribute("groupSupport");
	%>
	<div class="content-box-header">
		<h3>查看赞助信息</h3>
	</div>
	<div class="content-box-content">
		<form name="form1"  method="post" >
			<p>
				赞助商：<input class="text-input large-input" type="text"
					name="groupSupport.name" value="<%=groupSupport.getName()%>" readonly></input>
			</p>
			<p>
				赞助金额：<input class="text-input large-input" type="text"
					name="groupSupport.money" value="<%=groupSupport.getMoney()%>" readonly></input>
			</p>
			<p>
				赞助备注：
				<textarea class="text-input textarea"  rows="16" cols="50"
					name="groupSupport.text" readonly><%=groupSupport.getText()%></textarea>
			</p>
			<input class="text-input large-input" type="hidden" name="groupSupport.id" value="<%=groupSupport.getId()%>"/>
			<input class="text-input large-input" type="hidden" name="groupSupport.groupId" value="<%=groupSupport.getGroupId()%>"/>
			<input class="text-input large-input" type="hidden" name="groupSupport.actId" value="<%=groupSupport.getActId()%>"/>
			<p>
				<input class="button" onclick="javascript:window.location.href='GroupSupport?type=1';" value="返回" /> 
			</p>
		</form>
	</div>


</body>
</html>