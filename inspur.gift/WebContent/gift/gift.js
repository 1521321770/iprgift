var $ = jQuery.noConflict();

jQuery().ready(function(){
	$("#but_bunem_save").click(function(){
		bumen_save();
	});
	
	$("#but_bunem_search").click(function(){
		bumen_search();
	})
})

/**
 * 添加部门
 */
function bumen_save(){
	var name = document.getElementById('bumen').value;
	$.ajax({
		url : "http://localhost:8080/inspur.gift/gift/bumen/action/add.do",
		type : "post",
		data : {
			"name" : name
		},
		success : function(data){
			alert(data.flag)
			alert("添加成功")
		},
		error : function(data){
			alert("保存失败");
		}
	})
}

/**
 * 查看部门信息
 */
function bumen_search(){
	$.ajax({
		url : "http://localhost:8080/inspur.gift/gift/bumen/action/search.do",
		type : "post",
		data : {
		},
		success : function(data){
//			var lists = data;
//			Console(lists)
//			for (var i=0; i< data.lenth(); i++ ){
//				alert("000000")
//				alert(data[i].name)
//			}
		},
		error : function(data){
			alert("保存失败");
		}
	})
}
