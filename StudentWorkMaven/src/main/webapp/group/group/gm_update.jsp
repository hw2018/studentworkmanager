<%@page import="unp.student.work.manager.domain.GroupMeeting"%>
<%@page import="unp.student.work.manager.utils.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
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
<title>社团会议更新页面</title>
<%@ include file="../common/cssjs.inc"%>
</head>
<body>
	<% 
	GroupMeeting groupMeeting = (GroupMeeting) request.getAttribute("groupMeeting");
	%>
	<div class="content-box-header">
		<h3>更新会议信息</h3>
	</div>
	<div class="content-box-content">
		<form name="form1" action="group/updateGroupMeeting.action?type=1" method="post"
			onSubmit="return checkNull()">
			<p>
				会议名称：<input class="text-input large-input" type="text"
					name="groupMeeting.name" value="<%=groupMeeting.getName()%>"></input>
			</p>
			<p>
				会议时间：<input class="text-input large-input" type="text"
					name="groupMeeting.startTime" value="<%=groupMeeting.getStartTime()%>"></input>
			</p>
			<p>
				会议记录：
				<textarea class="text-input textarea"  rows="16" cols="50"
					name="groupMeeting.text" ><%=groupMeeting.getText()%></textarea>
			</p>
			<input class="text-input large-input" type="hidden" name="groupMeeting.id" value="<%=groupMeeting.getId()%>"/>
			<input class="text-input large-input" type="hidden" name="groupMeeting.groupId" value="<%=groupMeeting.getGroupId()%>"/>
			<input class="text-input large-input" type="hidden" name="groupMeeting.st" value="<%=groupMeeting.getSt()%>"/>
			<p>
				<input class="button" type="submit" value="修改" /> 
				<input class="button" type="reset" value="取消" />
			</p>
		</form>
	</div>
</body>
</html>