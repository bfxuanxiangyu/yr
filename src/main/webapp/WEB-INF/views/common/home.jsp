<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>操作台</title>
<meta name="menu" content="user" />

<style type="text/css">
	body html{
		height: 100%;
		width: 100%;
	}
</style>
</head>

<body>
	<ul class="breadcrumb">
		<li>
			<i class="icon-home home-icon"></i>
			<a href="#">首页</a>
		</li>
		<li class="active">控制台</li>
	</ul><!-- .breadcrumb -->
	<div class="nav-search" id="nav-search">
		<form class="form-search">
			<span class="input-icon">
				<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
				<i class="icon-search nav-search-icon"></i>
			</span>
		</form>
	</div><!-- #nav-search -->
	<div class="page-content">
		<div class="page-header">
			<h1>
				控制台
				<small>
					<i class="icon-double-angle-right"></i>
					 查看
				</small>
			</h1>
		</div><!-- /.page-header -->
		<div class="row">
			<div class="col-xs-12">
				<div class="alert alert-block alert-success">
					<button type="button" class="close" data-dismiss="alert">
						<i class="icon-remove"></i>
					</button>
			
					<i class="icon-ok green"></i>
			
					欢迎使用
					<strong class="green">
						Bootstrap3管理系统
						<small>(v3)</small>
					</strong>
					,轻量级好用的后台管理系统模版.	
				</div>
			</div>
		</div>	
	</div>		
</body>
</html>
