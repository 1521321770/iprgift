<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/menu.css">
<link rel="stylesheet" href="../css/select2.css">
<link rel="stylesheet" href="../css/form.css">
<link rel="stylesheet" href="../css/table.css">

<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/datatable/jquery.dataTables.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/npm.js"></script>
</head>
<body>
<!-- 底层panel start-->
<div id="wrapper" class="clearfix">

	<!-- 底层-左边panel start -->
	<div id="cloudResPanel">
     	<!-- left bground -->
	    <div id="sidebar_bg"></div>
	    <!-- //left bground -->
         <!--左侧菜单-->
        <div id="sidebar">
           <!--折叠按钮-->
          <div id="collapase" class="hiddenbtn"></div>          
           <!--//折叠按钮-->
                 <!--一级导航名称-->                      
                <div class="current_title">
                    <div class="row current_title_txt">
                        <div class="col-md-3">
                            <div class="title_icon">
                                <img src="../images/cloudmanagent.png" class="img-responsive">
                            </div>
                        </div>
                        <div class="col-md-9">
                            <p class="title_text" title="生日礼物">生日礼物</p>
                        </div>
                    </div>
                </div>
                 <!--//一级导航名称--> 
                 <div id="navigation">
                 <!--菜单-->
                      <ul id="">
                          <li  class="active left_first_li" id="">
                              <a href="#" class=""> 
                                  <i class="nav_icon"></i>                                 
                                  <span langkey="">礼物</span>
                              </a>                                                      
                              <ul>
                                <li class="intercurrent"><a href="#">清单查看</a><span class="left_nav_tooltip" id="">3</span></li>
                                <li><a href="#">部门列表</a></li>                                
                                <li><a href="#">工作地列表</a></li>
                                <li><a href="#">礼物列表</a></li>
                              </ul>
                           </li>                      
                          <li id="">
                              <a href="#">
                                  <i class="nav_icon"></i>
                                  <span langkey="">设置</span>                                   
                              </a>
                              <ul style="display:none">
                                <li><a href="#">生命周期设置</a></li>
                                <li><a href="#">超时设置</a></li> 
                                <li><a href="#">快照设置</a></li>                                                                                             
                              </ul>                               
                          </li>                                           
                  </ul>
                 <!--//菜单--> 
			</div>
                                      
        </div>
        <!--//左侧菜单-->
      </div>
	<!-- 底层-左边panel end -->
</div>
<!-- 底层panel end-->
</body>
</html>
