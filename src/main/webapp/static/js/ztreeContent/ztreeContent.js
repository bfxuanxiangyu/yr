
/**
 * 打开是复选框
 */
function checkbox(){
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
	$.fn.zTree.init($("#treeCheckbox"), setting, zNodes);
	var code;
	var zTree = $.fn.zTree.getZTreeObj("treeCheckbox"),
	type = { "Y" : "ps", "N" : "ps"};
	zTree.setting.check.chkboxType = type;
	$("#treeCheckbox").click(GetCheckedAll);
}
/**
 * 打开是单选按钮
 * @return
 */
function radio(){
	var setting = {
			check: {
				enable: true,
				chkStyle: "radio",
				radioType: "level"
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
     	{ id:221, pId:22, name:"随意勾选 2-2-1"},
     	{ id:222, pId:22, name:"随意勾选 2-2-2"},
     	{ id:23, pId:2, name:"随意勾选 2-3"}
     ];
	var type = "all";
	setting.check.radioType = type;
	$.fn.zTree.init($("#treeRadio"), setting, zNodes);
	$("#treeRadio").click(GetRadioCheckedAll);
}
//获取复选所有选中节点的值
function GetCheckedAll() {
	var treeObj = $.fn.zTree.getZTreeObj("treeCheckbox");
	var nodes = treeObj.getCheckedNodes(true);
	var msg = "";
	for (var i = 0; i < nodes.length; i++) {
		msg += "名称="+nodes[i].name+"**id="+nodes[i].id+"**pid="+nodes[i].pId+"\r";
	}
	$("#msg").val();
	$("#msg").val(msg);
}
//获取单选所有选中节点的值
function GetRadioCheckedAll() {
    var treeObj = $.fn.zTree.getZTreeObj("treeRadio");
    var nodes = treeObj.getCheckedNodes(true);
    var msg = "";
    for (var i = 0; i < nodes.length; i++) {
        msg += "名称="+nodes[i].name+"**id="+nodes[i].id+"**pid="+nodes[i].pId+"；";
    }
    $("#msgRadio").val();
    $("#msgRadio").val(msg);
}