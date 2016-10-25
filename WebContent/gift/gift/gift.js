var $ = jQuery.noConflict();

jQuery().ready(function(){
	loadGiftList();
})

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
				var resData = data.resData;
				$("#dataTable_gift").dataTable({
					"lengthChange": false, //允许改变每页显示的数据条数
					"paging": true,     //允许表格分页
					"pagingType": "full_numbers",	//分页按钮种类显示选项
					"searching":false,  //不显示search框
					"data": resData,
					"columns": [
					    {"mRender": function (data, type, full) {
					    		sReturn = '<input id="iDataTableChk" type="checkbox" value="1" />';
					    		return sReturn;
					    	},
					    	"sClass": "checkboxes"
					    },
				        {"data": "name"},
				        {"data": "createrName"},
				        {"data": "imgUrl"},
				        {"data": "places"},
				        {"data": "description"},
				        {"data": "updateTime"},
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
			alert("根据礼物列表，RestAPI接口调用失败");
		}
	});
}