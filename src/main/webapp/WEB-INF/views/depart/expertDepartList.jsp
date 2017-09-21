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
		<div><a class="btn" href="${ctx}/depart/create">新增科室</a></div><br/>
		<form id="form" action="${ctx}/depart/">
			科室名称<input id="search_info" name="search_info" value="${params.info}" />
			是否删除
			<select id="search_deleteFlag" name="search_deleteFlag">
				<option value="" >--请选择--</option>
				<option value="0" <c:if test="${params.deleteFlag=='0'}">selected='selected'</c:if>>未删除</option>
				<option value="1" <c:if test="${params.deleteFlag=='1'}">selected='selected'</c:if>>已删除</option>
			</select>
			<button type="submit" class="btn btn-sm red">快速搜索</button>
		</form>
         <table class="table table-striped table-bordered table_pad table_custom" id="sample_1" style="table-layout:fixed;">
             <thead>
             <tr>
                 <th>科室名称</th>
                 <th>顺序</th>
                 <th>状态</th>
                 <th width="15%">操作</th>
             </tr>
             </thead>
             <tbody>
             <c:forEach items="${expertDeparts.content}" var="expertDepart">
             	<tr class="odd gradeX">
                    <td title="${expertDepart.cDepartments}">${expertDepart.cDepartments}</td>
                    <td title="${expertDepart.cSort}">${expertDepart.cSort}</td>
                    <td>
                    	<c:choose>
                    		<c:when test="${expertDepart.cDeleteFlag==0}">未删除</c:when>
                    		<c:when test="${expertDepart.cDeleteFlag==1}"><span style="color: red;">已删除</span></c:when>
                    		<c:otherwise>
                    			未知
                    		</c:otherwise>
                    	</c:choose>
                    </td>
                    <td>
						<a href="${ctx}/depart/update/${expertDepart.id}"><span class="label label-success">编辑</span></a>
					  	&nbsp;|&nbsp;
					  	<a href="${ctx}/depart/delete/${expertDepart.id}"><span class="label label-warning">删除</span></a>
					</td>
              	</tr>    
			</c:forEach>
             </tbody>
         </table>
         <tags:pagination page="${expertDeparts}" paginationSize="5"/>

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
