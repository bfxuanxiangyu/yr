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
   <link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/fonts.css?family=Open+Sans:400,300" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/ace.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="${ctx}/static/bootstrap3/assets/css/ace-skins.min.css" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="error-500">
    <div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<div class="error-container">
									<div class="well">
										<h1 class="grey lighter smaller">
											<span class="blue bigger-125">
												<i class="icon-random"></i>
												500
											</span>
											Something Went Wrong
										</h1>

										<hr />
										<h3 class="lighter smaller">
											But we are working
											<i class="icon-wrench icon-animated-wrench bigger-125"></i>
											on it!
										</h3>

										<div class="space"></div>

										<div>
											<h4 class="lighter smaller">Meanwhile, try one of the following:</h4>

											<ul class="list-unstyled spaced inline bigger-110 margin-15">
												<li>
													<i class="icon-hand-right blue"></i>
													Read the faq
												</li>

												<li>
													<i class="icon-hand-right blue"></i>
													Give us more info on how this specific error occurred!
												</li>
											</ul>
										</div>

										<hr />
										<div class="space"></div>

										<div class="center">
											<a href="${ctx}/admin/user/home" class="btn btn-grey">
												<i class="icon-arrow-left"></i>
												Go Back
											</a>
										</div>
									</div>
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div>
</body>
<!-- END BODY -->
</html>
