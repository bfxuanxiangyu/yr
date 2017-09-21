<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx}/static/bootstraptemplate/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

$(document).ready(function () {
	$(".sub > li").click(function(){  
		//$(this).attr('class','active'); 
		//$(this).parent().parent().attr('class','active');
		//alert($(this).attr('class')+"--父级--"+$(this).parent().parent().attr('class')); 
		var clickMenuId = this.id;
		$.post("/admin/user/jsonUpdateMenuId",{clickMenuId:clickMenuId} ,function(data) {
			  //alert(data);
		});
	});
	$("#welcomeId").click(function(){  
		var clickMenuId = this.id;
		$.post("/admin/user/jsonUpdateMenuId",{clickMenuId:clickMenuId} ,function(data) {
			  //alert(data);
		});
	});
});
/*
*加载一点击过的menuId
*/
$.post("/admin/user/jsonGetMenuId",function(data) {
	if(data && data != "null"){
	  $('#'+data).attr('class','active'); 
	  $('#'+data).parent().parent().attr('class','active');
	}else{
	  $('#welcomeId').attr('class','active'); 
	  $('#welcomeId').parent().attr('class','active');
	}
});

//获取一级列表   如果发现一级列表下没有二级菜单则隐藏
$(function(){
    var dv_num = 0; 
    $(".sub-menu").each(function(){
    	dv_num +=1;
    	if(dv_num>1){
    		var uls=document.getElementById(this.id).getElementsByTagName("li");
    		if(uls.length==0){
    			document.getElementById(this.id).style.display = 'none';
    		}
    	}
    })    
});
</script>
<!-- BEGIN SIDEBAR -->
<div class="sidebar-scroll">
	<div id="sidebar" class="nav-collapse collapse">

		<!-- BEGIN SIDEBAR MENU -->
		<ul class="sidebar-menu">
			<li id="welcomeId" class="sub-menu">
				<a class="" href="/admin/user/home"> <i class="icon-dashboard"></i> <span>欢迎平台</span></a>
			</li>
			<li id="systemMenuId" class="sub-menu  active">
				<a href="javascript:;" class=""> <i class="icon-windows"></i> <span>系统管理</span> <span class="arrow"></span></a>
				<ul class="sub">
					<li id="userId"><a class="" href="${ctx}/admin/user/">用户管理</a></li>
					<li id="roleId"><a class="" href="${ctx}/admin/user/rolesList">角色管理</a></li>
				</ul>
			</li>
			<li id="familyMenuId" class="sub-menu active">
				<a href="javascript:;" class=""> <i class=" icon-male"></i> <span>和睦家庭</span> <span class="arrow"></span></a>
				<ul id="" class="sub">
					<li id="familyId"><a class="" href="${ctx}/family/">家庭成员</a></li>
				</ul>
			</li>
			<li>
				<a class="" href="${ctx}/logout"> <i class="icon-user"></i><span>To Login</span></a>
			</li>
		</ul>
		<!-- END SIDEBAR MENU -->
	</div>
</div>
<!-- END SIDEBAR -->
