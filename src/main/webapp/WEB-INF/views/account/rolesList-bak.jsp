<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>角色管理</title>
</head>

<body>
	<div class="span12" style="margin-top: 25px;">
		<c:if test="${not empty message}">
			<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
		</c:if>
		<shiro:hasPermission name="user:edit">
			<div><a class="btn" href="${ctx}/admin/user/addRoles">新增角色</a></div><br/>
		</shiro:hasPermission>
		<table id="contentTable" class="table table-striped table-bordered table-condensed">
			<thead><tr><th>角色名称</th><th>角色功能<shiro:hasPermission name="user:edit"><th>管理</th></shiro:hasPermission></tr></thead>
			<tbody>
			<c:forEach items="${roles}" var="role">
				<tr>
					<td>${role.name}</td>
					<td>${role.roles}</td>
					<shiro:hasPermission name="user:edit">
						<td>
						    <c:if test="${role.id != 1 }">
							  	<a href="${ctx}/admin/user/updateRoles/${role.id}">编辑</a>
							  	&nbsp;|&nbsp;
							  	<a href="${ctx}/admin/user/deleteRoles/${role.id}">删除</a>
						    </c:if>
						    <c:if test="${role.id == 1 }">
							  	<a href="${ctx}/admin/user/updateRoles/${role.id}">编辑</a>
						    </c:if>
						</td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>	
</body>
</html>
