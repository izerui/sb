<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理登入</title>
<link href="admin/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="admin/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="admin/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->


<link rel="stylesheet" href="admin/assets/css/ace.min.css" />
<link rel="stylesheet" href="admin/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="admin/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="admin/css/base.css" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="admin/platform/assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="admin/assets/js/ace-extra.min.js"></script>
<script src="admin/assets/js/jquery-2.0.3.min.js"></script>
<!-- <![endif]-->

<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='admin/assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
		</script>
		<![endif]-->

<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='admin/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
<script src="admin/assets/js/bootstrap.min.js"></script>

<script type="text/javascript">
	var contextPath='<%=contextPath%>';
</script>
<script language="javascript">
	if (top != window)
		top.location.href = window.location.href;
</script>
<script type="text/javascript" src="js/MSIE.PNG.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background: #fff;
}

.loginBox {
	width: 500px;
	height: 300px;
	padding: 0 30px;
	border: 1px solid #fff;
	color: #000;
	margin-top: 30px;
	border-radius: 8px;
	background: white;
	box-shadow: 0 0 15px #222;
	background: -moz-linear-gradient(top, #fff, #efefef 8%);
	background: -webkit-gradient(linear, 0 0, 0 100%, from(#f6f6f6),
		to(#f4f4f4) );
	font: 11px/1.5em 'Microsoft YaHei';
	position: absolute;
	left: 45%;
	top: 45%;
	margin-left: -210px;
	margin-top: -115px;
}

.loginBox h2 {
	height: 45px;
	font-size: 20px;
	font-weight: normal;
}

.loginBox .left {
	border-right: 1px solid #ccc;
	height: 100%;
	padding-right: 20px;
}

.error {
	display: none;
}
</style>

</head>
<body>
	<div class="popover"
		style="width: 150px; position: absolute; left: 45%;">
		<div class="arrow"></div>
		<div class="popover-inner">
			<h3 class="popover-title">操作提示</h3>
			<div class="popover-content" id="popover-content">
				<p>操作成功</p>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="loginBox">
				<div class="col-md-7">
					<h3>后台登录</h3>
					<form class="form-horizontal" role="form" id="form1">
						<div class="form-group">
							<input type="text" name="loginName" id="loginName"
								class="col-xs-9" style="border-radius: 4px !important;"
								placeholder="请输入用户名" /><label class="error"
								style="padding-left: 5px; color: red"> *</label>
						</div>
						<div class="form-group">
							<input type="password" name="password" id="password"
								class="col-xs-9" style="border-radius: 4px !important;"
								placeholder="请输入密码" /><label class="error"
								style="padding-left: 5px; color: red"> *</label>
						</div>
						<div class="form-group">
							<input type="button" id="login" value=" 登录 "
								class="btn btn-primary" />
						</div>
					</form>
				</div>
				<div class="col-md-5" style="text-align: left;">
					<h3>关于我们</h3>
					<p style="font-size: 13px; line-height: 22px;"></p>
				</div>
			</div>
			<!-- /loginBox -->
		</div>
	</div>
	<!-- /container -->
	<div id="loading"
		style="width:32px;height:32px;position:absolute;left:40%;top:40%;display:none;">
		<img src="/static/assets//css/images/loading.gif"
			width="32" height="32" />
	</div>
</body>
<script>
	$("#login").bind("click", function() {
		if (checkInput()) {
			return;
		}

		$.ajax({
			timeout : 2000,// 请求超时时间（毫秒）
			type : "POST",
			data : {
				"username" : $("#loginName").val(),
				"password" : $("#password").val()
			},
			async : false,// 同步
			dataType : "json",// 返回json格式的数据
			beforeSend : function() {
				showLoader();
			},
			complete : function() {
				hideLoader();
			},
			url : contextPath + "/admin/login",
			success : function(json) {
				if (json.success) {
					window.location.href=contextPath + "/index.jsp";
				} else {
					showMessage(json.msg);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				showMessage("异常信息：" + textStatus);
			}
		});

	});

	function checkInput() {
		var index = 0;
		var loginName = $("#loginName");
		if (loginName.val() == "") {
			showMessage("请输入登录账户");
			index++;
			$(this).next().show();
		}
		var password = $("#password");
		if (password.val() == "") {
			showMessage("请输入密码!!");
			index++;
			$(this).next().show();
		}
		if (index > 0) {
			return true;
		} else {
			return false;
		}

	}

	function showLoader() {
		$("#loading").show();
	}

	function hideLoader() {
		$("#loading").hide();
	}

	function showMessage(content) {
		$('#popover-content').text(content);
		$('.popover').slideDown();
		setTimeout(function() {
			$('.popover').slideUp();
		}, 2000);
	}
</script>
</html>