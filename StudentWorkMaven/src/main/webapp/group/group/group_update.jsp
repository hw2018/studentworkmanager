<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unp.student.work.manager.domain.Group"%>
<%@ include file="../common/head.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!--定义基准路径  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add fund</title>
<%@ include file="../common/cssjs.inc"%>
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
</head>
<body>
	<%
		Group group = (Group) request.getAttribute("group");
	%>
	<div class="content-box-header">
		<h3>更新社团信息</h3>
	</div>
	<div class="content-box-content">
		<form name="form1" action="group/updateGroup.action" method="post"
			onSubmit="return checkNull()">
			<p>
				社团名字：<input class="text-input large-input" type="text"
					name="group.name" value="<%=group.getName()%>"></input>
			</p>
			<p>
				社团负责人：
				<input class="text-input large-input" type="text"
					name="group.res" value="<%=group.getRes()%>"></input>
			</p>
			<p>
				社团描述：
				<textarea class="text-input textarea" rows="16" cols="50"
					name="group.description" ><%=group.getDescription()%></textarea>
			</p>
			<input type="hidden" name="group.id" value="<%=group.getId()%>" />
			<input type="hidden" name="group.createTime" value="<%=group.getCreateTime()%>" />
			<p>
				<input class="button" type="submit" value="修改" /> <input
					class="button" type="reset" value="取消" />
			</p>
		</form>
	</div>

</body>
</html>