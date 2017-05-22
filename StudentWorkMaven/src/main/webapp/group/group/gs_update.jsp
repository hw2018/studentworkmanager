<%@page import="unp.student.work.manager.utils.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
<%@page import="java.util.List,unp.student.work.manager.domain.GStudent" %>
<%@page import="unp.student.work.manager.dao.GStudentDao" %>
<%@page import="unp.student.work.manager.dao.impl.GStudentDaoImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="javascript">
	function checkNull() {
		/*判断是否有空内容*/
		for (i = 0; i < form1.length; i++) {
			if (form1.elements[i].value == "") {
				alert(form1.elements[i].title + "不能为空!");
				form1.elements[i].focus();
				return false;
			}
		}
	}
</script>
<title>更新社团成员信息</title>
<%@ include file="../common/cssjs.inc"%>
</head>
<body>
<%
		GStudent gStudent = (GStudent) request.getAttribute("gStudent");
	%>
	<div class="content-box-header">
		<h3>更新成员信息</h3>
	</div>
	<div class="content-box-content">
		<form name="form1" action="group/updateGStudent.action?type=1" method="post"
			onSubmit="return checkNull()">
			<p>
				社团名字：<input class="text-input large-input" type="text"
					name="groupStudent.groupId" value="<%=gStudent.getGroupId()%>" readonly></input>
			</p>
			<p>
				成员姓名：<input class="text-input large-input" type="text"
					name="groupStudent.stuno" value="<%=gStudent.getStuno()%>"></input>
			</p>
			<p>
				成员职务：
				<input class="text-input large-input" type="text"
					name="groupStudent.job" value="<%=gStudent.getJob()%>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupStudent.id" value="<%=gStudent.getId()%>">
			</input>
			<p>
				<input class="button" type="submit" value="修改" /> <input
					class="button" type="reset" value="取消" />
			</p>
		</form>
	</div>

</body>
</html>