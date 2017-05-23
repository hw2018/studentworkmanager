<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="unp.student.work.manager.domain.ClassActivity"%>
<%@ include file="../common/head.jsp"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
	ClassActivity classactivity = (ClassActivity) request.getAttribute("classactivity");
	%>
	<div class="content-box-header">
		<h3>更新活动信息</h3>
	</div>
	<div class="content-box-content">
		<s:form name="form1" action="save_classActivity.action" method="post"
			onSubmit="return checkNull()">
		<p>
				活动名称：<input class="text-input medium-input" type="text"
					name="classactivity.name" />
			</p>
			<p>
				申请人学号：<input class="text-input medium-input" type="text"
					name="classactivity.studentid" />
			</p>
			<p>
				活动地点：<input class="text-input medium-input" type="text"
					name="classactivity.place" />
			</p>
	
			<p>
				参与人数：<input class="text-input medium-input" type="text"
					name="classactivity.number" />
			</p>
			
			<p>
				活动时间：<input class="text-input medium-input" type="text"
					name="classactivity.date" />
			</p>
			<p>
				负责人：<input class="text-input medium-input" type="text"
					name="classactivity.master" />
			</p>
					<p>
				活动内容：				<textarea class="text-input textarea" rows="13" cols="50"
					name="classactivity.content"></textarea>
			</p>

			
			<s:hidden name="classactivity.id" />
			<p>
				<input class="button" type="submit" value="修改" /> <input
					class="button" type="reset" value="取消" />
			</p>
		</s:form>
	</div>

</body>
</html>