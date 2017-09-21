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
   <link href="${ctx}/static/bootstraptemplate/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
   <link href="${ctx}/static/bootstraptemplate/assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
   <link href="${ctx}/static/bootstraptemplate/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
   <link href="${ctx}/static/bootstraptemplate/css/style.css" rel="stylesheet" />
   <link href="${ctx}/static/bootstraptemplate/css/style-responsive.css" rel="stylesheet" />
   <link href="${ctx}/static/bootstraptemplate/css/style-default.css" rel="stylesheet" id="style_color" />
   
   <style type="text/css">
   		.login-title{
   			font-size: xx-large;
   			color: #ffffff;
   		}
   </style>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="lock">
    <div class="lock-header">
        <!-- BEGIN LOGO -->
        <span class="login-title">后台管理系统</span>
        <!-- END LOGO -->
    </div>
    <div class="login-wrap">
        <div class="metro single-size red">
            <div class="locked">
                <i class="icon-lock"></i>
                <span>Login</span>
            </div>
        </div>
        <form action="${ctx}/login" method="post">
	        <div class="metro double-size green">
	             <div class="input-append lock-input">
	                 <input type="text"  class="form-username form-control" id="form-username" 
	                 	name="username"  placeholder="Username" required="required">
	             </div>
	        </div>
	        <div class="metro double-size yellow">
	             <div class="input-append lock-input">
	                 <input type="password" class="form-password form-control" id="form-password" 
	                 	name="password"  placeholder="Password" required="required">
	             </div>
	        </div>
	        <div class="metro single-size terques login">
	                <button type="submit" class="btn login-btn">
	                    Login
	                    <i class=" icon-long-arrow-right"></i>
	                </button>
	        </div>
	        <div class="metro double-size navy-blue ">
	            <!-- <a href="index.html" class="social-link">
	                <i class="icon-facebook-sign"></i>
	                <span>Facebook Login</span>
	            </a> -->
	        </div>
	        <div class="metro single-size deep-red">
	            <!-- <a href="index.html" class="social-link">
	                <i class="icon-google-plus-sign"></i>
	                <span>Google Login</span>
	            </a> -->
	        </div>
	        <div class="metro double-size blue">
	            <!-- <a href="index.html" class="social-link">
	                <i class="icon-twitter-sign"></i>
	                <span>Twitter Login</span>
	            </a> -->
	        </div>
	        <div class="metro single-size purple">
	            <!-- <a href="index.html" class="social-link">
	                <i class="icon-skype"></i>
	                <span>Skype Login</span>
	            </a> -->
	        </div>
	        <div class="login-footer">
	            <div class="remember-hint pull-left">
	                <input type="checkbox" id="rememberMe" name="rememberMe"> 
	                <label for="rememberMe" style="display: inline;">Remember Me</label> 
	            </div>
	            <div class="forgot-hint pull-right">
	                <a id="forget-password" class="" href="javascript:;">Forgot Password?</a>
	            </div>
	        </div>
        </form>
    </div>
</body>
<!-- END BODY -->
</html>
