$(function(){
	
	$("tr:eq(0)").css("background-color","#ffffff"); //标题的样式
	$("tr:gt(0):even").css("background-color","#ffffff"); //奇数行的样式
	$("tr:gt(0):odd").css("background-color","#f9f9f9"); //偶数行的样式
	$("tr:gt(0)").mouseenter(function(){
		var color = $(this).css("background-color");
		$(this).css("background-color","#fffadd");
		$(this).mouseleave(function(){
			$(this).css("background-color",color);
		});
		$(this).mousedown(function(){
			$(this).css("background-color","#fffadd");
		});
		$(this).mouseup(function(){
			$(this).css("background-color","#fffadd");
		});	
	});
});