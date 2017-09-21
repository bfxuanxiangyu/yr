<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>野草科技</title>
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
             <a href="${ctx}/depart/">科室列表</a>
             <span class="divider">/</span>
         </li>
         <li class="active">
            	科室信息
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
              <form:form id="inputForm" modelAttribute="expertDepart" action="${ctx}/depart/saveOrUpdate" 
              			method="post" class="form-horizontal" enctype="multipart/form-data">
				<input type="hidden" name="id" value="${expertDepart.id}"/>
				<input type="hidden" name="cDeleteFlag" value="${expertDepart.cDeleteFlag}"/>
				<div class="control-group">
					<label class="control-label">科室名称:</label>
					<div class="controls">
						<input type="text" id="cDepartments" name="cDepartments" value="${expertDepart.cDepartments}" class="input-large required"/>
					</div>			
				</div>
				<div class="control-group">
					<label class="control-label">科室顺序:</label>
					<div class="controls">
						<input type="number" id="cSort" name="cSort" value="${expertDepart.cSort}" class="input-large required"/>
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
		$("#inputForm").validate();
		
	});
</script>
</body>
</html>
