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
   <title>新增用户</title>
</head>
 
<div class="row-fluid">
    <div class="span12" style="margin-top: 25px;">
		 <c:if test="${not empty message}">
			<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
		</c:if>
		<shiro:hasPermission name="user:edit">
			<div style="padding-bottom: 15px;">
				<button class="btn  btn-info" type="button" onclick="window.location.href='${ctx}/admin/user/create'">新增用户</button>
			</div>
		</shiro:hasPermission>	
         <table class="table table-striped table-bordered table_pad" id="sample_1">
             <thead>
             <tr>
                 <th width="3%"><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" /></th>
                 <th width="8%">登录名</th>
                 <th width="8%" class="hidden-phone">用户名</th>
                 <th width="10%" class="hidden-phone">角色</th>
                 <th width="20%" class="hidden-phone">注册时间</th>
                 <th width="15%" class="hidden-phone">操作</th>
             </tr>
             </thead>
             <tbody>
             <c:forEach items="${users.content}" var="user">
             	<tr class="odd gradeX">
               <td><input type="checkbox" name="checkboxName" class="checkboxes" value="${user.id}" /></td>
                  <td>${user.loginName}</td>
                  <td class="hidden-phone">${user.name}</td>
                  <td class="hidden-phone">${user.permissionName}</td>
                  <td class="center hidden-phone"><fmt:formatDate value="${user.createdTime}" pattern="yyyy年MM月dd日  HH时mm分ss秒" /></td>
                  <td class="hidden-phone">
                  	<shiro:hasPermission name="user:edit"> 
<%-- 	                    	${ctx}/admin/user/update/${user.id} --%>
					  	<a href="${ctx}/admin/user/update/${user.id }?index=systemId"><span class="label label-success">编辑</span></a>
					  	&nbsp;|&nbsp;
					  	<a href="${ctx}/admin/user/delete/${user.id }?index=systemId"><span class="label label-warning">删除</span></a>
					  	&nbsp;|&nbsp;
					  	<a href="#myModal1${user.id }" data-toggle="modal"><span class="label">修改密码</span></a>
				</shiro:hasPermission>
                  </td>
              </tr>
              
              <div id="myModal1${user.id }" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
	             <div class="modal-header">
	                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                 <h3 id="myModalLabel1">修改密码</h3>
	             </div>
	             <div class="modal-body">
					<div class="control-group">
						<label class="control-label">请输入新密码:</label>
						<div class="controls">
							<input type="password" id="plainPassword${user.id }" name="plainPassword"  class="input-large required"/>
						</div>			
					</div>
					<div class="control-group">
						<label class="control-label">新密码确认:</label>
						<div class="controls">
							<input type="password" id="repeatPassword${user.id }"   class="input-large required" onblur="checkRepate(${user.id })"/>
							<label id="warn${user.id }" style="color: red;display: none;">两次密码不一致!</label>
							<label id="isnull${user.id }" style="color: red;display: none;">密码必填</label>
						</div>			
					</div>
					
	             </div>
	             <div class="modal-footer">
	                 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	                 <button class="btn btn-primary" onclick="subForm('${user.id }')" id="savepwd">保存</button>
	             </div>
         	</div>    
	</c:forEach>
             </tbody>
         </table>
         <tags:pagination page="${users}" paginationSize="5"/>

    </div>
</div>
<form id="upPasswordForm" modelAttribute="AdminUser" action="${ctx}/admin/user/updatePassword" 
              			method="post" class="form-horizontal" enctype="multipart/form-data">
			         <input type="hidden" id="newpwd" name="plainPassword"  class="input-large required"/>	
			         <input type="hidden" id="auid" name="id"   class="input-large required"/>	
				</form>

<script type="text/javascript">
 
function disable(){
	var obj=document.getElementsByName('checkboxName'); //选择所有name="'test'"的对象，返回数组 
	//取到对象数组后，我们来循环检测它是不是被选中 
	var s=''; 
	for(var i=0; i<obj.length; i++){ 
		if(obj[i].checked) s+=obj[i].value+','; //如果选中，将value添加到变量s中 
	} 
	//那么现在来检测s的值就知道选中的复选框的值了 
	if(s != ''){
		s = s.substr(0,s.length-1);
	}
	alert(s==''?'你还没有选择任何内容！':s); 
}

function showIcon(icon,showBody){
	if($("#"+icon).hasClass("icon-chevron-down")){
		jQuery("#"+icon).removeClass("icon-chevron-down").addClass("icon-chevron-up");
		$("#"+showBody).slideUp(400);
	}else{
		jQuery("#"+icon).removeClass("icon-chevron-up").addClass("icon-chevron-down");
		$("#"+showBody).slideDown(400);
	}
}
function removesIcon(showBody){
	$("#"+showBody).remove();
}
function subForm(id){
	$("#newpwd").val($("#plainPassword"+id).val());
	$("#auid").val(id);
	if(checkRepate(id)){
		$("#savepwd").attr("data-dismiss","modal");
		$("#savepwd").attr("data-dismiss","true");
		$("#upPasswordForm").submit();
		alert("已修改");
	}else{
		$("#savepwd").removeAttr("data-dismiss");
		$("#savepwd").removeAttr("data-dismiss");
		//return;data-dismiss="modal" aria-hidden="true"
	}
}
function checkRepate(id){
	var plainpwd = $("#plainPassword"+id).val();
	var reppwd = $("#repeatPassword"+id).val();
	if(plainpwd != reppwd){
		$("#warn"+id).css('display','inline');
		$("#isnull"+id).css('display','none');
		return false;
	}else if(plainpwd == "" && reppwd == ""){
		$("#isnull"+id).css('display','inline');
		$("#warn"+id).css('display','none');
		return false;
	}else{
		$("#warn"+id).css('display','none');
		$("#isnull"+id).css('display','none');
		return true;
	}
}


 </script>

</body>
<!-- END BODY -->
</html>
