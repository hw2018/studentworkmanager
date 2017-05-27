﻿<%@ page language="java" import="
java.sql.*,
java.net.*,
java.util.List,
java.util.Iterator,
unp.student.work.manager.domain.PersonMailAccount,
unp.student.work.manager.dao.PersonMailAccountPageDao,
org.springframework.context.ApplicationContext,
org.springframework.context.support.ClassPathXmlApplicationContext,
org.hibernate.Session,org.hibernate.Query" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>

<style type="text/css">
td.top{font-size:20px;font-weight:bold;border:thin dashed grey;text-align:center;line-height:30px;}
td.content{font-size:20px;border:thin dashed grey;text-align:center;line-height:30px;}
td.bottom{border:none;font-size:20px;}
html{overflow-x:hidden;}
table{	border-collapse:collapse;   //使得表格间距为0	}
a{text-decoration:NONE;color:black;}
input{background-color:ebf2fb;border:thin solid black;}
textarea{background-color:ebf2fb;border:thin solid black;}
</style>

<script type="text/javascript">
function fun1(id,address,account,password,remark)
{
	//alert(id);
	//alert(name);  //已检测到值传递过来
	//alert(url);
	document.getElementById("modify").style.display = "block";
	document.getElementById("modifyid").value = id;
	document.getElementById("modifyaddress").value = address;
	document.getElementById("modifyaccount").value = account;
	document.getElementById("modifypassword").value = password;
	document.getElementById("modifyremark").value = remark;
	
	document.getElementById("modifyid").readonly="true";
}

function cancel1()  //命名竟然不能是close，好像是保留字
{
	document.getElementById("modify").style.display = "none";
}


</script>
</head>
<body style="background-color:dee6f2">


<!--带关闭按钮的div修改弹窗-->
<div align="center" id="modify" style="display:none;font-height:20px;;color:dddcdc;position:fixed ;margin:auto;left:0px;right:0px;top:0px;bottom:0px;height:300px;width:500px;background-color:4d4c4c;z-index:3;border:thin solid green;"><br/>
<br/>
<form method="post" action="<%=basePath%>person/modifyMailAccount.action">
<input id="" name="studentid" type="hidden" value="<%=session.getAttribute("studentid")%>"/> <!-- 隐藏域用于传递session中的studentid信息到Action -->
<lable style="line-height:30px;">ID：&#12288<input onfocus=this.blur() type="text" id = "modifyid" name="id" maxlength="50" size="50"/></lable><br/>  
<lable style="line-height:30px;">邮箱：<input type="text" id = "modifyaddress" name="address" maxlength="50" size="50"/></lable><br/>  
<lable style="line-height:30px;">账号：<input type="text" id = "modifyaccount" name="account" maxlength="100" size="50" /></lable><br/>
<lable style="line-height:30px;">密码：<input type="text" id = "modifypassword" name="password" maxlength="50" size="50"/></lable><br/>  
<lable style="line-height:30px;">备注：<input type="text" id = "modifyremark" name="remark" maxlength="50" size="50"/></lable><br/><br/>
<input style="cursor:pointer;" type="submit" value="更新"/>&#12288&#12288
<input onclick="cancel1()" style="cursor:pointer;" type="button" value="取消"/>  
</form>

</div>


<h2 align="left">添加邮箱账号：&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288<a href="<%=basePath%>person/person/person_mail_write.jsp" target=dmMain><input type="button" value="写邮件"/></a></h2>
<form name="form1" method="post" onsubmit="" action="<%=basePath%>person/addMailAccount.action" style="padding:15px;border:thin dashed black;">
<input id="" name="studentid" type="hidden" value="<%=session.getAttribute("studentid")%>"/> <!-- 隐藏域用于传递session中的studentid信息到Action -->
<table><tr>
<td>
<div>邮箱地址：<input onblur="if(this.value.replace(/^ +| +$/g,'')=='' || this.value.length!=0 && this.value.match(/^(.+)@(.+)$/)==null )alert('电子邮件不符合规范!')" class="text-input medium-input" name="address" id="name1" type="text" maxlength="100" size="30" /></div><br/>
<div>账号名称：<input onblur="if(this.value.replace(/^ +| +$/g,'')=='')alert('账号不能为空!')" class="text-input medium-input" name="account" id ="name2" type="text" maxlength="100" size="30"/></div><br/>
<div>账号密码：<input onblur="if(this.value.replace(/^ +| +$/g,'')=='')alert('密码不能为空!')" class="text-input medium-input" name="password" id ="password" type="text" maxlength="30" size="30"/></div>
</td>

<td>
<div>&#12288&#12288账号备注：&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288<input type="submit" value="添加"/>&#12288&#12288<input type="reset" value="取消"/></div>  <br/>  
<div>&#12288&#12288<textarea class="text-input textarea" name="remark" id="remark" rows="4" cols="55"></textarea></div>
</td>

</tr></table>
</form>


<h2 align="left"  style="padding:10px;margin-bottom:5px;">邮箱账号列表：</h2>


<%!
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml"); 
public PersonMailAccountPageDao personMailAccountPageDao = (PersonMailAccountPageDao)ctx.getBean("personMailAccountPageDao");
public int pageSize;  //用来保存每一页的行数
public int pageCount;	//用来保存页数
public int curPage; 
public PersonMailAccount personMailAccount;
%>

<%
String studentid = (String)session.getAttribute("studentid"); //获取当前用户的studentid

personMailAccountPageDao.initialize(studentid);
pageSize = personMailAccountPageDao.getPageSize();  //设置每一页的行数
pageCount = personMailAccountPageDao.getPageCount();	//用来保存页数

String temp1=request.getParameter("curPage");   //当用户点击首页/上一页/下一页/尾页时传递过来的curPage信息
if(pageCount==0) 
	curPage=0;
else if(temp1==null)									//初始时curPage为null,所以设置curPage=1
	curPage=1;
else
{
	curPage=Integer.parseInt(temp1);  //将字符串temp1装华为整数
	if(curPage>pageCount)
		curPage=pageCount;
	if(curPage<1)
		curPage=1;
}

List<PersonMailAccount> personMailAccounts = personMailAccountPageDao.getPageResult(curPage,studentid);
if(personMailAccounts!=null)   //因为一开始可能数据库里没有数据，那么即使传递一个不存在的curPage，它也会查找，结果返回null
{
Iterator it = personMailAccounts.iterator();
%>

<table style="width:100%;">
<tr style="background-color:c6ceda;">
<td class="top" style="width:5%;">ID</td>
<td class="top" style="width:15%;">地址</td>
<td class="top" style="width:15%;">账号</td>
<td class="top" style="width:15%;">密码</td>
<td class="top" style="width:35%;">备注</td>
<td class="top" style="width:15%;">操作</td>
</tr>

<% 
do 
{
personMailAccount = (PersonMailAccount)it.next();  //初始时Iterator的指针指向第一个元素之前，第一个next操作使得它指向第一个元素 
%>
<tr>
<td class="content" style="width:5%;"><%=personMailAccount.getId()%></td>
<td class="content" style="width:15%;"><%=personMailAccount.getAddress()%></td>
<td class="content" style="width:15%;"><%=personMailAccount.getAccount()%></td>
<td class="content" style="width:15%;"><%=personMailAccount.getPassword()%></td>
<td class="content" style="width:35%;"><%=personMailAccount.getRemark()%></td>
<td class="content" style="width:15%;"><a onclick="fun1('<%=personMailAccount.getId()%>','<%=personMailAccount.getAddress()%>','<%=personMailAccount.getAccount()%>','<%=personMailAccount.getPassword()%>','<%=personMailAccount.getRemark()%>')" style="cursor:pointer;">修改&#160|&#160
</a><a href="<%=basePath%>person/deleteMailAccount?id=<%=personMailAccount.getId()%>">删除</a></td>
</tr>
<%}
while(it.hasNext());
%>
</table>
<br/>
<%}%>

<table align="center">
<tr><td></td></tr>
<tr>
<td></td>
<td></td>
<td class="bottom"><a href="<%=basePath%>person/person/person_mail_account.jsp?curPage=1">首页&nbsp|</a></td> 
<td class="bottom"><a href="<%=basePath%>person/person/person_mail_account.jsp?curPage=<%=curPage-1%>">&nbsp上一页&nbsp|&nbsp</a></td> 
<td class="bottom">第<%=curPage%>页/</td> 
<td class="bottom">共<%=pageCount%>页</td>
<td class="bottom"><a href="<%=basePath%>person/person/person_mail_account.jsp?curPage=<%=curPage+1%>">&nbsp|&nbsp下一页</a></td> 
<td class="bottom"><a href="<%=basePath%>person/person/person_mail_account.jsp?curPage=<%=pageCount%>">&nbsp|&nbsp尾页</a></td> 
<td ></td>
<td></td>
</tr>
</table>

</body>
</html>
























