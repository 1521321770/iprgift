var $ = jQuery.noConflict();

jQuery().ready(function(){
	$(".wrapper").addClass('form-success');
	$("#login-button").click(function(event){
		event.preventDefault();
		$("form").fadeOut(500);
		sendUrl_login();
	});
});

/**
 * 发送用户的输入信息
 */
function sendUrl_login(){
	var userName = document.getElementById('login_user').value;
	var mailbox = document.getElementById('mailbox').value;
	var bumen = document.getElementById('bumen').value;
	$.ajax({
		url : "http://localhost:8080/inspur.gift/gift/employee/birthday/action/login.do",
		type : "post",
		data : {
			"name" : userName,
			"mailbox" : mailbox,
			"bumen" : bumen
			},
		success : function(data){
			login_callback(data)
			},
		error : function(data){
			alert("登陆失败");
			}
		});
}

/**
 * “发送用户的输入信息” 的回调函数
 * @param data
 */
function login_callback(data) {   
	var flag = data.flag
	alert(flag)
	if(flag){ 
		window.location.href="/inspur.gift/gift/gift.jsp"
	}else{
		alert("用户名或密码错误")
	}
}