<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
   <meta charset="utf-8" />
   <title>新增用户</title>
</head>


<div class="page-content">
			<!-- PAGE CONTENT BEGINS -->
			<div class="page-header">
				<h1>
					系统管理
					<small>
						<i class="icon-double-angle-right"></i>
						用户列表
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
							<button class="btn  btn-info" type="button" onclick="window.location.href='${ctx}/admin/user/create'">新增用户</button>
						</div>
					</shiro:hasPermission>	
					<div class="table-responsive">
						<table id="sample-table-1" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th class="center"><label><input type="checkbox" class="ace" /><span class="lbl"></span></label></th>
									<th>登录名</th>
									<th>用户名</th>
									<th>角色</th>
									<th class="hidden-480">注册时间</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users.content}" var="user">
									<tr>
									<td class="center"><label><input type="checkbox" class="ace" /><span class="lbl"></span></label></td>
										<td>${user.loginName}</td>
										<td>${user.name}</td>
										<td class="hidden-480">${user.permissionName}</td>
										<td><fmt:formatDate value="${user.createdTime}" pattern="yyyy年MM月dd日  HH时mm分ss秒" /></td>
										<td>
										<shiro:hasPermission name="user:edit"> 
											  	<a href="${ctx}/admin/user/update/${user.id }?index=systemId"><span class="label label-success">编辑</span></a>
											  	&nbsp;|&nbsp;
											  	<a href="${ctx}/admin/user/delete/${user.id }?index=systemId"><span class="label label-warning">删除</span></a>
											  	&nbsp;|&nbsp;
											  	<a href="#myModal1${user.id }" data-toggle="modal"><span class="label">修改密码</span></a>
										</shiro:hasPermission>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<tags:pagination page="${users}" paginationSize="5"/>
					</div><!-- /.table-responsive -->
				</div><!-- /span -->
			</div>


</div>

<script type="text/javascript">
 
function disable(){
	var obj=document.getElementsByName('checkboxName'); //选择所有name="'test'"的对象，返回数组 
	//取到对象数组后，我们来循环检测它是不是被选中 
	var s=''; 
	for(var i=0; i<obj.length; i++){ 
		if(obj[i].checked) s+=obj[i].value+','; //如果选中，将value添加到变量s中 
	} 
	//那么现在来检测s的值就知道选中的复选框的值了 
	if(s != ''){
		s = s.substr(0,s.length-1);
	}
	alert(s==''?'你还没有选择任何内容！':s); 
}

function showIcon(icon,showBody){
	if($("#"+icon).hasClass("icon-chevron-down")){
		jQuery("#"+icon).removeClass("icon-chevron-down").addClass("icon-chevron-up");
		$("#"+showBody).slideUp(400);
	}else{
		jQuery("#"+icon).removeClass("icon-chevron-up").addClass("icon-chevron-down");
		$("#"+showBody).slideDown(400);
	}
}
function removesIcon(showBody){
	$("#"+showBody).remove();
}
function subForm(id){
	$("#newpwd").val($("#plainPassword"+id).val());
	$("#auid").val(id);
	if(checkRepate(id)){
		$("#savepwd").attr("data-dismiss","modal");
		$("#savepwd").attr("data-dismiss","true");
		$("#upPasswordForm").submit();
		alert("已修改");
	}else{
		$("#savepwd").removeAttr("data-dismiss");
		$("#savepwd").removeAttr("data-dismiss");
		//return;data-dismiss="modal" aria-hidden="true"
	}
}
function checkRepate(id){
	var plainpwd = $("#plainPassword"+id).val();
	var reppwd = $("#repeatPassword"+id).val();
	if(plainpwd != reppwd){
		$("#warn"+id).css('display','inline');
		$("#isnull"+id).css('display','none');
		return false;
	}else if(plainpwd == "" && reppwd == ""){
		$("#isnull"+id).css('display','inline');
		$("#warn"+id).css('display','none');
		return false;
	}else{
		$("#warn"+id).css('display','none');
		$("#isnull"+id).css('display','none');
		return true;
	}
}


 </script>

</body>
<!-- END BODY -->
</html>
