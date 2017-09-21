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
	<form:form id="inputForm" modelAttribute="role" action="${ctx}/admin/user/saveOrUpdateRoles" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${role.id}"/>
		<fieldset>
			<legend><small>角色管理</small></legend>
			<div class="control-group">
				<label class="control-label">角色名称</label>
				<div class="controls">
					<input type="text" id="name" name="name" value="${role.name}" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">备注</label>
				<div class="controls">
					<input type="text" id="discription" name="discription" value="${role.discription}" class="input-large required" />
				</div>
			</div>
			<div class="control-group">
			    <label for="permissionList" class="control-label">权限列表:</label>
			    <div class="controls">
					<form:checkboxes path="permissionList" items="${allPermissions}" itemLabel="displayName" itemValue="value" />
			    </div>
			    
			</div>	
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form:form>
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
