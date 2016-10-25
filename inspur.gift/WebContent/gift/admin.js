var $ = jQuery.noConflict();

var datas = [];
var example;
jQuery().ready(function(){
	loadWorkPlaceList();
	loadBumenList();
	loadGiftList();
	loadOrderList();
	$("#modifyOrder").click(modifyBtn);
	$("#deleteOrder").click(deleteBtn);
	$("#orderCheckAll").click(function(){
		var _this = this;
	    if ($(this).get(0).checked) {
	        $("input[name='checkboxList']").each(function() {
	        	this.checked = _this.checked
	        });
	    } else {
	    	$("input[name='checkboxList']").each(function() {
	        	this.checked = _this.checked
	        });
	    }
	});
	$("#dataTable_example").click(function(ev) {
		var target = ev.target;
		if(target.tagName === "INPUT" && target.name === "checkboxList") {
			var checkedAll = true;
			$("input[name='checkboxList']").each(function() {
				if(!this.checked) {
					checkedAll = false;
				}
			});
			$("#orderCheckAll").get(0).checked = checkedAll;
		}
	});
})

//加载页面时，初始化工作地列表
function loadWorkPlaceList(){
	doRestCall({
		restUrl:"inspur.gift/gift/workplace/action/search.do",
		method:"POST",
		data:{

        },
	    callback:function(response){
	    	alert("0000000000");
	    },
	    success:function(response){
	    	var workPlace = $("#workPlace");
			var option = $("<option> selected='selected'").text("所有").val("-1");
			workPlace.append(option);
//			var resData = response["resData"] || {};
			if (response.flag) {
				var placeList = response.resData;
				for(var i in placeList){
					var uuid = placeList[i].id;
					var name = placeList[i].name;
					var option = $("<option>").text(name).val(uuid);
					workPlace.append(option);
				}
			} else {
				alert(data.msgCode + "==" + data.resData);
			}
	    },
	    error : function(data){
	    	alert("获取工作地列表，RestAPI接口调用失败");
	    }
	});
}

//初始化时，加载部门列表
function loadBumenList(){
	$.ajax({
		url : "http://localhost:8080/inspur.gift/gift/bumen/action/search.do",
		type : "POST",
		data : {
			},
		success : function(data){
			if (data.flag) {
				var bumen = $("#bumen");
				var option = $("<option>").text("所有").val("-1");
				bumen.append(option);
				var keys = [];
				var bumenList = data.resData;
				for(var i in bumenList){
					var uuid = bumenList[i].id;
					var name = bumenList[i].name;
					var option = $("<option>").text(name).val(uuid);
					bumen.append(option);
				}
			} else {
				alert(data.msgCode + "==" + data.resData);
			}
		},
		error : function(data){
			alert("获取部门列表，RestAPI接口调用失败");
		}
	});
}

//初始化时，加载礼物列表
function loadGiftList(){
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/inspur.gift/gift/gift/action/search.do", 
		data:{
			searchType : "1",
			placeId : "sadfasd"
        },
		success:function(data){
			if (data.flag) {
				var giftList = data.resData;
				var gift = $("#gift");				
				var option = $("<option>").text("请选择").val("-1");
				gift.append(option);
				for (var i in giftList) {
					var object_gift = giftList[i];
					var option = $("<option>").text(object_gift.name).val(object_gift.id);
					gift.append(option);
				}
			} else {
				alert(data.msgCode)
			}
		},
		error : function(data){
			alert("根据礼物列表，RestAPI接口调用失败");
		}
	});
}

//初始化时，加载订单列表
function loadOrderList(){
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/inspur.gift/gift/order/action/list.do", 
		success:function(data){
			if (data.flag) {
				var resData = data.resData;
				example = $("#dataTable_example");
				example.dataTable({
					"lengthChange": false, //允许改变每页显示的数据条数
					"paging": true,     //允许表格分页
					"pagingType": "full_numbers",	//分页按钮种类显示选项
					"searching":false,  //不显示search框
					"data": resData,
					"columns": [
						{"mDataProp": "id",
						"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
							$(nTd).html("<input type='checkbox' name='checkboxList' value='" + sData + "'>");
							}
						},
				        {"data": "name"},
				        {"data": "mailbox"},
				        {"data": "bumen"},
				        {"data": "gift"},
				        {"data": "place"},
				        {"data": "address"},
				        {"data": "telephone"}
				      ],
				      "oLanguage": {//插件的汉化  
				    	  "sLengthMenu": "每页 _MENU_ 条数据",
				    	  "sZeroRecords": "抱歉，没有找到",
				    	  "sInfo": "_START_ 到 _END_ /共 _TOTAL_ 条数据",
				    	  "sInfoEmpty": "没有数据",
				    	  "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
				    	  "oPaginate": {
				    		  "sFirst": "首页",
				    		  "sPrevious": "前一页",
				    		  "sNext": "后一页",
				    		  "sLast": "尾页"},
				      },
				});
			} else {
				alert(data.msgCode)
			}
		},
		error : function(data){
			alert("查询订单列表，RestAPI接口调用失败");
		}
	});
}

//删除按钮
function deleteBtn() {
	var str = '';
	$("input[name='checkboxList']:checked").each(function (i, o) {
		str += $(this).val();
		str += ",";
	});
	if (str.length > 0) {
		var ids = str.substr(0, str.length - 1);
		deleteOrder(ids);
	} else {
		alert("至少选择一条记录操作");
	}
}

//修改按钮
function modifyBtn() {
	var str = '';
	$("input[name='checkboxList']:checked").each(function (i, o) {
		str += $(this).val();
		str += ",";
	});
	if (str.length > 0) {
		var IDS = str.substr(0, str.length - 1);
	} else {
		alert("至少选择一条记录操作");
	}
}

//删除一条记录
function deleteOrder(ids) {
	alert("你要修改的数据集id为" + ids);
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/inspur.gift/gift/order/action/delete.do", 
		data:{
			ids : ids
        },
		success:function(data){
			if (data.flag) {
				var giftList = data.resData;
				var gift = $("#gift");				
				var option = $("<option>").text("请选择").val("-1");
				gift.append(option);
				for (var i in giftList) {
					var object_gift = giftList[i];
					var option = $("<option>").text(object_gift.name).val(object_gift.id);
					gift.append(option);
				}
			} else {
				alert(data.msgCode)
			}
		},
		error : function(data){
			alert("根据礼物列表，RestAPI接口调用失败");
		}
	});
}

//$.ajax({
//type:"POST",
//url:
//success:function(data){
//	var workPlace = $("#workPlace");
//	var option = $("<option> selected='selected'").text("所有").val("-1");
//	workPlace.append(option);
//	if (data.flag) {
//		var placeList = data.resData;
//		for(var i in placeList){
//			var uuid = placeList[i].id;
//			var name = placeList[i].name;
//			var option = $("<option>").text(name).val(uuid);
//			workPlace.append(option);
//		}
//	} else {
//		alert(data.msgCode + "==" + data.resData);
//	}
//},
//error : function(data){
//	alert("获取工作地列表，RestAPI接口调用失败");
//}
//});