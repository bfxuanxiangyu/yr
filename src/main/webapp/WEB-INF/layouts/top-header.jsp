<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<style type="text/css">

	#top_menu{
		background-color: #404040 !important;
		border-radius:4px !important;
	}
</style>

<div id="header" class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="brand" href="<c:url value="/"/>"> 
				<%-- <img src="${ctx}/static/bootstraptemplate/img/logo.png"alt="Metro Lab" /> --%>
				<span style="color: #ffffff; font-size: xx-large;">管理平台</span>
			</a>
			<a class="btn btn-navbar collapsed" id="main_menu_trigger"
				data-toggle="collapse" data-target=".nav-collapse"> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="arrow"></span>
			</a>
			<!-- END RESPONSIVE MENU TOGGLER -->
            <div id="top_menu" class="nav-collapse collapse" style="padding: 0px; margin: 0px;">
                   <!-- BEGIN NOTIFICATION -->
                   <ul class="nav top-menu sidebar-menu" style="margin-top: 5px;">
                       <!-- BEGIN SETTINGS -->
                       <li class="dropdown">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                               <i class="icon-tasks">系统管理</i><b class="caret"></b>
                           </a>
                           <ul class="dropdown-menu extended notification">
                               <li>
                                   <a href="${ctx}/admin/user/">
                                       <span class="label label-important"><i class="icon-bullhorn"></i></span>
                                       	用户管理
                                   </a>
                               </li>
                               <li>
                                   <a href="${ctx}/admin/user/rolesList">
                                       <span class="label label-important"><i class="icon-plus"></i></span>
                                       	角色管理
                                   </a>
                               </li>
                           </ul>
                       </li>
                       <!-- END SETTINGS -->
                       <!-- BEGIN NOTIFICATION DROPDOWN -->
                       <li class="dropdown" id="header_notification_bar">
                           <a href="${ctx}/family/" class="dropdown-toggle">
                               <i class="icon-bell-alt">家庭成员</i>
                           </a>
                       </li>
                       <!-- END NOTIFICATION DROPDOWN -->
                   </ul>
            </div>
			<div class="top-nav notify-row" style="float: right;">
				<ul class="nav pull-right top-menu">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <img src="${ctx}/static/bootstraptemplate/img/avatar1_small.jpg"
							alt=""> <span class="username"><span class="username"><shiro:principal property="name"/></span> <b
							class="caret"></b></a>
						<ul class="dropdown-menu extended logout">
							<li><a href="${ctx}/logout"><i class="icon-key"></i> Log
									Out</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
</div>

