<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!--定义基准路径  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增记录信息页面</title>
<%@ include file="../../common/cssjs.inc"%>
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
	<div class="content-box-header">
		<h3>新增记录信息</h3>
	</div>
	<div class="content-box-content">
		<form name="form1" action="dorm/recordManage/addRecord.action" method="post"
			onSubmit="return checkNull()">
			
			<p>
				宿舍号：<input class="text-input medium-input" type="text"
					name="dormrecord.dormId" />
			</p>
			<p>
				记录种类：<input class="text-input medium-input" type="text"
					name="dormrecord.sort" />
			</p>
			<p>
				内容：
				<textarea class="text-input textarea" rows="16" cols="50"
					name="dormrecord.content"></textarea>
			</p>
			<!-- 
			 <p>
				基金状态： <input type="radio" name="fund.status" value="Y" checked />可交易
				<input type="radio" name="fund.status" value="N" />不可交易
			</p>
			-->
			<p>
				<input class="button" type="submit" value="新增" /> <input
					class="button" type="reset" value="取消" />
			</p>
		</form>
	</div>

</body>
</html>