<%@page import="unp.student.work.manager.domain.late_info" %>
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
	<h1 align="center">晚点信息</h1>
	<table>
		<tr>
			<td>缺勤人学号</td>
			<td>缺勤人姓名</td>
		</tr>
		<%-- jsp尽量不要调用service或者dao对象, 应该从request里取出对象 --%>
		<tbody>
	<c:forEach var="item" items="${pageBean.data}">
	
		<tr>
			<td><a>${item.personInfo.studentid }</a></td>
		 	<td><a>${item.personInfo.name }</a></td>
			
			<td class="delete"><a name="delete" href="lateinfo/deleteinfo_lateinfo.action?latepersonid=${item.id }&id=${item.late_info.id}"> 删除</a></td>
			
		</tr>
	</c:forEach>
	</tbody>

	</table>
<a id="add" href="work/late/late_info_add.jsp?lateinfoid=${lateinfo.id}">新增</a>


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
				  
				   
				  var quanxian="${sessionScope.quanxian}";	 
				 if(quanxian.charAt(2)!='1'){
				  var add=document.getElementById('add');
				  add.style.display="none";
				  var delete1=document.getElementsByClassName('delete');
				  for(var i=0;i<delete1.length;i++){
				  delete1[i].style.display="none";
				  }
				  }		  
				  
				  var studentid="${sessionScope.user}";
				  var persons=document.getElementsByName('studentid');
				  for(var i=0;i<persons.length;i++){
				  	if(persons[i].id!=studentid){
				  	persons[i].style.visibility="hidden";
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

