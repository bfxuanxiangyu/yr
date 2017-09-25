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

<div class="page-content">
	<!-- PAGE CONTENT BEGINS -->
	<div class="page-header">
		<h1>
			系统管理
			<small>
				<i class="icon-double-angle-right"></i>
				角色
			</small>
		</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<c:if test="${not empty message}">
				<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
			</c:if>
			<shiro:hasPermission name="user:edit">
				<div style="padding-bottom: 15px;">
					<button class="btn  btn-info" type="button" onclick="window.location.href='${ctx}/admin/user/addRoles'">新增角色</button>
				</div>
			</shiro:hasPermission>	
			<div class="table-responsive">
				<table id="sample-table-1" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center"><label><input type="checkbox" class="ace" /><span class="lbl"></span></label></th>
							<th>角色名称</th>
							<th>角色功能</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${roles}" var="role">
							<tr>
							<td class="center"><label><input type="checkbox" class="ace" /><span class="lbl"></span></label></td>
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
		</div>
	</div>	
</div>

</body>
</html>
