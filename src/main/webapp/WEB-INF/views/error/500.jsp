<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
   <meta charset="utf-8" />
   <title>500 Page</title>
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <link href="${ctx}/static/bootstraptemplate/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
   <link href="${ctx}/static/bootstraptemplate/assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
   <link href="${ctx}/static/bootstraptemplate/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
   <link href="${ctx}/static/bootstraptemplate/css/style.css" rel="stylesheet" />
   <link href="${ctx}/static/bootstraptemplate/css/style-responsive.css" rel="stylesheet" />
   <link href="${ctx}/static/bootstraptemplate/css/style-default.css" rel="stylesheet" id="style_color" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="error-500">
    <div class="error-wrap">
        <h1>Ouch!</h1>
        <h2>Looks like something went wrong</h2>
        <div class="metro green">
           <span> 5 </span>
        </div>
        <div class="metro yellow">
            <span> 0 </span>
        </div>
        <div class="metro purple">
            <span> 0 </span>
        </div>
        <p>For Updates follow us on <a href="http://xuanxy.blog.51cto.com/">xuanxy</a> , Very soon we will fix the issue. <a href="<c:url value="/"/>"> Return Home </a></p>
    </div>
</body>
<!-- END BODY -->
</html>
