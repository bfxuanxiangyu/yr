
/*
 * 
 * 单独的关闭弹出框
 * @author xuanxy
 * 
 */
function closed(obj){
	$('.'+obj).dialog( "close" );
}

/*
 * 
 * 单独的打开弹出框
 * @author xuanxy
 * 
 */
function tankuang(obj){
	$('.'+obj).dialog( "open" );
	alert(obj);
}
/*
 * 
 * 树的打开弹出框
 * @author xuanxy
 * 
 */
function tankuang(obj,type){
	$('.'+obj).dialog( "open" );
	if(type='checkbox'){
		checkbox();
	}
	if(type='radio'){
		radio();
	}	
}