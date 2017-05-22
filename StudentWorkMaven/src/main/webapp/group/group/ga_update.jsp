<%@page import="unp.student.work.manager.domain.GroupAct"%>
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
<title>社团活动修改页面</title>
<%@ include file="../common/cssjs.inc"%>
</head>
<body>
<% 
	GroupAct groupAct = (GroupAct) request.getAttribute("groupAct");
	%>
	<div class="content-box-header">
		<h3>更新活动信息</h3>
	</div>
	<div class="content-box-content">
		<form name="form1" action="group/updateGroupAct.action?type=1" method="post"
			onSubmit="return checkNull()">
			<p>
				活动名称：<input class="text-input large-input" type="text"
					name="groupAct.name" value="<%= groupAct.getName()%>"></input>
			</p>
			<p>
				活动时间：<input class="text-input large-input" type="text"
					name="groupAct.actTime" value="<%= groupAct.getActTime()%>"></input>
			</p>
			<p>
				活动记录：
				<textarea class="text-input textarea"  rows="16" cols="50"
					name="groupAct.text" ><%=groupAct.getText()%></textarea>
			</p>
			<input class="text-input large-input" type="hidden" name="groupAct.id" value="<%=groupAct.getId()%>"/>
			<input class="text-input large-input" type="hidden" name="groupAct.groupId" value="<%=groupAct.getGroupId()%>"/>
			<input class="text-input large-input" type="hidden" name="groupAct.st" value="<%=groupAct.getSt()%>"/>
			<p>
				<input class="button" type="submit" value="修改" /> 
				<input class="button" type="reset" value="取消" />
			</p>
		</form>
	</div>

</body>
</html>