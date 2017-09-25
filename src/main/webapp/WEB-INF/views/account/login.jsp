<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
   <meta charset="utf-8" />
   <title>登录</title>
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
   <link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/fonts.css?family=Open+Sans:400,300" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/ace.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/ace-skins.min.css" />
   
   <style type="text/css">
   		.login-title{
   			font-size: xx-large;
   			color: #ffffff;
   		}
   </style>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">后台</span>
									<span class="white">管理平台</span>
								</h1>
								<h4 class="blue">&copy; YIREN</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												Please Enter Your Information
											</h4>

											<div class="space-6"></div>

											<form  action="${ctx}/login" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text"  class="form-username form-control" id="form-username" 
	                 											name="username"  placeholder="Username" required="required">
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-password form-control" id="form-password" 
	                 											name="password"  placeholder="Password" required="required">
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" id="rememberMe" name="rememberMe" class="ace" > 
															<span class="lbl"> Remember Me</span>
														</label>
														 <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
										                    Login
										                    <i class="icon-key"></i>
										                </button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

										</div><!-- /widget-main -->
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->
</body>
<!-- END BODY -->
</html>
