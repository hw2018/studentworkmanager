<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!--定义基准路径  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/common/cssjs.inc"%>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
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
		<h3>晚点申诉</h3>
	</div>
	<div class="content-box-content">
		<form name="form1" action="lateinfo/applyinfo_lateinfo.action?latepersonid=${param.latepersonid }&studentid=${param.studentid }&id=${param.id}" method="post"
			onSubmit="return checkNull()">
			
				申诉理由：
				<textarea class="text-input textarea" rows="16" cols="50"
					name="reason"></textarea>
			</p>
			
			<p>
				<input class="button" type="submit" value="新增" /> <input
					class="button" type="reset" value="取消" />
			</p>
		</form>
	</div>

</body>
</html>