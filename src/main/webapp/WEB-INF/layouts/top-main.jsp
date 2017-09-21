<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title><sitemesh:title default="野草科技" /></title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="Mosaddek" name="author" />
    <link href="${ctx}/static/bootstraptemplate/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${ctx}/static/bootstraptemplate/assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
    <link href="${ctx}/static/bootstraptemplate/assets/bootstrap/css/bootstrap-fileupload.css" rel="stylesheet" />
    <link href="${ctx}/static/bootstraptemplate/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="${ctx}/static/bootstraptemplate/css/style.css" rel="stylesheet" />
    <link href="${ctx}/static/bootstraptemplate/css/style-responsive.css" rel="stylesheet" />
    <link href="${ctx}/static/bootstraptemplate/css/style-default.css" rel="stylesheet" id="style_color" />
    <link href="${ctx}/static/bootstraptemplate/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
    <link href="${ctx}/static/bootstraptemplate/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
	<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">


	<style type="text/css">
	 	form{
	 		margin: 0 0 5px;
	 	}
	</style>

</head>


<body class="fixed-top">

	<%@ include file="/WEB-INF/layouts/header.jsp"%>
	
	<div id="container" class="row-fluid">
	
		<%-- <%@ include file="/WEB-INF/layouts/left.jsp"%> --%>
		
		<div id="main-content"  style="width: 100%;  margin-left: 0px;">
			<div class="container-fluid">
				<sitemesh:body />
			</div>
		</div>
	</div>
	<div id="footer">
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
	
	
   <script src="${ctx}/static/bootstraptemplate/js/jquery-1.8.3.min.js"></script>
   <script src="${ctx}/static/bootstraptemplate/js/jquery.nicescroll.js" type="text/javascript"></script>
   <script type="text/javascript" src="${ctx}/static/bootstraptemplate/assets/jquery-slimscroll/jquery-ui-1.9.2.custom.min.js"></script>
   <script type="text/javascript" src="${ctx}/static/bootstraptemplate/assets/jquery-slimscroll/jquery.slimscroll.min.js"></script>
   <script src="${ctx}/static/bootstraptemplate/assets/fullcalendar/fullcalendar/fullcalendar.min.js"></script>
   <script src="${ctx}/static/bootstraptemplate/assets/bootstrap/js/bootstrap.min.js"></script>

   <!-- ie8 fixes -->
   <!--[if lt IE 9]>
   <script src="js/excanvas.js"></script>
   <script src="js/respond.js"></script>
   <![endif]-->

   <script src="${ctx}/static/bootstraptemplate/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js" type="text/javascript"></script>
   <script src="${ctx}/static/bootstraptemplate/js/jquery.sparkline.js" type="text/javascript"></script>
   <script src="${ctx}/static/bootstraptemplate/assets/chart-master/Chart.js"></script>
   <script src="${ctx}/static/bootstraptemplate/js/jquery.scrollTo.min.js"></script>


   <script src="${ctx}/static/bootstraptemplate/js/common-scripts.js"></script>

   <script src="${ctx}/static/bootstraptemplate/js/easy-pie-chart.js"></script>
   <script src="${ctx}/static/bootstraptemplate/js/sparkline-chart.js"></script>
   <script src="${ctx}/static/bootstraptemplate/js/home-page-calender.js"></script>

</body>
</html>