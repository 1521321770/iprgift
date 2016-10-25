<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/aTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../css/bootstrap.css">
<link rel="stylesheet" href="../../css/main.css">
<link rel="stylesheet" href="../../css/menu.css">
<link rel="stylesheet" href="../../css/select2.css">
<link rel="stylesheet" href="../../css/form.css">
<link rel="stylesheet" href="../../css/table.css">

<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/datatable/jquery.dataTables.js"></script>
<script src="../../js/bootstrap.js"></script>
<script src="../../js/npm.js"></script>
<script type="text/javascript" src="../../gift/bumen/bumen.js"></script>
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
                                <li><a href="../admin.jsp">清单查看</a></li>
                                <li class="intercurrent"><a href="../bumen/bumen.jsp">部门列表</a></li>                                
                                <li><a href="../place/place.jsp">工作地列表</a></li>
                                <li><a href="../gift/gift.jsp">礼物列表</a></li>
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

	<!-- 底层-右边panel start -->
	<!-- 右侧所有内容都包含在这两层之下 start -->
	<div id="right_layout" class="clearfix">
		<div id="listViewContentPanel" class="container-fluid">

			<!--当前位置 start-->        
			<div  class="curposition mt8 clearfix">生日礼物 &gt;  礼物  &gt;  部门列表 :</div>
         	<!--当前位置 end-->
         	
			<!-- 各种查询操作 start-->
			<div class="content_actionbar">

            <!-- 分割线 -->
            <div class="layout_divider clearfix"></div> 
            <!-- //分割线 -->

            <!--添加创建等操作-->            
             <div class="other_action clearfix">
             <div class="fl" style="margin-left:10px;">
              <!--添加、创建、更多操作-->
                <div class="btn-group">
                  <button type="button" class="btn btn-add" data-toggle="dropdown" id="addCluster">
                    <span langkey="importCluster"><i class="glyphicon glyphicon-plus"></i> 添加</span>
                  </button>
                </div>               
                <div class="btn-group" style="margin-left:5px;">
                  <button type="button" class="btn btn-general" data-toggle="dropdown" id="addCluster">
                    <span langkey="importCluster"> 删除</span>
                  </button>
                </div> 
                <div class="btn-group" style="margin-left:5px;">
                  <button type="button" class="btn btn-general" data-toggle="dropdown" id="addCluster">
                    <span langkey="importCluster"> 修改</span>
                  </button>
                </div>
             </div>
             </div>
           <!--//添加创建等操作-->
         </div>
			<!-- 分割线 -->
			<div class="layout_divider clearfix"></div>
        	<!-- //分割线 -->
        	<!--table-->
         <div id="example" class="table_panel mt10 clearfix">
              <table id="dataTable_bumen" class="table table-content table-hover idatatable">
                  <thead>
                    <tr>
                      <th style="vertical-align:middle;"><input id="iDataTableChk" style="margin-top:0px;" type="checkbox"></th>
                      <th class="sorting_asc" style="vertical-align:middle;"><span>名称</span><span class="column-sorter"></span></th>
                      <th class="sorting" style="vertical-align:middle;"><span>创建人</span><span class="column-sorter"></span></th>
                      <th class="sorting" style="vertical-align:middle;"><span>最近修改时间</span><span class="column-sorter"></span></th>
                    </tr>
                </thead>
           </table>         
         </div>
        <!--//table-->
		<!-- 各种查询操作 end-->
		</div>
	</div>
	<!-- 右侧所有内容都包含在这两层之下 start -->
	<!-- 底层-右边panel start -->
</div>
<!-- 底层panel end-->
</body>
</html>
