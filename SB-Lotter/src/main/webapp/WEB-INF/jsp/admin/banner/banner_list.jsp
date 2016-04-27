﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String contextPath = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>轮播管理</title>
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
			<li><i class="icon-home home-icon"></i> <a
				href="../index.jsp">首页</a></li>
			<li class="active">管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				管理 <small> <i class="icon-double-angle-right"> 轮播管理 </i>
				</small>
			</h1>
		</div>
		<!-- /.page-header -->
		<div class="row" style="height: 100%">
			<div class="col-xs-12">
				<button type="button" class="btn btn-primary" id="addBanner">增加轮播</button>

				<div class="table-responsive">
					<table id="sample-table-2"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class="center"><label> <input type="checkbox"
										class="ace" /> <span class="lbl"></span>
								</label></th>
								<th>ID</th>
								<th>链接</th>
								<th>图片</th>
								<th>显示状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="data-list">
						</tbody>
					</table>
				</div>
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<div id="addB"
		style="display: none; z-index: 9999; width: 600px; position: absolute; left: 25%; top:20%; border: 1px solid #ccc; border-radius: 4px !important;">
		<div class="arrow"></div>
		<div class="popover-inner" style="">
			<h3 class="popover-title" id="">轮播添加</h3>
			<div class="popover-content" id="" style="background-color: #F5F5F5;">
				<form class="form-horizontal" style="padding-top: 10px;"
					method="post" id="bannerForm" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id" value="" /> <input
						type="hidden" id="action" value="add" />
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">链接：</label>
						<div class="col-sm-9">
							<input name="link" id="link" class="form-control" value="" />
						</div>
						<span class="input_tip" style="line-height: 30px;">*</span>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">图片：</label>
						<div class="col-sm-9">
							<input type="file" name="photo" id="photo" /> <br /> <img src=""
								alt="" width="400" height="160" id="img" style="display: none;" />
						</div>
						<span class="input_tip" style="line-height: 30px;">*</span>
					</div>
				</form>
			</div>
			<div class="popover-footer"
				style="background-color: #F5F5F5; overflow: hidden; text-align: center;">
				<button type="button" class="btn btn-primary"
					style="padding: 0px; margin: 0px 5px 5px 0px;" id="cancel">
					<i class="icon-ok"></i>取消
				</button>
				<button type="button" class="btn btn-danger"
					style="padding: 0px; margin: 0px 5px 5px 0px;" id="save">
					<i class="icon-edit"></i>保存
				</button>

			</div>
		</div>
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
			getData(1);
		}

		function getData(start) {
			$("#loading").show();
			$.ajax({
				url : contextPath + '/api/banner',
				type : "POST",
				dataType : 'json',
				data : {
					action : 'list'
				},
				success : function(rs, textStatus, jqXHR) {
					if (rs.success) {
						$("#loading").hide();
						var data = rs.data;
						var dataList = $("#data-list");
						dataList.empty();
						if (data.length > 0) {
							parseData(data);
						} else {
							showMessage("无数据");
						}
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

		function parseData(data) {
			var dataList = $("#data-list");
			var tr = "";
			for (var i = 0; i < data.length; i++) {
				tr += '<tr><td class="center"><label><input type="checkbox" value="'+data[i].id+'" class="ace" /><span class="lbl"></span></label></td>';
				tr += '<td>' + data[i].id + '</td>';
				tr += '<td><a href="' + data[i].link + '" target="_black">链接地址</a></td>';
				tr += '<td><a href="'+contextPath + data[i].img+'" ><img src="' + contextPath + data[i].img + '" width="300" height="80" target="_black" title="点击查看大图"/></a></td>';
				tr += '<td>' + (data[i].state == 0 ? "显示" : "隐藏") + '</td>';
				tr += '<td><input type="hidden" value="'+data[i].id+'" /><button type="button" class="btn btn-primary btn-xs del ">删除</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-primary btn-xs edit ">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-primary btn-xs state">'+(data[i].state == 0 ? "隐藏" : "显示")+'</button></td>';
				tr += '</tr>';
			}
			dataList.append(tr);
			$(".del").bind("click", function() {
				var id = $(this).parent().find("input").val();
				$("#loading").show();
				$.ajax({
					url : contextPath + '/api/banner',
					type : "POST",
					dataType : 'json',
					data : {
						action : 'delete',
						id:id
					},
					success : function(rs, textStatus, jqXHR) {
						if (rs.success) {
							showMessage(rs.msg);
							getData(1);
						} else {
							showMessage(rs.msg);
						}
							$("#loading").hide();
					},
					error : function() {
						$("#loading").hide();
						showMessage("请稍后再试");
					}
				});
			});
			
			$(".edit").bind("click", function() {
				var id = $(this).parent().find("input").val();
				$("#action").val("update");
				$("#addB").show();
				$("#loading").show();
				$.ajax({
					url : contextPath + '/api/banner',
					type : "POST",
					dataType : 'json',
					data : {
						action : 'get',
						id:id
					},
					success : function(rs, textStatus, jqXHR) {
						if (rs.success) {
							$("#id").val(rs.data.id);
							$("#link").val(rs.data.link);
							$("#img").show();
							$("#img").attr("src" , contextPath + rs.data.img);
						} else {
							showMessage(rs.msg);
						}
						$("#loading").show();
					},
					error : function() {
						$("#loading").hide();
						showMessage("请稍后再试");
					}
				});
				
			});
			
			$(".state").bind("click", function() {
				var id = $(this).parent().find("input").val();
				$.ajax({
					url : contextPath + '/api/banner',
					type : "POST",
					dataType : 'json',
					data : {
						action : 'get',
						id:id
					},
					success : function(rs, textStatus, jqXHR) {
						if (rs.success) {
							showMessage(rs.msg);
							getData(1);
						} else {
							showMessage(rs.msg);
						}
							$("#loading").hide();
					},
					error : function() {
						$("#loading").hide();
						showMessage("请稍后再试");
					}
				});
				
			});
		}

		$("#addBanner").bind("click", function() {
			$("#action").val("add");
			$("#img").hide();
			$("#addB").show();
		});
		$("#cancel").bind("click", function() {
			$("#addB").hide();
			$("#link").val("");
			$("#photo").val("");
		});

		$("#save").bind(
				"click",
				function() {
					if ($("#link").val() == "") {
						showMessage("请输入链接地址!!");
						return;
					}
					if ($("#action").val() == "add") {
						if ($("#photo").val() == "") {
							showMessage("请选择图片!!");
							return;
						}
					}
					$("#loading").show();
					$("#bannerForm").ajaxSubmit(
							{
								type : "POST",
								url : contextPath + '/api/banner?action='
										+ ($("#action").val()),
								dataType : 'json',
								success : function(data) {
									if (data.success) {
										showMessage(data.msg);
										$("#addB").hide();
										$("#link").val("");
										$("#photo").val("");
										getData(1);
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