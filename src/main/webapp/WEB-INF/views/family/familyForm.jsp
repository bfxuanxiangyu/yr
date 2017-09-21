<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>野草科技</title>
</head>

<body>


<div class="row-fluid">
   <div class="span12">
       <!-- BEGIN THEME CUSTOMIZER-->
     <!-- END THEME CUSTOMIZER-->
    <!-- BEGIN PAGE TITLE & BREADCRUMB-->
     <h3 class="page-title"></h3>
     <ul class="breadcrumb">
         <li>
             <a href="#">系统管理</a>
             <span class="divider">/</span>
         </li>
         <li>
             <a href="${ctx}/family/">成员列表</a>
             <span class="divider">/</span>
         </li>
         <li class="active">
            	成员信息
         </li>
     </ul>
     <!-- END PAGE TITLE & BREADCRUMB-->
   </div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN PAGE CONTENT-->

<!-- BEGIN ADVANCED TABLE widget-->
<div class="row-fluid">
    <div class="span12">
    <!-- BEGIN EXAMPLE TABLE widget-->
    <!-- BEGIN BUTTON PORTLET-->
          <div class="widget-body">
              <form:form id="inputForm" modelAttribute="family" action="${ctx}/family/saveOrUpdate" 
              			method="post" class="form-horizontal" enctype="multipart/form-data">
				<input type="hidden" name="id" value="${family.id}"/>
				<input type="hidden" name="status" value="${family.status}"/>
				<div class="control-group more-col">
					<label class="control-label">中文姓名<span style="color: red">*</span></label>
					<div class="controls">
						<input type="text" id="chName" name="chName" value="${family.chName}" class="input-large required"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">英文姓名</label>
					<div class="controls">
						<input type="text" id="enName" name="enName" value="${family.enName}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">出生日期<span style="color: red">*</span></label>
					<div class="controls">
						<input type="text" id="birthday" name="birthday" value="${family.birthday}" class="input-large required"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">现在地址<span style="color: red">*</span></label>
					<div class="controls">
						<input type="text" id="address" name="address" value="${family.address}" class="input-large required"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label" >性别<span style="color: red">*</span></label>
					<div class="controls">
						<input type="radio" id="gender1" name="gender" value="0" <c:if test="${family.gender==0 || empty family.gender}"> checked="checked" </c:if> />男&nbsp;
						<input type="radio" id="gender2" name="gender" value="1" <c:if test="${family.gender==1}"> checked="checked" </c:if> />女&nbsp;
					</div>
				</div>
				<div class="control-group more-col">
					<label class="control-label">民族</label>
					<div class="controls">
						<input type="text" id="nation" name="nation" value="${family.nation}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">邮箱</label>
					<div class="controls">
						<input type="text" id="email" name="email" value="${family.email}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">手机<span style="color: red">*</span></label>
					<div class="controls">
						<input type="text" id="mobile" name="mobile" value="${family.mobile}" class="input-large required"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">QQ</label>
					<div class="controls">
						<input type="text" id="qq" name="qq" value="${family.qq}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">微信</label>
					<div class="controls">
						<input type="text" id="wx" name="wx" value="${family.wx}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">邮寄地址</label>
					<div class="controls">
						<input type="text" id="sendAddress" name="sendAddress" value="${family.sendAddress}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">邮寄邮编</label>
					<div class="controls">
						<input type="text" id="zipCode" name="zipCode" value="${family.zipCode}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">家中关系<span style="color: red">*</span></label>
					<div class="controls">
						<input type="text" id="relationship" name="relationship" value="${family.relationship}" class="input-large required"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">教育程度</label>
					<div class="controls">
						<input type="text" id="education" name="education" value="${family.education}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">银行卡号</label>
					<div class="controls">
						<input type="text" id="bankCard" name="bankCard" value="${family.bankCard}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">银行名称</label>
					<div class="controls">
						<input type="text" id="bankName" name="bankName" value="${family.bankName}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">银行地址</label>
					<div class="controls">
						<input type="text" id="bankAccount" name="bankAccount" value="${family.bankAccount}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">开户人姓名</label>
					<div class="controls">
						<input type="text" id="bankPerson" name="bankPerson" value="${family.bankPerson}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">开户人电话</label>
					<div class="controls">
						<input type="text" id="bankPersonMobile" name="bankPersonMobile" value="${family.bankPersonMobile}" class="input-large"/>
					</div>			
				</div>
				<div class="control-group more-col">
					<label class="control-label">头像上传</label>			
					<div class="controls">
						<input id="file" name="file" type="file"  class="input-large" /><br />
					</div>		
				</div>
				<div class="control-group">
					<label class="control-label" >过生日<span style="color: red">*</span></label>
					<div class="controls">
						<input type="radio" id="gregorian1" name="gregorian" value="0" <c:if test="${family.gregorian==0 || empty family.gregorian}"> checked="checked" </c:if> />过阴历&nbsp;
						<input type="radio" id="gregorian2" name="gregorian" value="1" <c:if test="${family.gregorian==1}"> checked="checked" </c:if> />过阳历&nbsp;
					</div>
				</div>
				<div class="control-group">
                    <label class="control-label" for="remark">个人说明</label>
                    <div class="controls">
                        <textarea class="input-xxlarge" rows="5" cols="100" id="content" name="content" >${family.content}</textarea>
                    </div>
                </div>
				<div class="control-group">
                    <label class="control-label" for="remark">备注</label>
                    <div class="controls">
                        <textarea class="input-xxlarge" rows="5" cols="100" id="remark" name="remark" >${family.remark}</textarea>
                    </div>
                </div>
				<div class="form-actions">
                      <button type="submit" class="btn blue"><i class="icon-ok"></i> Save</button>
                      <button type="button" class="btn" onclick="history.back()"><i class="icon-remove"></i> Cancel</button>
                  </div>
			</form:form>
          </div>
    </div>
</div>

<style type="text/css">
.zeusError{
	color: red;
}
.more-col{
	float:left;width: 50%;
}
.form-horizontal .controls{
	margin-left: 120px;
}
.form-horizontal .control-label{
	width: 100px;
}
</style>	
<!-- begin script -->	
<script>
	$(document).ready(function() {
		//聚焦第一个输入框
		$("#inputForm").validate();
		
	});
</script>
</body>
</html>
