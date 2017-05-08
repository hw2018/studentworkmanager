<%@page import="unp.student.work.manager.utils.PageBean"%>
<%@page import="unp.student.work.manager.model.late_info" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!--定义基准路径  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/common/cssjs.inc"%>
</head>
<body>
	<h1 align="center">晚点情况</h1>
	<table>
		<tr>
			<td>晚点编号</td>
			<td>晚点缺勤人数</td>
			<td>晚点时间</td>
			<td>晚点负责人</td>
		</tr>
		<%-- jsp尽量不要调用service或者dao对象, 应该从request里取出对象 --%>
		<tbody>
	<c:forEach var="item" items="${pageBean.data}">
	
		<tr>
			<td><a href="lateinfo/info_lateinfo.action?id=${item.id }">${item.id }</a></td>
			<td><a href="lateinfo/info_lateinfo.action?id=${item.id }">${item.num }</a></td>
			<td><a href="lateinfo/info_lateinfo.action?id=${item.id }">${item.time }</a></td>
			
			<td><a href="lateinfo/info_lateinfo.action?id=${item.id }">${item.personInfo.studentid }</a></td>
			<td><a href="lateinfo/info_lateinfo.action?id=${item.id }"> 修改</a></td>
			<td><a href="lateinfo/delete_lateinfo.action?id=${item.id }"> 删除</a></td>
			
		</tr>
	</c:forEach>
	</tbody>

	</table>
<a href="work/late/late_add.jsp">新增</a>
<br>
  <form name="PageForm" action="lateinfo/show_lateinfo.action" method="post">
			<a id="last" name="pageNum" href="lateinfo/show_lateinfo.action?pageno=${pageBean.curPage-1 }">上一页</a>
			<a href="#">${pageBean.curPage}......</a>
			<a href="#">${pageBean.maxPage}</a>
			<a id="next" name="pageNum" href="lateinfo/show_lateinfo.action?pageno=${pageBean.curPage+1 }">下一页</a>
			去第<input type="text"  name="pageno"/>页
			<input type="submit"  vlue="确定"/>
			
				<script type="text/javascript">
				
				  if(${pageBean.curPage}<=1){
				 var lastbutton=document.getElementById('last');
				 lastbutton.style.visibility="hidden";
				 }
				  if(${pageBean.curPage}>=${pageBean.maxPage}){
				 var nextbutton=document.getElementById('next');
				 nextbutton.style.visibility="hidden";
				  }				  
							/*function change(){
				var serach=document.getElementById("search_method").value;
				if(search=="2"){
				document.getElementById("form").innerHTML="~<input Id="to"  type="text" name="search_value_to"/>"
				}
				}*/
				</script>
		</form>
</body>
</html>
