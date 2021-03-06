<%@page import="unp.student.work.manager.utils.PageBean"%>
<%@page import="unp.student.work.manager.domain.comprehensive_record" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!--定义基准路径  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../common/cssjs.inc"%>
</head>
<body>
	<h1 align="center">综测情况</h1>
	<table>
		<tr>
			<td>综测编号</td>
			<td>学号</td>
			<td>姓名</td>
			<td>综测分</td>
		</tr>
		<%-- jsp尽量不要调用service或者dao对象, 应该从request里取出对象 --%>
		<tbody>
	<c:forEach var="item" items="${pageBean.data}">
	
		<tr>
			<td><a href="comprehensive/record_comprehensive.action?studentid=${item.personInfo.studentid }">${item.id }</a></td>
			<td><a href="comprehensive/record_comprehensive.action?studentid=${item.personInfo.studentid }">${item.personInfo.studentid }</a></td>
			<td><a href="comprehensive/record_comprehensive.action?studentid=${item.personInfo.studentid }">${item.personInfo.name }</a></td>
			
			<td><a href="comprehensive/record_comprehensive.action?studentid=${item.personInfo.studentid }">${item.score }</a></td>
			<td class="update"><a  name="update" href="comprehensive/get_comprehensive.action?id=${item.id }"> 修改</a></td>
			
		</tr>
	</c:forEach>
	</tbody>

	</table>
<br>
  <form name="PageForm" action="comprehensive/show_comprehensive.action" method="post">
			<a id="last" name="pageNum" href="comprehensive/show_comprehensive.action?pageno=${pageBean.curPage-1 }">上一页</a>
			<a href="#">${pageBean.curPage}......</a>
			<a href="#">${pageBean.maxPage}</a>
			<a id="next" name="pageNum" href="comprehensive/show_comprehensive.action?pageno=${pageBean.curPage+1 }">下一页</a>
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
				  
				   var quanxian="${sessionScope.quanxian}";				  
				 if(quanxian.charAt(3)!='1'){
				  var update=document.getElementsByClassName('update');
				  for(var i=0;i<update.length;i++){
				  update[i].style.display="none";
				  }
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
