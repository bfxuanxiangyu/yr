<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<HTML>
<HEAD>
	<TITLE> ZTREE DEMO - checkbox</TITLE>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<SCRIPT type="text/javascript">
/*
 * 
 function createTree () {
     var zNodes;
     $.ajax({
         url: 'Handler.ashx?action=GetModule', //url  action是方法的名称
         data: { id: "11" },
         type: 'POST',
         dataType: "text", //可以是text，如果用text，返回的结果为字符串；如果需要json格式的，可是设置为json
         ContentType: "application/json; charset=utf-8",
         success: function (data) {
             zNodes = data;
             
             $.fn.zTree.init($("#treeDemo"), setting, eval('(' + zNodes + ')'));

         },
         error: function (msg) {
             alert("失败");
         }
     });
 }
 */

	
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};
		var zNodes =[
			{ id:1, pId:0, name:"随意勾选 1", open:true},
			{ id:11, pId:1, name:"随意勾选 1-1", open:true},
			{ id:111, pId:11, name:"随意勾选 1-1-1"},
			{ id:112, pId:11, name:"随意勾选 1-1-2"},
			{ id:12, pId:1, name:"随意勾选 1-2", open:true},
			{ id:121, pId:12, name:"随意勾选 1-2-1"},
			{ id:122, pId:12, name:"随意勾选 1-2-2"},
			{ id:2, pId:0, name:"随意勾选 2", open:true},
			{ id:21, pId:2, name:"随意勾选 2-1"},
			{ id:22, pId:2, name:"随意勾选 2-2", open:true},
			{ id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
			{ id:222, pId:22, name:"随意勾选 2-2-2"},
			{ id:23, pId:2, name:"随意勾选 2-3"}
		];
		var code;
		function setCheck() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			type = { "Y" : "ps", "N" : "ps"};
			zTree.setting.check.chkboxType = type;
			showCode('setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };');
		}
		function showCode(str) {
			if (!code) code = $("#code");
			code.empty();
			code.append("<li>"+str+"</li>");
		}
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			setCheck();
			 $("#treeDemo").click(GetCheckedAll);
		});
		//获取所有选中节点的值
	    function GetCheckedAll() {
	        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	        var nodes = treeObj.getCheckedNodes(true);
	        var msg = "";
	        for (var i = 0; i < nodes.length; i++) {
	            msg += "名称="+nodes[i].name+"**id="+nodes[i].id+"**pid="+nodes[i].pId+"；";
	        }
	        $("#msg").val();
	        $("#msg").val(msg);
	    }
	</SCRIPT>
</HEAD>

<BODY>
	<div id="treeDemo" class="ztree"></div>
	<input type="text" id="msg" value="" style="width: 900px; height: 100px;"/>
</BODY>
</HTML>
