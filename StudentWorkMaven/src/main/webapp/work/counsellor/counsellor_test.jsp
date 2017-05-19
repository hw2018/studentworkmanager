<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="unp.student.work.manager.domain.counsellor" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'counsellor_select.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="counsellor/result_counsellor.action">
    <table id="InstructorJudgeStudentPointTable" style="margin-left: 12px; margin-top: 10px;">
    <tbody>
    	<tr>
    		<th style="width:20px,height:80px;">编号</th>
    		<th style="width:320px,height:80px;">题目</th>
    		<th  style="width:60px;">得分(1-4)</th>
    	</tr>
    	<c:forEach var="item" items="${problem }" varStatus="loop">
    	<tr>
    		<td>${loop.count }</td>
    		<td>${item}</td>
    		<td><input type="text" class="score" name="singlescore" value="${record[loop.count-1]}"/></td>
    	</tr>
    	</c:forEach>
    	<tr>
    		<td>总分</td>
    		<td></td>
    		<td><input type="text" id="total"/></td>
    	</tr>
   </tbody>
   </table>
   	<input id="button" type="submit" value="确定"> 
   	<input id="select" name="select"type="text" value="${teacher }"> 
   </form>
  </body>
  <script>
  			var score=document.getElementsByClassName('score');
  			var totalscore=0.0;
  
  			for(var i=0;i<score.length;i++){
				
  				if(score[i].value=="-1"){
  				//alert(score[1].value);
  				score[i].value=0;
  				}else{
  				totalscore+=parseFloat(score[i].value);
  				score[i].disabled="true";
  				}
  			}		
  			var total=document.getElementById('total');
  			total.value=totalscore;
  			total.disabled="true";
  			if(totalscore>0.0){
  			var button=document.getElementById('button');
  			button.style.display="none";
  			}
  			var seletc=document.getElementById('select');
  			select.style.display="none";
  
  </script>
</html>