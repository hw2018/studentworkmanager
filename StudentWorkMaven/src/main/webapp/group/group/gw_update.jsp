<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
<%@page import="java.util.List,unp.student.work.manager.domain.GroupWork" %>
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
<title>社团值班修改页面</title>
<%@ include file="../common/cssjs.inc"%>
</head>
<body>
	<div class="content-box-header">
		<h3>社团值班表编辑</h3>
	</div>
	<table>
	<%Integer gid = Integer.valueOf(request.getParameter("id")); 
	%>
	<%!	
	String place;
	String stuno; 
	GroupWork groupWork = new GroupWork();%>
		<tr>
			<td>     </td>
			<td>星期一</td>
			<td>星期二</td>
			<td>星期三</td>
			<td>星期四</td>
			<td>星期五</td>
			<td>星期六</td>
			<td>星期日</td>
		</tr>
		
		<tr>
			<td>8:00-10:00</td>
			<td><form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork11")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork11");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="11"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork21")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork21");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="21"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork31")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork31");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="31"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork41")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork41");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="41"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td><form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork51")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork51");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="51"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork61")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork61");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="61"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork71")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork71");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="71"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
		</tr>
		
		<tr>
			<td>10:00-12:00</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork12")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork12");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="12"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork22")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork22");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="22"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork32")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork32");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="32"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork42")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork42");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="42"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork52")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork52");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="52"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork62")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork62");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="62"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
			<td>
			<form name="form1" action="group/updateGroupWork.action?type=1" method="post"
			onSubmit="return checkNull()">
			<%if(request.getAttribute("groupWork72")!=null)
				{
				groupWork=(GroupWork) request.getAttribute("groupWork72");
				place = groupWork.getPlace();
				stuno = groupWork.getStuno();%>
				<input class="text-input large-input" type="hidden" name="groupWork.id" value="<%=groupWork.getId()%>"/>
				<% 
				}%>
			<p>
				值班地点：<input class="text-input large-input" type="text"
					name="groupWork.place" value="<%= place %>"></input>
			</p>
			<p>
				值班人员：<input class="text-input large-input" type="text"
					name="groupWork.stuno" value="<%= stuno %>"></input>
			</p>
			<input class="text-input large-input" type="hidden" name="groupWork.groupId" value="<%=gid%>"/>
			<input class="text-input large-input" type="hidden" name="groupWork.time" value="72"/>
						
			<p>
				<input class="button" type="submit" value="修改" /> 
			</p>
			</form>
			</td>
		</tr>
		
		<tr>
			<td>14:00-16:00</td>
			<td>星期一</td>
			<td>星期二</td>
			<td>星期三</td>
			<td>星期四</td>
			<td>星期五</td>
			<td>星期六</td>
			<td>星期日</td>
		</tr>
		
		<tr>
			<td>16:00-18:00</td>
			<td>星期一</td>
			<td>星期二</td>
			<td>星期三</td>
			<td>星期四</td>
			<td>星期五</td>
			<td>星期六</td>
			<td>星期日</td>
		</tr>
		
		<tr>
			<td>19:00-21:00</td>
			<td>星期一</td>
			<td>星期二</td>
			<td>星期三</td>
			<td>星期四</td>
			<td>星期五</td>
			<td>星期六</td>
			<td>星期日</td>
		</tr>
	</table>
</body>
</html>