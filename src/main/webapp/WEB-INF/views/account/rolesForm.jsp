<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>角色管理</title>
</head>

<body>
<ul class="breadcrumb">
	<li>
		<i class="icon-home home-icon"></i>
		<a href="#">系统管理</a>
	</li>

	<li>
		<a href="${ctx}/admin/user/rolesList">角色列表</a>
	</li>
	<li class="active">编辑角色</li>
</ul>

<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<form:form id="inputForm" modelAttribute="role" action="${ctx}/admin/user/saveOrUpdateRoles" method="post" class="form-horizontal">
				<input type="hidden" name="id" value="${role.id}"/>
				<fieldset>
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right">角色名称</label>
						<div class="controls">
							<input type="text" id="name" name="name" value="${role.name}" class="input-large required"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right">备注</label>
						<div class="controls">
							<input type="text" id="discription" name="discription" value="${role.discription}" class="input-large required" />
						</div>
					</div>
					<div class="form-group">
					    <label for="permissionList" class="col-sm-2 control-label no-padding-right">权限列表:</label>
					    <div class="controls">
							<form:checkboxes path="permissionList" items="${allPermissions}" 
							itemLabel="displayName" itemValue="value"/>
					    </div>
					    
					</div>	
					<div class="form-actions">
						<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
						<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>	
</div>


	<style type="text/css">
		.controls span label{
			width: auto;
			float: left;
			padding-left: 1px;
		}	
		.controls span input{
			width: 10px;
			float: left;
			padding-left: 3px;
		}	
		input[type="radio"], input[type="checkbox"]{
			margin: 14px 0 0;
		}
		.controls span input{
			width: 25px;
		}
	</style>
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#name").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate();
		});
	</script>
</body>
</html>
