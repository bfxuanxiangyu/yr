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
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/fonts.css?family=Open+Sans:400,300" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/ace.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/ace-skins.min.css" />
	
	<link rel="stylesheet" href="${ctx}/static/css/zeus.css" />
	
	<script src="${ctx}/static/bootstrap3/assets/js/ace-extra.min.js"></script>
        
	<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">

	<style type="text/css">
	 	form{
	 		margin: 0 0 5px;
	 	}
	 	label {
			display: -webkit-inline-box !important;
		}
	</style>

</head>


<body>

	<%@ include file="/WEB-INF/layouts/header.jsp"%>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<%@ include file="/WEB-INF/layouts/left.jsp"%>

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
						<sitemesh:body />
					</div>
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div>
		
	<script src="${ctx}/static/bootstrap3/assets/js/jquery.validate.min.js">
	<script src="${ctx}/static/bootstrap3/assets/js/jquery-2.0.3.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/bootstrap.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/typeahead-bs2.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/jquery.slimscroll.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/jquery.sparkline.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/flot/jquery.flot.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/flot/jquery.flot.pie.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/flot/jquery.flot.resize.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/ace-elements.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/ace.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/jquery.dataTables.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/jquery.dataTables.bootstrap.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/typeahead-bs2.min.js"></script>
	<script src="${ctx}/static/bootstrap3/assets/js/ace-extra.min.js"></script>
	
</body>
</html>