<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
</head>
<body>
	login页面
	<form action="judge" method="post">
		<div class="form-group">
			用户名：<input type="text" name="username" class="form-control"/>
		</div>
		<div class="form-group">
			密码： <input type="password" name="password" class="form-control"/>
		</div>
		<div class="form-group">
			<input type="checkbox" name="rememberme" /> Remember me
		</div>
		<div class="form-group">
			<input type="submit" value="提交" />
		</div>
	</form>
</body>
</html>