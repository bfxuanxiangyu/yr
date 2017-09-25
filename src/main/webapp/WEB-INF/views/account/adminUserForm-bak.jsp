<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户管理</title>
</head>

<body>


<div class="row-fluid">
   <div class="span12">
       <!-- BEGIN THEME CUSTOMIZER-->
     <!-- END THEME CUSTOMIZER-->
    <!-- BEGIN PAGE TITLE & BREADCRUMB-->
     <h3 class="page-title"></h3>
     <ul class="breadcrumb">
         <li>
             <a href="#">系统管理</a>
             <span class="divider">/</span>
         </li>
         <li>
             <a href="${ctx}/admin/user/">用户列表</a>
             <span class="divider">/</span>
         </li>
         <li class="active">
            	 用户管理
         </li>
     </ul>
     <!-- END PAGE TITLE & BREADCRUMB-->
   </div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN PAGE CONTENT-->

<!-- BEGIN ADVANCED TABLE widget-->
<div class="row-fluid">
    <div class="span12">
    <!-- BEGIN EXAMPLE TABLE widget-->
    <!-- BEGIN BUTTON PORTLET-->
          <div class="widget-body">
              <form:form id="inputForm" modelAttribute="adminUser" action="${ctx}/admin/user/saveOrUpdate" method="post" class="form-horizontal">
				<input type="hidden" name="id" value="${adminUser.id}"/>
				<div class="control-group">
					<label class="control-label" for="loginName">登录名</label>
					<c:choose>
					   <c:when test="${empty adminUser.loginName}">
						   	<div class="controls">
								<input type="text" id="loginName" name="loginName" value="${adminUser.loginName}" class="input-large required" />
							</div>
					   </c:when>
					   <c:otherwise>
					   		<div class="controls">
								<input type="text" id="loginName" name="loginName" value="${adminUser.loginName}" class="input-large" disabled="disabled"/>
							</div>
					   </c:otherwise>
					</c:choose>
				</div>
				<div class="control-group">
					<label class="control-label" for="name">用户名</label>
					<div class="controls">
						<input type="text" id="name" name="name" value="${adminUser.name}" class="input-large required"/>
					</div>
				</div>
				<!-- 如果是新增怎显示 -->
				<c:if test="${empty adminUser.id}">
					<div class="control-group">
						<label for="plainPassword" class="control-label">密码</label>
						<div class="controls">
							<input type="password" id="plainPassword" name="plainPassword" class="input-large"/>
						</div>
					</div>
					<div class="control-group">
						<label for="confirmPassword" class="control-label">确认密码</label>
						<div class="controls">
							<input type="password" id="confirmPassword" name="confirmPassword" class="input-large" />
						</div>
					</div>
				</c:if>
				<div class="control-group">
				    <label for="rolesList" class="control-label">角色</label>
				    <div class="controls">
			    		<c:forEach items="${roles}" var="role">
							<input type="radio" name="roleId" value="${role.id}" <c:if test="${role.id==adminUser.roleId}"> checked="checked" </c:if>  />${role.name }
						</c:forEach>
				    </div>
				</div>	
                      <div class="control-group">
                          <label class="control-label" for="remark">备注</label>
                          <div class="controls">
                              <textarea class="input-xxlarge" rows="2" cols="100" id="remark" name="remark" >${adminUser.remark}</textarea>
                          </div>
                      </div>
				<div class="form-actions">
                          <button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
                          <button type="button" class="btn" onclick="history.back()"><i class="icon-remove"></i> Cancel</button>
                      </div>
			</form:form>
          </div>
    </div>
</div>

<style type="text/css">
.zeusError{
	color: red;
}
</style>	
<!-- begin script -->	
<script>
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#name").focus();
		$("#inputForm").validate({
		 	focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
               onkeyup: false,   
               submitHandler: function(form){   //表单提交句柄,为一回调函数，带一个参数：form   
                   form.submit();   //提交表单   
               },  
               rules:{
               	loginName:{
                       required:true,
                       remote: "${ctx}/admin/user/checkLoginName?oldLoginName=" + encodeURIComponent('${adminUser.loginName}')
                   },
                name:{
                    required:true
                },
                plainPassword: {
                	required:true,
                	minlength:6
                },
                confirmPassword: {
                	required:true,
                	minlength:6,
                    equalTo: "#plainPassword"
                }
               }, 
               messages:{
               	   loginName:{
                       required:"登录名必选",
                       remote: "登录名已存在"
                   },
                   name:{
                       required:"用户名必选"
                   },                                   
                   plainPassword:{
                       required:"密码必填",
                       minlength:"密码不能少于6位"
                   },
                   confirmPassword: {
              	    required: "请输入确认密码",
              	    minlength:"密码不能少于6位",
              	    equalTo: "两次输入密码不一致"
              	   }
               }
	 	});
		
	});
</script>
</body>
</html>
