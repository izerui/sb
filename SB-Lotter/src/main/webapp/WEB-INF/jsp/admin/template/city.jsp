﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String contextPath = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="../css/base.css" rel="stylesheet" />
<link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
<!--[if IE 7]>
	<link rel="stylesheet" href="../assets/css/font-awesome-ie7.min.css" />
<![endif]-->
<link rel="stylesheet" href="../assets/css/ace.min.css" />
<link rel="stylesheet" href="../assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="../assets/css/ace-skins.min.css" />
<!--[if lte IE 8]>
	<link rel="stylesheet" href="../assets/css/ace-ie.min.css" />
<![endif]-->
<script src="../assets/js/ace-extra.min.js"></script>
<!--[if lt IE 9]>
	<script src="../assets/js/html5shiv.js"></script>
	<script src="../assets/js/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" href="../assets/css/jquery-ui-1.10.3.custom.min.css" />
<link rel="stylesheet" href="../assets/css/chosen.css" />
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
			<li><i class="icon-home home-icon"></i> <a href="../index.jsp">首页</a>
			</li>
			<li class="active">管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				管理 <small> <i class="icon-double-angle-right"> 城市管理界面 </i>
				</small>
			</h1>
		</div>
		<!-- /.page-header -->
		<div class="row" style="height: 100%">
			<div class="col-xs-12">
				<button type="button" class="btn btn-primary" id="addCity">增加城市</button>
				<button id="back" type="button" style="margin-left: 20px"
					class="btn btn-primary btn-sm" id="add">
					<i class="icon-back"></i>返回
				</button>

				<div class="table-responsive">
					<input type="hidden" value="1" id="start" />
					<table id="sample-table-2"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class="center"><label> <input type="checkbox"
										class="ace" /> <span class="lbl"></span>
								</label></th>
								<th>ID</th>
								<th>城市</th>
								<th>省份</th>
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
		<div class="row">
			<div class="col-sm-6">
				<div id="sample-table-2_info" class="dataTables_info">
					<span id="current"></span> <span id="page"></span> 总共 <span
						id="total"></span> 条
				</div>
			</div>
			<div class="col-sm-6">
				<div class="dataTables_paginate paging_bootstrap">
					<ul class="pagination pagination-sm" id="page-list">

					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="addC"
		style="display: none; z-index: 9999; width: 600px; position: absolute; left: 25%; top: 40%; border: 1px solid #ccc; border-radius: 4px !important;">
		<div class="arrow"></div>
		<div class="popover-inner" style="">
			<h3 class="popover-title" id="">城市管理</h3>
			<div class="popover-content" id="" style="background-color: #F5F5F5;">
				<form class="form-horizontal" style="padding-top: 10px;"
					method="post" id="cityForm">
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">城市名：</label>
						<div class="col-sm-9">
							<input name="name" id="name" class="form-control" value="" />
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
	<script src="../assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="../assets/js/jquery.slimscroll.min.js"></script>
	<script src="../assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="../assets/js/jquery.sparkline.min.js"></script>
	<script src="../assets/js/ace-elements.min.js"></script>
	<script src="../assets/js/ace.min.js"></script>
	<script src="../js/common.js"></script>
	<script src="../assets/js/jquery-form.js"></script>
	<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
	<script type="text/javascript">
		init();
		function init() {
			getData(1);
		}

		function getData(start) {
			$("#loading").show();
			$.ajax({
				url : contextPath + '/admin/api',
				type : "POST",
				dataType : 'json',
				data : {
					action : 'getCityByProvId',
					provId : provId
				},
				success : function(rs, textStatus, jqXHR) {
					if (rs.success) {
						$("#loading").hide();
						var data = rs.data;
						var total = rs.total;
						var dataList = $("#data-list");
						dataList.empty();
						$("#total").text(total);
						if (data.length > 0) {
							parseData(data, total, start);
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

		function parseData(data, total, start) {
			var dataList = $("#data-list");
			var tr = "";
			for (var i = 0; i < data.length; i++) {
				tr += '<tr><td class="center"><label><input type="checkbox" value="'+data[i].id+'" class="ace" /><span class="lbl"></span></label></td>';
				tr += '<td>' + data[i].id + '</td>';
				tr += '<td>' + data[i].name + '</td>';
				tr += '<td>' + data[i].provName + '</td>';
				tr += '<td><input type="hidden" value="'+data[i].id+'" /><button type="button" class="btn btn-primary btn-xs addHosp ">增加医院</button></td>';
				tr += '</tr>';
			}
			dataList.append(tr);
			$(".addHosp").bind("click", function() {
				var id = $(this).parent().find("input").val();
				window.location.href = 'hospital.jsp?id=' + id;
			});
			//分页
			var pageList = $("#page-list");
			pageList.empty();
			pageList.append(getPageInfo(start, total));
		}

		$("#addCity").bind("click", function() {
			$("#addC").show();
		});
		$("#cancel").bind("click", function() {
			$("#addC").hide();
			$("#name").val("");
		});

		$("#save").bind("click", function() {
			if ($("#name").val == "") {
				showMessage("请输入城市名");
				return;
			}
			$("#cityForm").ajaxSubmit({
				type : "POST",
				url : contextPath + '/admin/api?action=addCity',
				dataType : 'json',
				success : function(data) {
					if (data.success) {
						showMessage(data.msg);
						$("#addC").hide();
						$("#name").val("");
						getData(1);
					} else {
						showMessage("添加失败");
					}
					$("#loading").hide();
				},
				error : function(msg) {
					$("#loading").hide();
					showMessage("添加失败");
				}
			});
		});
		$("#back").bind("click", function() {
			history.back();
		});
	</script>
</body>
</html>