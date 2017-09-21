<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<div id="header" class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<div class="sidebar-toggle-box hidden-phone">
				<div class="icon-reorder tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<a class="brand" href="<c:url value="/"/>"> 
				<%-- <img src="${ctx}/static/bootstraptemplate/img/logo.png"alt="Metro Lab" /> --%>
				<span style="color: #ffffff; font-size: xx-large;">管理平台</span>
			</a>
			<a class="btn btn-navbar collapsed" id="main_menu_trigger"
				data-toggle="collapse" data-target=".nav-collapse"> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="arrow"></span>
			</a>
			<div class="top-nav ">
				<ul class="nav pull-right top-menu">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <img src="${ctx}/static/bootstraptemplate/img/avatar1_small.jpg"
							alt=""> <span class="username"><span class="username"><shiro:principal property="name"/></span> <b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu extended logout">
							<li><a href="${ctx}/logout"><i class="icon-key"></i> Log
									Out</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
</div>

