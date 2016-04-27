﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String contextPath = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>列表-用户</title>
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
				管理 <small> <i class="icon-double-angle-right"> 用户管理 </i>
				</small>
			</h1>
		</div>
		<!-- /.page-header -->
		<div class="row" style="height: 100%">
			<div  class="col-xs-12">
					
			</div>
			<div class="col-xs-12">
				<div class="table-responsive">
					<input type="hidden" value="1" id="start" />
					<table id="sample-table-2"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class="center"><label> <input type="checkbox"
										class="ace" /> <span class="lbl"></span>
								</label></th>
								<th>用户号码</th>
								<th>用户名称</th>
								<th>用户昵称</th>
								<th>生日</th>
								<th>性别</th>
								<th>邮箱</th>
								<th>身份证</th>
								<th>qq</th>
								<th>用户类型</th>
								<th>状态</th>
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
					当前    <span id="current">  </span> 到  <span id="page"></span> 总共 <span
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
				url : contextPath + '/api/user',
				type : "POST",
				dataType : 'json',
				data : {
					action : 'list',
					begin : (start - 1) * pageSize,
					end : pageSize
				},
				success : function(rs, textStatus, jqXHR) {
					if (rs.success) {
						$("#loading").hide();
						var data = rs.data;
						var total = rs.total;
						var dataList = $("#data-list");
						dataList.empty();
						$("#total").text(total);
						$("#current").text((start - 1) * pageSize + 1);
						if (data.length > 0) {
							$("#page").text(
									(start - 1) * pageSize + data.length);
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
				tr += '<td>' + data[i].mobile + '</td>';
				tr += '<td>' + data[i].name + '</td>';
				tr += '<td>' + data[i].nickName + '</td>';
				tr += '<td>' + data[i].birthday + '</td>';
				tr += '<td>' + data[i].sex + '</td>';
				tr += '<td>' + data[i].email + '</td>';
				tr += '<td>' + data[i].cardNum + '</td>';
				tr += '<td>' + data[i].qq + '</td>';
				tr += '<td>' + (data[i].type == 0 ? "普通会员" : "vip") + '</td>';
				tr += '<td>' + (data[i].state == 0 ? "启用" : "禁用") + '</td>';
				tr += '<td><input type="hidden" value="'+data[i].id+'" class="userId"/><input type="hidden" value="'+data[i].state+'" class="state"/><input type="hidden" value="'+data[i].type+'" class="type"/> <button type="button" class="btn btn-primary btn-xs del">'+(data[i].state == 0 ? "禁用" : "启用")+'</button>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-primary btn-xs setType">'+(data[i].type == 0 ? "设置为vip" : "设置为普通会员")+'</button></td>';
				tr += '</tr>';
			}
			dataList.append(tr);
			$(".del").bind("click", function() {
				var id = $(this).parent().find("input.userId").val();
				var state = $(this).parent().find("input.state").val();
				$.ajax({
					url : contextPath + '/api/user',
					type : "POST",
					dataType : 'json',
					data : {
						action : 'setState',
						id:id,
						state:(state == 0 ) ? 1 : 0
					},
					success : function(rs, textStatus, jqXHR) {
						if (rs.success) {
							$("#loading").hide();
							showMessage(rs.msg);
							getData(start);
						} else {
							showMessage(rs.msg);
						}
					},
					error : function() {
						$("#loading").hide();
						showMessage("请稍后再试");
					}
				});
			});
			
			$(".setType").bind("click", function() {
				var id = $(this).parent().find("input.userId").val();
				var type = $(this).parent().find("input.type").val();
				$.ajax({
					url : contextPath + '/api/user',
					type : "POST",
					dataType : 'json',
					data : {
						action : 'setType',
						id:id,
						type:(type == 0 ) ? 1 : 0
					},
					success : function(rs, textStatus, jqXHR) {
						if (rs.success) {
							$("#loading").hide();
							showMessage(rs.msg);
							getData(start);
						} else {
							showMessage(rs.msg);
						}
					},
					error : function() {
						$("#loading").hide();
						showMessage("请稍后再试");
					}
				});
			});
			//分页
			var pageList = $("#page-list");
			pageList.empty();
			pageList.append(getPageInfo(start, total));
		}
	</script>
</body>
</html>