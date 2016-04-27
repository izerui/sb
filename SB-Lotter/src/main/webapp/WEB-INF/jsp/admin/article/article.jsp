﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String contextPath = request.getContextPath();
	String id = request.getParameter("id");
	if(id == null || "".equals(id)){
		response.getWriter().write("参数错误!!!");
		return;
	}
	String title = "";
	if("1".equals(id)){
		title ="关于我们";
	}else if("2".equals(id)){
		title ="运动健身";
	}else if("3".equals(id)){
		title ="体检流程";
	}else if("4".equals(id)){
		title ="体检常识";
	}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文章-<%=title%></title>
<link href="../css/base.css" rel="stylesheet" />
<link href="../assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="../assets/css/font-awesome.min.css" />
<!--[if IE 7]>
	<link rel="stylesheet" href="../assets/css/font-awesome-ie7.min.css" />
<![endif]-->
<link rel="stylesheet"
	href="../assets/css/ace.min.css" />
<link rel="stylesheet"
	href="../assets/css/ace-rtl.min.css" />
<link rel="stylesheet"
	href="../assets/css/ace-skins.min.css" />
<!--[if lte IE 8]>
	<link rel="stylesheet" href="../assets/css/ace-ie.min.css" />
<![endif]-->
<script src="../assets/js/ace-extra.min.js"></script>
<!--[if lt IE 9]>
	<script src="../assets/js/html5shiv.js"></script>
	<script src="../assets/js/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet"
	href="../assets/css/jquery-ui-1.10.3.custom.min.css" />
<link rel="stylesheet"
	href="../assets/css/chosen.css" />
<script src="../ckeditor/ckeditor.js"
	type="text/javascript"></script>
<script type="text/javascript">  
       var contextPath='<%=contextPath%>';
       var id='<%=id%>';
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
			<li><i class="icon-home home-icon"></i> <a
				href="../index.jsp">首页</a></li>
			<li class="active">管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				管理 <small> <i class="icon-double-angle-right"> 文章-<%=title%> </i>
				</small>
			</h1>
		</div>
		<!-- /.page-header -->
		<div class="row" style="height: 100%">
			<div class="col-xs-12">
				<div class="popover-inner" style="">
					<div class="popover-content" id="" style="">
						<form class="form-horizontal" style="padding-top: 10px;"
							method="post" id="aboutForm">
							<input type="hidden" value="<%=id%>" id="id" name="id" />
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">文章内容：</label>
								<div class="col-sm-9">
									<textarea cols="80" id="content" name="content"></textarea>
								</div>
								<span class="input_tip" style="line-height: 30px;">*</span>
							</div>
						</form>
					</div>
					<script>
						CKEDITOR.replace('content', {
							filebrowserImageBrowseUrl : 'servlet/ImageBrower.brower',
							filebrowserImageUploadUrl : 'servlet/ImageUpload.upload'
						});
					</script>
					<div class="popover-footer"
						style="overflow: hidden; text-align: center;">
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
		<img src="../assets/css/images/loading.gif"
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
					.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='../assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"script>");
	</script>

	<!--[if IE]>
		<script type="text/javascript">
			window.jQuery || document.write("<script src='../assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
		</script>
	<![endif]-->
	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"script>");
	</script>
	<script src="../assets/js/bootstrap.min.js"></script>
	<script src="../assets/js/typeahead-bs2.min.js"></script>

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
	<![endif]-->
	<script
		src="../assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script
		src="../assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="../assets/js/jquery.slimscroll.min.js"></script>
	<script
		src="../assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="../assets/js/jquery.sparkline.min.js"></script>
	<script src="../assets/js/ace-elements.min.js"></script>
	<script src="../assets/js/ace.min.js"></script>
	<script src="../js/common.js"></script>
	<script src="../assets/js/jquery-form.js"></script>
	<script
		src="../assets/js/jquery.dataTables.bootstrap.js"></script>
	<script type="text/javascript">
		
		init();
		function init() {
			getData();
		}

		function getData() {
			$("#loading").show();
			$.ajax({
				url : contextPath + '/api/article',
				type : "POST",
				dataType : 'json',
				data : {
					action : 'get',
					id : id
				},
				success : function(rs, textStatus, jqXHR) {
					$("#loading").hide();
					if (rs.success) {
						$("#id").val(rs.data.id);
						$("#content").val(rs.data.content);
						CKEDITOR.instances.content.setData(rs.data.content);
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
			var data = CKEDITOR.instances.content.getData();
			if(data == ""){
				showMessage("请输入文章内容!!!");
				return;
			}
			$("#content").val(data);
			$("#aboutForm").ajaxSubmit({
				type : "POST",
				url : contextPath + '/api/article?action=update',
				dataType : 'json',
				success : function(data) {
					if (data.success) {
						showMessage(data.msg);
					} else {
						showMessage("修改失败,请稍后再试!!");
					}
					$("#loading").hide();
				},
				error : function(msg) {
					$("#loading").hide();
					showMessage("修改失败,请稍后再试!!");
				}
			});
		});
	</script>
</body>
</html>