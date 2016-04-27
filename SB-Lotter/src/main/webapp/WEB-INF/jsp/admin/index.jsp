<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String contextPath = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台</title>
<link href="/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
	<link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
<![endif]-->
<link rel="stylesheet" href="/assets/css/ace.min.css" />
<link rel="stylesheet" href="/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="/assets/css/ace-skins.min.css" />
<!--[if lte IE 8]>
	<link rel="stylesheet" href="assets/css/ace-ie.min.css" />
<![endif]-->
<script src="/assets/js/ace-extra.min.js"></script>

<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">      
        var contextPath='<%=contextPath%>';
</script>
<script language="javascript">
	if (top != window)
		top.location.href = window.location.href;
</script>
</head>
<body>
<div class="navbar navbar-default" id="navbar">
	<script type="text/javascript">
		try {
			ace.settings.check('navbar', 'fixed')
		} catch (e) {
		}
	</script>
	<div class="navbar-container" id="navbar-container">
		<div class="navbar-header pull-left">
			<a href="#" class="navbar-brand"> <small> <i
					class="icon-leaf"></i> 欢迎你
			</small>
			</a>
			<!-- /.brand -->
		</div>
		<!-- /.navbar-header -->
		<div class="navbar-header pull-right" role="navigation">

			<ul class="nav ace-nav">
				<li class="light-blue"><a data-toggle="dropdown" href="#"
					class="dropdown-toggle"> <span class="user-info"> <small>欢迎光临,</small>
					</span> <i class="icon-caret-down"></i>
				</a>
					<ul
						class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li><a href="<%=contextPath%>/loginOut?type=0"> <i
								class="icon-off"></i> 退出
						</a></li>
					</ul></li>
			</ul>
			<!-- /.ace-nav -->
		</div>
		<!-- /.navbar-header -->
	</div>
	<!-- /.container -->
</div>
<div class="main-container" id="main-container">
	<script type="text/javascript">
		try {
			ace.settings.check('main-container', 'fixed')
		} catch (e) {
		}
	</script>
	<div class="main-container-inner">
		<a class="menu-toggler" id="menu-toggler" href="#"> <span
			class="menu-text"></span>
		</a>

		<div class="sidebar" id="sidebar">
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="nav nav-list" id="nav-list">
				<li class="active">
					<a href="index"> 
					<i class="icon-home"></i> <span class="menu-text"> 控制台 </span>
					</a>
				</li>
				<li>
					<a href="#" class="dropdown-toggle"> <i
						class="icon-user"></i> <span class="menu-text"> 会员中心 </span> <b
						class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
							<a href="user_list" class="dropdown-toggle"  target="content">
								<i class="icon-double-angle-right"></i> 会员列表
							</a>
						</li>
						<li>
							<a href="#" target="content"> 
								<i class="icon-double-angle-right"></i> 咨询回复
							</a>
						</li>
						<li>
							<a href="#" target="content"> 
								<i class="icon-double-angle-right"></i> 贵宾留言
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#" class="dropdown-toggle"> <i
						class="icon-th"></i> <span class="menu-text"> 订单管理 </span> <b
						class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-double-angle-right"></i> 订单列表
							</a>
						</li>
						<li>
							<a href="#" target="content"> 
								<i class="icon-double-angle-right"></i> 订单预约
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#" class="dropdown-toggle"> <i
						class="icon-list"></i> <span class="menu-text"> 文章管理 </span> <b
						class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
							<a href="article?id=1" class="dropdown-toggle" target="content">
								<i class="icon-double-angle-right"></i> 关于我们
							</a>
						</li>
						<li>
							<a href="article?id=2" class="dropdown-toggle" target="content">
								<i class="icon-double-angle-right"></i> 运动健身
							</a>
						</li>
						<li>
							<a href="article?id=3" class="dropdown-toggle" target="content">
								<i class="icon-double-angle-right"></i> 体检流程
							</a>
						</li>
						<li>
							<a href="article?id=4" class="dropdown-toggle" target="content">
								<i class="icon-double-angle-right"></i> 体检常识
							</a>
						</li>
						<li>
							<a href="news_list?type=1" target="content"> 
								<i class="icon-double-angle-right"></i> 新闻中心
							</a>
						</li>
						<li>
							<a href="news_list?type=2" target="content"> 
								<i class="icon-double-angle-right"></i> 健康资讯
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#" class="dropdown-toggle"> <i
						class="icon-tags"></i> <span class="menu-text"> 招聘信息 </span> <b
						class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
							<a href="recruit_list" class="dropdown-toggle"  target="content">
								<i class="icon-double-angle-right"></i> 招聘列表
							</a>
						</li>
						<li>
							<a href="recruit/recruit_edit.jsp" target="content"  target="content"> 
								<i class="icon-double-angle-right"></i> 招聘添加
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#" class="dropdown-toggle"> <i
						class="icon-tags"></i> <span class="menu-text"> 医院科室&名医管理 </span> <b
						class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
							<a href="room/room_list.jsp" class="dropdown-toggle"  target="content">
								<i class="icon-double-angle-right"></i> 科室管理
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#" class="dropdown-toggle"> <i
						class="icon-tags"></i> <span class="menu-text"> 体检套餐管理 </span> <b
						class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
							<a href="product/product_list.jsp" class="dropdown-toggle"  target="content">
								<i class="icon-double-angle-right"></i> 套餐管理
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#" class="dropdown-toggle"> <i
						class="icon-tags"></i> <span class="menu-text"> 网站轮播 </span> <b
						class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
							<a href="banner_list" class="dropdown-toggle"  target="content">
								<i class="icon-double-angle-right"></i> 轮播列表
							</a>
						</li>
						
					</ul>
				</li>
			</ul>
			<!-- /.nav-list -->
			<div class="sidebar-collapse" id="sidebar-collapse">
				<i class="icon-double-angle-left"
					data-icon1="icon-double-angle-left"
					data-icon2="icon-double-angle-right"></i>
			</div>

			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed')
				} catch (e) {
				}
			</script>
		</div>

		<div class="main-content row" style="background-color: #fff;">

			<iframe src="main" frameborder="0"
				style="height: 100%; width: 100%;" name="content"></iframe>
		</div>
		<!-- /.main-content -->
	</div>
	<!-- /.main-container-inner -->

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
</div>
<!-- /.main-container -->
<script type="text/javascript">
	window.jQuery
			|| document.write("<script src='/assets/js/jquery-2.0.3.min.js'>"
					+ "<"+"script>");
</script>
<!-- <![endif]-->
<!--[if IE]>
	<script type="text/javascript">
		 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
	</script>
<![endif]-->
<script type="text/javascript">
	if ("ontouchend" in document)
		document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>"
				+ "<"+"script>");
</script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/typeahead-bs2.min.js"></script>
<!--[if lte IE 8]>
	<script src="assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="/assets/js/jquery.slimscroll.min.js"></script>
<script src="/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="/assets/js/jquery.sparkline.min.js"></script>
<script src="/assets/js/flot/jquery.flot.min.js"></script>
<script src="/assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="/assets/js/flot/jquery.flot.resize.min.js"></script>
<script src="/js/common.js"></script>
<script src="/assets/js/ace-elements.min.js"></script>
<script src="/assets/js/ace.min.js"></script>
<script type="text/javascript">
	var height = $(window).height();
	$('.main-content').height(height - 50);
	
	$(window).resize(function(){
		var h = $(window).height();
		if(h > height){
			$('.main-content').height(h - 50);
		}
    });
</script>
</body>
</html>