<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"  %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
   <meta charset="utf-8" />
   <title>野草科技</title>
</head>
 
<div class="row-fluid">
    <div class="span12" style="margin-top: 25px;">
		 <c:if test="${not empty message}">
			<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
		</c:if>
		<div style="padding-bottom: 15px;">
			<button class="btn  btn-info" type="button" onclick="window.location.href='${ctx}/family/create'">新增成员</button>
		</div>
		<form id="form" action="${ctx}/family/" class="hidden-phone">
             <div class="input-append search-input-area">
                 <input type="text" class="search-query" placeholder="Search" style="border-left: 0px solid #fff !important"
                 		id="search_info" name="search_info" value="${params.info}" />
                 <button class="btn" type="submit"><i class="icon-search"></i> </button>
             </div>
         </form>
         <%-- <form id="form" action="${ctx}/family/">
			<input type="text" class="search-query" placeholder="Search" id="search_info" name="search_info" value="${params.info}" />
			<button class="btn btn-primary" type="submit">快速搜索</button>
		</form> --%>
         <table class="table table-striped table-bordered table_pad table_custom" id="sample_1" style="table-layout:fixed;">
             <thead>
             <tr>
                 <th>姓名</th>
                 <th>地址</th>
                 <th>出生日期</th>
                 <th>电话</th>
                 <th>QQ</th>
                 <th>微信</th>
                 <th>家中关系</th>
                 <th width="15%">操作</th>
             </tr>
             </thead>
             <tbody>
             <c:forEach items="${familys.content}" var="family">
             	<tr class="odd gradeX">
                    <td title="${family.chName}">${family.chName}</td>
                    <td title="${family.address}">${family.address}</td>
                    <td title="${family.birthday}">${family.birthday}</td>
                    <td title="${family.mobile}">${family.mobile}</td>
                    <td title="${family.qq}">${family.qq}</td>
                    <td title="${family.wx}">${family.wx}</td>
                    <td title="${family.relationship}">${family.relationship}</td>
                    <td>
						<a href="${ctx}/family/detail/${family.id}"><span class="label">详情</span></a>
					  	&nbsp;|&nbsp;
						<a href="${ctx}/family/update/${family.id}"><span class="label label-success">编辑</span></a>
					  	&nbsp;|&nbsp;
					  	<a href="${ctx}/family/delete/${family.id}"><span class="label label-warning">删除</span></a>
					</td>
              	</tr>    
			</c:forEach>
             </tbody>
         </table>
         <tags:pagination page="${familys}" paginationSize="5"/>

    </div>
</div>

<script type="text/javascript">
 

 </script>
<style type="text/css">
   		table td{
			overflow:hidden;white-space:nowrap;text-overflow:ellipsis;
		}
   </style>
</body>
<!-- END BODY -->
</html>
