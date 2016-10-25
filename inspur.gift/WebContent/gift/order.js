var $ = jQuery.noConflict();

/**
 * 登录
 */
jQuery().ready(function(){
	$("#addressDiv").hide();
//	getOrderStatus();
//	setInterval(getOrderStatus, 10000);
	getBuMenList();
	getPlaceList();

	$("#place").change(function(){
		var uuid=getSelAttr("place","value");
		if (uuid != "-1"){
			getGiftByPlace(uuid);
			if(imgVal=="其他"){
				$("#addressDiv").show();
			}else{
				$("#addressDiv").hide();
				var kong="";
				$("#userPhone").val(kong);
		        $("#userAddress").val(kong);
		        
			}
		}else if(imgVal=="-1"){
			alert("请选择工作地！！！")
			var gift = $("#gift");
			gift.empty();
			$("#addressDiv").hide();
		} 
		
	});

	$("#gift").change(function(){
		var imgValAddr=getSelAttr("place","value");
		var imgVal=getSelAttr("gift","value");
		if(imgVal){
			$('li.'+imgVal).show().siblings().hide();
			var des=$('li.'+imgVal).attr("desc");
			$("#descontenets").html("");
			if(des!=undefined&&des!="undefined"){
				var text="<textarea id='textarea' style='width:400px;height:200px;overflow-x:hidden;overflow-y:hidden;resize:none;background-color:transparent;border:0px;color:black;text-indent:28px; line-height:150%;font-size:14px;' readonly>" 
					+des+
				    "</textarea>";
			    $("#descontenets").append(text);
			}
			
		}
	});

	$("#order").click(function(){
        var userName = $.trim($("#userName").attr("value"));
        var mailName = $.trim($("#mailName").attr("value"));
        var bumen = $("#bumen").val();
        var gift = $("#gift option:selected").val();
        var place = $("#place").val();
        var telephone = $("#userPhone").val();
        var address = $("#userAddress").val();
        if(userName == ""){
        	alert("亲，叫啥名字啊？");
        	$("#userName").focus();
        	return;
        }
        if(mailName == ""){
        	alert("亲，这个邮箱必须填，不然发错礼物咋办？");
        	$("#mailName").focus();
        	return;
        }
        var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");
        if(reg.test(mailName)){
        	alert("亲，邮箱名是不是写错了。。。");
        	$("#mailName").focus();
        	return;
        }
        if(bumen == "-1"){
        	alert("亲，哪的人啊？");
        	$("#bumen").focus();
        	return;
        }
        if(gift == "-1"){
        	alert("亲，你想要啥生日礼物？");
        	$("#gift").focus();
        	return;
        }
        if(place == ""){
        	alert("亲，礼物送到那个地方啊？");
        	$("#place").focus();
        	return;
        }
        saveGiftOrder(userName, mailName, bumen, gift, place, address, telephone);
	});
});


//获得部门列表
function getBuMenList(){
	$.ajax({
		url : "http://localhost:8080/inspur.gift/gift/bumen/action/search.do",
		type : "POST",
		data : {
			},
		success : function(data){
			if (data.flag) {
				var bumen = $("#bumen");
				var option = $("<option>").text("请选择").val("-1");
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


//获得工作地列表
function getPlaceList(){
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/inspur.gift/gift/workplace/action/search.do", 
		success:function(data){
			var place = $("#place");
			var option = $("<option>").text("请选择").val("-1");
			place.append(option);
			if (data.flag) {
				var placeList = data.resData;
				for(var i in placeList){
					var uuid = placeList[i].id;
					var name = placeList[i].name;
					var option = $("<option>").text(name).val(uuid);
					place.append(option);
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


//根据工作地得到礼物列表
function getGiftByPlace(uuid){
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/inspur.gift/gift/gift/action/search.do", 
		data:{
			searchType : "2",
			placeId : uuid
        },
		success:function(data){
			if (data.flag) {
				var giftList = data.resData;
				var divId_gift = $("#gift");
				var descontenets = $("#descontenets");
				var imgPanel = $("#imgUl");
				
				divId_gift.empty();
				imgPanel.html("");
				descontenets.html("");
				
				var option = $("<option>").text("请选择").val("-1");
				divId_gift.append(option);
				for (var i in giftList) {
					var object_gift = giftList[i];
					var option = $("<option>").text(object_gift.name).val(object_gift.id);
					divId_gift.append(option);

					var mm = object_gift.imgUrl;
					var imgliother = "<li class=" + object_gift.id
						+ " style='display:none' desc='" + object_gift.description+"'>"
						+ "<img src='images/"+mm+".jpg' width = 550 height = 300 />"+"<p></p>"
						+ "</li>";
					imgPanel.append(imgliother);  
				}
			}
		},
		error : function(data){
			alert("根据工作地获取礼物，RestAPI接口调用失败");
		}
	});
}


//提交订单
function saveGiftOrder(userName, mailName, bumen, gift, place, address, telephone){
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/inspur.gift/gift/order/action/add.do", 
        data:{
        	name:userName,
        	mailbox:mailName,
        	bumen:bumen,
        	gift:gift,
        	place:place,
        	address:address,
        	telephone:telephone
        },
        success:function(data){
        	if(data.flag){
        		alert("生日礼物订购成功");
        	}else{
        		alert(data.resData);
        	}
        	
        },
        error:function (){
        	alert("提交生日礼物订单，RestAPI接口调用失败");
        }
	});                  
}


//是否可以选取礼物
//function getOrderStatus(){
//	$.ajax({
//		type:"POST",
//		dataType:"json",
//		contentType: "application/x-www-form-urlencoded; charset=utf-8",
//        url:"getOrderStatus.do?timestamp=" + (new Date()).getTime(), 
//        success:function(data){
//        	var order = $("#order");
//        	if(data == "1" || data == 1){
//        		order.attr("disabled",false);
//        		order.html("确定");
//        	}else {
//        		order.attr("disabled","disabled");
//        		order.html("亲，来晚了，活动结束了。。。");
//        	}
//        }
//	});
//}
