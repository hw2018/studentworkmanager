<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>基金交易系统</title>
<%@ include file="../common/cssjs.inc"%>
<script type="text/javascript">
	$(function() {
		var a = $("#main-nav a");
		var menu = $("#main-nav li ul a");
		menu.click(function() {
			for (var j = 0; j < a.size(); j++) {
				a.eq(j).removeClass("current");
			}
			$(this).parent().parent().parent().find('a').addClass("current");

			for (var i = 0; i < menu.size(); i++) {
				menu.eq(i).removeClass("current");
			}
			$(this).addClass("current");
		});
	})
</script>
</head>
<body class="left">

	<div id="body-wrapper">
		<div id="sidebar"
			style="background: url('../images/bg-sidebar.gif') top left no-repeat;">
			<div id="sidebar-wrapper">
				<h1 id="sidebar-title">
					<a href="" target="dmMain">基金交易平台</a>
				</h1>
				<div id="profile-links">
					<p>
						<a>欢迎您${sessionScope.user}! <br></a> <a href="" title="密码修改" target="dmMain">密码修改
						</a>| <a href="user/logoutUser.action" title="退出系统" target="_top">退出</a>
					
					</p>
				</div>

				<ul id="main-nav">
					<!-- Accordion Menu -->
					<li><a href="#" class="nav-top-item"> <!-- Add the class "no-submenu" to menu items with no sub menu -->
							基金产品管理
					</a>
						<ul>
							<li><a href="fund/fund_add.action" target="dmMain">新增基金产品</a></li>
							<li><a href="fund/showFund.action" target="dmMain">基金产品查询</a></li>
						</ul></li>
					<li><a href="#" class="nav-top-item"> <!-- Add the class "no-submenu" to menu items with no sub menu -->
							客户信息管理
					</a>
						<ul>
							<li><a href="" target="dmMain">新客户开户</a></li>
							<li><a href="" target="dmMain">客户信息列表</a></li>
						</ul></li>

					<li><a href="#" class="nav-top-item current"> <!-- Add the class "no-submenu" to menu items with no sub menu -->
							资金帐户管理
					</a>
						<ul>
							<li><a href="" target="dmMain">新增资金帐户</a></li>
							<li><a href="" target="dmMain">资金帐户查询</a></li>
							<li><a href="" target="dmMain">追加帐户资金</a></li>
							<li><a href="" target="dmMain">取出帐户资金</a></li>
						</ul></li>
					<li><a href="#" class="nav-top-item current" >工作管理</a>
						<ul>
							<li><a href="#" class="nav-top-item current">晚点管理</a>
								<ul>
									<li><a href="lateinfo/show_lateinfo.action" target="dmMain">晚点信息</a></li>
									<li><a href="lateinfo/showapply_lateinfo.action" target="dmMain">晚点申诉</a></li>
								</ul>
							</li>
							<li><a href="#" class="nav-top-item current">综测管理</a>
								<ul>
									<li><a href="comprehensive/show_comprehensive.action" target="dmMain">综测信息</a></li>
									<li><a href="comprehensive/applyshow_comprehensive.action" target="dmMain">综测申诉</a></li>
								</ul>
							</li>
							<li><a href="counsellor/get_counsellor.action" target="dmMain">辅导员评价</a></li>
							<li><a href="" target="dmMain">社会经历</a></li>
						</ul></li>
				</ul>
				<!-- End #main-nav -->
			</div>
		</div>
		<!-- End #sidebar -->
	</div>
</body>
</html>
