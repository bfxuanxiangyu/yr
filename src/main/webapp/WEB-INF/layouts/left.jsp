<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx}/static/bootstrap3/assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript">

//获取一级列表   如果发现一级列表下没有二级菜单则隐藏
$(document).ready(function () {
	$(".submenu > li").click(function(){  
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
	if(data && data != "null" && data !="welcomeId"){
	  $('#'+data).attr('class','active'); 
	  $('#'+data).parent().parent().attr('class','active open');
	}else{
	  $('#welcomeId').attr('class','active'); 
	  //$('#welcomeId').parent().attr('class','active');
	}
});
//获取一级列表   如果发现一级列表下没有二级菜单则隐藏
$(function(){
	var dv_num = 0; 
    $(".submenu").each(function(){
    	dv_num +=1;
    	if(dv_num>1){
    		if(this.id){
	    		var uls=document.getElementById(this.id).getElementsByTagName("li");
	    		alert("当前id样式="+this.id+"--"+uls.length);
	    		if(uls.length==0){
	    			document.getElementById(this.id).style.display = 'none';
	    		}
    		}
    	}
    });
});
</script>
<!-- BEGIN SIDEBAR -->
<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
	</script>

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="icon-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="icon-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="icon-group"></i>
			</button>

			<button class="btn btn-danger">
				<i class="icon-cogs"></i>
			</button>
		</div>

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span>

			<span class="btn btn-info"></span>

			<span class="btn btn-warning"></span>

			<span class="btn btn-danger"></span>
		</div>
	</div><!-- #sidebar-shortcuts -->

	<ul class="nav nav-list">
		<li id="welcomeId" class="sub-menu active">
			<a href="${ctx}/admin/user/home">
				<i class="icon-dashboard"></i>
				<span class="menu-text">控制台 </span>
			</a>
		</li>
		<li id="systemMenuId" class="sub-menu">
			<a href="#" class="dropdown-toggle">
				<i class="icon-desktop"></i><span class="menu-text">系统管理</span><b class="arrow icon-angle-down"></b>
			</a>
			<ul class="submenu">
				<li id="userId"><a href="${ctx}/admin/user/"><i class="icon-double-angle-right"></i>用户管理</a></li>
				<li id="roleId"><a href="${ctx}/admin/user/rolesList"><i class="icon-double-angle-right"></i>角色管理</a></li>
			</ul>
		</li>

		<li>
			<a href="#" class="dropdown-toggle">
				<i class="icon-desktop"></i>
				<span class="menu-text"> UI 组件 </span>

				<b class="arrow icon-angle-down"></b>
			</a>

			<ul class="submenu">
				<li>
					<a href="#">
						<i class="icon-double-angle-right"></i>
						组件
					</a>
				</li>

				<li>
					<a href="#">
						<i class="icon-double-angle-right"></i>
						按钮 &amp; 图表
					</a>
				</li>

				<li>
					<a href="#">
						<i class="icon-double-angle-right"></i>
						树菜单
					</a>
				</li>

				<li>
					<a href="#">
						<i class="icon-double-angle-right"></i>
						jQuery UI
					</a>
				</li>

				<li>
					<a href="#">
						<i class="icon-double-angle-right"></i>
						可拖拽列表
					</a>
				</li>

				<li>
					<a href="#" class="dropdown-toggle">
						<i class="icon-double-angle-right"></i>

						三级菜单
						<b class="arrow icon-angle-down"></b>
					</a>

					<ul class="submenu">
						<li>
							<a href="#">
								<i class="icon-leaf"></i>
								第一级
							</a>
						</li>

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-pencil"></i>

								第四级
								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="#">
										<i class="icon-plus"></i>
										添加产品
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-eye-open"></i>
										查看商品
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>
		</li>

	</ul><!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
	</script>
</div>
