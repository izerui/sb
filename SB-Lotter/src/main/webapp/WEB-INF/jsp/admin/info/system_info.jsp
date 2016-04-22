<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String contextPath = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站信息配置</title>
<link href="/static/css/base.css" rel="stylesheet" />
<link href="/static/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="/static/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
	<link rel="stylesheet" href="/static/assets/css/font-awesome-ie7.min.css" />
<![endif]-->
<link rel="stylesheet" href="/static/assets/css/ace.min.css" />
<link rel="stylesheet" href="/static/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="/static/assets/css/ace-skins.min.css" />
<!--[if lte IE 8]>
	<link rel="stylesheet" href="/static/assets/css/ace-ie.min.css" />
<![endif]-->
<script src="/static/assets/js/ace-extra.min.js"></script>
<!--[if lt IE 9]>
	<script src="/static/assets/js/html5shiv.js"></script>
	<script src="/static/assets/js/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" href="/static/assets/css/jquery-ui-1.10.3.custom.min.css" />
<link rel="stylesheet" href="/static/assets/css/chosen.css" />
<script src="/static/ckeditor/ckeditor.js"
	type="text/javascript"></script>
<script type="text/javascript">  
       var contextPath='<%=contextPath%>';
</script>
</head>
<body style="background-color: #fff;">
	<div class="breadcrumbs" id="breadcrumbs">
		<script type="text/javascript">
			try {
				ace.settings.check('breadcrumbs', 'fixed')
			} catch (e) {
			}
		</script>
		<ul class="breadcrumb">
			<li><i class="icon-home home-icon"></i> <a href="/static/index.jsp">首页</a>
			</li>
			<li class="active">管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				管理 <small> <i class="icon-double-angle-right"> 网站信息配置 </i>
				</small>
			</h1>
		</div>
		<!-- /.page-header -->
		<div class="row" style="height: 100%">
			<div class="col-xs-12">
				<div class="popover-inner" style="">
					<div class="popover-content" id="" style=" ">
						<form class="form-horizontal" style="padding-top: 10px;"
							method="post" id="infoForm" >
							<input type="hidden" value="1" id="id"  name="id" />
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">公司地址：</label>
								<div class="col-sm-9">
									<input name="address" id="address" class="form-control" value="" />
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">网站备案号：</label>
								<div class="col-sm-9">
									<input name="copyright" id="copyright" class="form-control" value="" />
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">联系电话：</label>
								<div class="col-sm-9">
									<input name="phone" id="phone" class="form-control" value="" />
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">客服qq：</label>
								<div class="col-sm-9">
									<input name="qq" id="qq" class="form-control" value="" />
								</div>
							</div>
						</form>
					</div>
					<div class="popover-footer"
						style="  overflow: hidden; text-align: center;">
						<button type="button" class="btn btn-danger"
							style="padding: 0px; margin: 0px 5px 5px 0px;" id="save">
							<i class="icon-edit"></i>保存
						</button>
		
					</div>
				</div>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<div id="loading"
		style="width: 32px; height: 32px; position: absolute; left: 40%; top: 40%; display: none;">
		<img src="/static/assets/css/images/loading.gif"
			width="32" height="32" />
	</div>
	<div class="popover"
		style="z-index: 9999; width: 150px; position: absolute; left: 45%; top: 45%;">
		<div class="arrow"></div>
		<div class="popover-inner">
			<h3 class="popover-title">操作提示</h3>
			<div class="popover-content" id="popover-content">
				<p>操作成功</p>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='/static/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='/static/assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"script>");
	</script>
	
	<!--[if IE]>
		<script type="text/javascript">
			window.jQuery || document.write("<script src='/static/assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
		</script>
	<![endif]-->
	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='/static/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"script>");
	</script>
	<script src="/static/assets/js/bootstrap.min.js"></script>
	<script src="/static/assets/js/typeahead-bs2.min.js"></script>

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
	<![endif]-->
	<script src="/static/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="/static/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="/static/assets/js/jquery.slimscroll.min.js"></script>
	<script src="/static/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="/static/assets/js/jquery.sparkline.min.js"></script>
	<script src="/static/assets/js/ace-elements.min.js"></script>
	<script src="/static/assets/js/ace.min.js"></script>
	<script src="/static/js/common.js"></script>
	<script src="/static/assets/js/jquery-form.js"></script>
	<script src="/static/assets/js/jquery.dataTables.bootstrap.js"></script>
	
	<script type="text/javascript">
		
		init();
		function init() {
			getData();
		}

		function getData() {
			$("#loading").show();
			$.ajax({
				url : contextPath + '/api/info',
				type : "POST",
				dataType : 'json',
				data : {
					action : 'get'
				},
				success : function(rs, textStatus, jqXHR) {
					$("#loading").hide();
					if (rs.success) {
						var data = rs.data;
						$("#id").val(data.id);						
						$("#address").val(data.address);						
						$("#copyright").val(data.copyright);						
						$("#phone").val(data.phone);	
						$("#qq").val(data.qq);	
					} else {
						showMessage("获取数据失败,请稍后再试");
					}
				},
				error : function() {
					$("#loading").hide();
					showMessage("请稍后再试");
				}
			});
		}

		$("#save").bind("click", function() {
			
			$("#infoForm").ajaxSubmit({
				type : "POST",
				url : contextPath + '/api/info?action=' + 'update',
				dataType : 'json',
				success : function(data) {
					if (data.success) {
						showMessage(data.msg);
					} else {
						showMessage(data.msg);
					}
					$("#loading").hide();
				},
				error : function(msg) {
					$("#loading").hide();
					showMessage("操作失败");
				}
			});
		});
	</script>
</body>
</html>