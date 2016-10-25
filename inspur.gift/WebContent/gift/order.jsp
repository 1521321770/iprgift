<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="js/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/dhome.css" rel="stylesheet" type="text/css">
<link href="css/signin.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="js/alerts/css/jquery.alerts.css"/>
<link href="js/loadmask/jquery.loadmask.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="./favicon.ico" type="image/x-icon"/> 
<link rel="shortcut icon" href="./favicon.ico" type="image/x-icon"/> 
<link rel="bookmark" href="./favicon.ico" type="image/x-icon"/> 

<title>浪潮信息员工礼物选购</title>

<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/common/util.js"></script>
<script type="text/javascript" src="gift/order.js"></script>
</head>
<body>
	<table style="width:665px;height:140px " >
        <tr>
        	<td width="25%"></td>
        	<td></td>
        </tr>
	</table>
<!-- 登录框 -->
    <div id="loginSystem" class="ism_login2" style="padding-top:20px;">
      <form class="form-signin form-horizontal" role="form">
        <div class="form-group">
          <label class="col-sm-3 control-label" >姓名：</label>
          <div class="col-sm-9">
            <input class="form-control" id="userName" name="userName"   value="" type="text" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label" >邮箱名：</label>
          <div class="col-sm-9">
            <input class="form-control" id="mailName" name="mailName"   value="" type="text" />
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label" >部门：</label>
          <div class="col-sm-9">
            <select class="form-control" id="bumen" >
            </select>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label" >工作地：</label>
          <div class="col-sm-9">
            <select class="form-control" id="place" >
            </select>
          </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label">礼物：</label>
          <div class="col-sm-9">
            <select class="form-control" id="gift">
            </select>
          </div>
        </div>
        <div id="addressDiv">
        <div class="form-group" >
          <label class="col-sm-3 control-label">手机：</label>
          <div class="col-sm-9">
          <input id="userPhone" class="form-control"  value="" type="text" />
          </div>
        </div>
        <div class="form-group" >
          <label class="col-sm-3 control-label">地址：</label>
          <div class="col-sm-9">
          <textarea id="userAddress" class="form-control"></textarea>
          </div>
        </div>
        </div>
         <button id="order" type="button"  class="btn btn-default btn-operat btn-long">确定</button>
       </form>
     </div>
	 <div style="position:absolute;width:550px;height:300px;left:150px">
         <table>
         	<tr>
         		<td >
         		<ul id="imgUl"></ul>
         		</td>
         	</tr>
         	<tr >
         		<td id="descontenets"></td>
         	</tr>
         </table>
	</div>
</body>
</html>
