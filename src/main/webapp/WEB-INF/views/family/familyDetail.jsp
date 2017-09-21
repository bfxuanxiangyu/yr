<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>野草科技 </title>
</head>

<body>
<h1>
	<span style="color: red">${family.chName}</span>详情
</h1>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
		<tbody>
		
		<tr>
			<th colspan="8" style="text-align: center; ">个人信息</th>
		</tr>
		<tr>
			<th>姓名</th><td style="width: 10%;">${family.chName}</td>
			<th>英文名称</th><td style="width: 10%;">${family.enName}</td>
			<th>性别</th>
			<td style="width: 10%;">
				<c:choose>
		       		<c:when test="${family.gender==0}">男</c:when>
		       		<c:when test="${family.gender==1}">女</c:when>
		       		<c:otherwise>
		       			未知
		       		</c:otherwise>
	          	</c:choose>
			</td>
			<th colspan="2" rowspan="5" style="text-align: center;">
				<img alt="暂无" src="${family.avatar}" style="width: 150px; height: 160px;">
			</th>
		</tr>
		<tr>
			<th>手机</th><td style="width: 10%;">${family.mobile}</td>
			<th>QQ</th><td style="width: 10%;">${family.qq}</td>
			<th>微信</th><td style="width: 10%;">${family.wx}</td>
		</tr>
		<tr>
			<th>民族</th><td style="width: 10%;">${family.nation}</td>
			<th>住址</th><td colspan="3">${family.address}</td>
		</tr>
		<tr>
			<th>邮编</th><td style="width: 10%;">${family.zipCode}</td>
			<th>邮寄地址</th><td colspan="3">${family.sendAddress}</td>
		</tr>
		<tr>
			<th>出生日期</th><td style="width: 10%;">${family.birthday}</td>
			<th>教育</th><td style="width: 10%;">${family.education}</td>
			<th>邮箱</th><td style="width: 10%;">${family.email}</td>
		</tr>
		
		<tr>
			<th colspan="8" style="text-align: center; ">银行卡信息</th>
		</tr>
		<tr>
			<th>卡号</th><td style="width: 10%;">${family.bankCard}</td>
			<th>开户行</th><td style="width: 10%;">${family.bankName}</td>
			<th>开户人姓名</th><td style="width: 10%;">${family.bankPerson}</td>
			<th>开户人电话</th><td style="width: 10%;">${family.bankPersonMobile}</td>
		</tr>
		<tr>
			<th>开户支行地址</th><td colspan="7">${family.bankAccount}</td>
		</tr>
		
		
		<tr>
			<th colspan="8" style="text-align: center; ">个人简介</th>
		</tr>
		<tr>
			<td colspan="8">${family.content}</td>
		</tr>
		
		<tr>
			<th colspan="8" style="text-align: center;">备注信息</th>
		</tr>
		<tr>
			<td colspan="8">${family.remark}</td>
		</tr>
		
		
		
		
		</tbody>
		</thead>
		
		
	</table>
	<div class="form-actions">	
		<input id="cancel_btn" class="btn" type="button" value="返回" onclick="showClick('${ctx}/family/');" />
		<input id="cancel_btn" class="btn" type="button" value="打印" onclick="printit();" />
	</div>
	<style type="text/css">
	     tr td{
	     	color: #000000;
	     }
	</style>
	<script type="text/javascript">
	 function showClick(url){
		 window.location.href=url;
	 }
	 
	 function printit() {  
		 if (confirm('确定打印吗？')){  
			 bdhtml=window.document.body.innerHTML;//获取当前页的html代码  
			 sprnstr="<table";//设置打印开始区域  
			 eprnstr="</table>";//设置打印结束区域  
			 prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)); //从开始代码向后取html  
			   
			 prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html  
			 window.document.body.innerHTML=prnhtml;  
			 window.print();  
			 window.document.body.innerHTML=bdhtml;  
		 }  
	 }
	</script>
</body>
</html>
