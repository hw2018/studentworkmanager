﻿<%@ page language="java" import="
java.sql.*,
java.net.*,
java.util.List,
java.util.Iterator,
unp.student.work.manager.domain.PersonPersonInfo,
unp.student.work.manager.domain.PersonFinance,
unp.student.work.manager.dao.PersonFinancePageDao,
unp.student.work.manager.service.PersonFinanceService,
org.springframework.context.ApplicationContext,
org.springframework.context.support.ClassPathXmlApplicationContext,
org.hibernate.Session,org.hibernate.Query" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">   <!--定义基准路径  -->
<style type="text/css">
td.top{font-size:20px;font-weight:bold;border:thin dashed grey;text-align:center;line-height:30px;}
td.content{font-size:20px;border:thin dashed grey;text-align:center;line-height:30px;}
td.bottom{border:none;font-size:20px;}
html{overflow-x:hidden;}
table{	border-collapse:collapse;   //使得表格间距为0	}
a{text-decoration:NONE;color:black;}
input{background-color:ebf2fb;border:thin solid black;}
select{background-color:ebf2fb;border:thin solid black;}
textarea{background-color:ebf2fb;border:thin solid black;}
</style>

<script type="text/javascript">
function fun1(id,name,type,money,createtime,remark)
{
	//alert(id);
	//alert(name);  //已检测到值传递过来
	//alert(url);
	document.getElementById("modify").style.display = "block";
	document.getElementById("modifyid").value = id;
	document.getElementById("modifyname").value = name;
	document.getElementById("modifytype").value = type;
	document.getElementById("modifymoney").value = money;
	document.getElementById("modifycreatetime").value = createtime;
	document.getElementById("modifyremark").value = remark;
}

function cancel1()  //命名竟然不能是close，好像是保留字
{
	document.getElementById("modify").style.display = "none";
}


</script>


</head>
<body style="background-color:dee6f2">


<!--带关闭按钮的div修改弹窗-->
<div align="center" id="modify" style="display:none;font-height:20px;;color:dddcdc;position:fixed ;margin:auto;left:0px;right:0px;top:0px;bottom:0px;height:270px;width:500px;background-color:4d4c4c;z-index:3;border:thin solid green;"><br/>
<br/>
<form method="post" action="<%=basePath%>person/modifyFinance.action">
<lable style="line-height:30px;">编号：<input onfocus=this.blur() type="text" id = "modifyid" name="id" maxlength="50" size="50"/></lable><br/>  
<lable style="line-height:30px;">名称：<input type="text" id = "modifyname" name="name" maxlength="50" size="50"/></lable><br/>
类型：<select id="modifytype" name="type">  
<option value="income">收入</option> 
<option value="outcome">支出</option> 
<option value="borrow">借贷</option> 
</select>
&#12288;&#12288;&nbsp;
<lable style="line-height:30px;">创建时间：<input onfocus=this.blur() type="text" id = "modifycreatetime" name="createtime" maxlength="100" size="20" /></lable><br/> 
<lable style="line-height:30px;">金额：<input onblur="if(this.value.replace(/^ +| +$/g,'')=='' || this.value.replace(/[\d\.]/g,'')!='')alert('金额不符合规范!')" type="text" id = "modifymoney" name="money" maxlength="50" size="50"/></lable><br/>  
<lable style="line-height:30px;">备注：<input type="text" id = "modifyremark" name="remark" maxlength="50" size="50"/></lable><br/><br/>

<input style="cursor:pointer;" type="submit" value="更新"/>&#12288&#12288
<input onclick="cancel1()" style="cursor:pointer;" type="button" value="取消"/>  
</form>

</div>



<table>
<tr>
<td>
<h2 align="left">添加财务记录：</h2>
<form name="form1" method="post" action="<%=basePath%>person/addFinance.action"  style="padding:15px;border:thin dashed black;">
名称：<input onblur="if(this.value.replace(/^ +| +$/g,'')=='')alert('名称不能为空!')" class="text-input medium-input" name="name" id="name" type="text" maxlength="50" size="20" />&#12288&#12288
类型：
<select name="type"> 
<option value="income">收入</option> 
<option value="outcome">支出</option> 
<option value="borrow">借贷</option> 
</select>   
&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;&#12288;<input type="submit" value="添加"/>&#12288<input type="reset" value="取消"/>
<br/><br/>
金额：<input onblur="if(this.value.replace(/^ +| +$/g,'')=='' || this.value.replace(/[\d\.]/g,'')!='')alert('金额不符合规范!')" class="text-input medium-input" name="money" id ="url" type="text" maxlength="100" size="20" />&#12288&#12288
备注：<input class="text-input medium-input" name="remark" id ="url" type="text" maxlength="100" size="55" />
<br/>
</form>
</td>

<td style="width:30px;"></td>

<td>
<h2 align="left">财务统计：</h2>
<div style="border:thin dashed black;width:300px;height:88px;">
<br/>
<%
PersonFinanceService personFinanceServices = (PersonFinanceService)ctx.getBean("personFinanceService");
int []n = personFinanceServices.getStatistics((String)session.getAttribute("studentid"));
%>
&#12288;总支出：<%=n[1] %>元&#12288;&#12288;
&#12288;总借贷：<%=n[2] %>元
<br/><br/>
&#12288;总收入：<%=n[0] %>元
<br/>
</div>
</td>

</tr>
</table>




<br/><br/>
<h2 align="left">财务明细列表：</h2>

<%!
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml"); 
public PersonFinancePageDao personFinancePageDao = (PersonFinancePageDao)ctx.getBean("personFinancePageDao");
public int pageSize;  //用来保存每一页的行数
public int pageCount;	//用来保存页数
public int curPage; 
public PersonFinance personFinance;
%>

<%
String studentid = (String)session.getAttribute("studentid"); //获取当前用户的studentid

personFinancePageDao.initialize(studentid);
pageSize = personFinancePageDao.getPageSize();  //设置每一页的行数
pageCount = personFinancePageDao.getPageCount();	//用来保存页数

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

List<PersonFinance> personFinances = personFinancePageDao.getPageResult(curPage,studentid);
if(personFinances!=null)   //因为一开始可能数据库里没有数据，那么即使传递一个不存在的curPage，它也会查找，结果返回null
{
Iterator it = personFinances.iterator();
%>

<table style="width:100%;">
<tr style="background-color:c6ceda;">
<td class="top" style="width:5%;">id</td>
<td class="top" style="width:20%;">名称</td>
<td class="top" style="width:10%;">类型</td>
<td class="top" style="width:10%;">金额</td>
<td class="top" style="width:20%;">创建时间</td>
<td class="top" style="width:20%;">备注</td>
<td class="top" style="width:15%;">操作</td>
</tr>

<% 
do 
{
personFinance = (PersonFinance)it.next();  //初始时Iterator的指针指向第一个元素之前，第一个next操作使得它指向第一个元素 
%>
<tr>
<td class="content" style="width:5%;"><%=personFinance.getId()%></td>
<td class="content" style="width:20%;"><%=personFinance.getName()%></td>
<td class="content" style="width:10%;">
<%
String type = personFinance.getType();
if(type.equals("income")) out.println("收入");
else if(type.equals("outcome")) out.println("支出");
else if(type.equals("borrow")) out.println("借贷");
%>
</td>
<td class="content" style="width:10%;"><%=personFinance.getMoney()%>元</td>
<td class="content" style="width:20%;"><%=personFinance.getCreatetime()%></td>
<td class="content" style="width:20%;"><%=personFinance.getRemark()%></td>
<td class="content" style="width:15%;"><a onclick="fun1('<%=personFinance.getId()%>','<%=personFinance.getName()%>','<%=personFinance.getType()%>','<%=personFinance.getMoney()%>','<%=personFinance.getCreatetime()%>','<%=personFinance.getRemark()%>')" style="cursor:pointer;">修改&#160|&#160
</a><a href="<%=basePath%>person/deleteFinance?id=<%=personFinance.getId()%>">删除</a></td>
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
<td class="bottom"><a href="<%=basePath%>person/person/person_finance.jsp?curPage=1">首页&nbsp|</a></td> 
<td class="bottom"><a href="<%=basePath%>person/person/person_finance.jsp?curPage=<%=curPage-1%>">&nbsp上一页&nbsp|&nbsp</a></td> 
<td class="bottom">第<%=curPage%>页/</td> 
<td class="bottom">共<%=pageCount%>页</td>
<td class="bottom"><a href="<%=basePath%>person/person/person_finance.jsp?curPage=<%=curPage+1%>">&nbsp|&nbsp下一页</a></td> 
<td class="bottom"><a href="<%=basePath%>person/person/person_finance.jsp?curPage=<%=pageCount%>">&nbsp|&nbsp尾页</a></td> 
<td ></td>
<td></td>
</tr>
</table>

</body>
</html>












