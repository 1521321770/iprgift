<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/menu.css">
<link rel="stylesheet" href="../css/select2.css">
<link rel="stylesheet" href="../css/form.css">
<link rel="stylesheet" href="../css/table.css">

<script src="../js/bootstrap.js"></script>
<script src="../js/npm.js"></script>
<script type="text/javascript" src="../js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="../gift/main.js"></script>
</head>
<body>
<!--顶部主导航菜单-->
<div class="main_nav">

	<!-- 添加logo start-->
	<div class="main_logo">
        <div class="logo"><img src="../images/nav/logo.png" width="170" height="73" alt=""/></div>
    </div>
	<!-- 添加logo end-->

	<div class="navigation clearfix">
		<div class="top_action clearfix">
			<div class="platform_name">
				<h5 class="name">InCloudManager 浪潮云海·云数据中心管理平台</h5>
			</div>
			
			<div class="alarm_welcome">
				<div class="welcom_action">
					<div class="action_item separated_line"></div>
					<div class="action_item">                  
                 		<div class="menubtn">
							<span class="menubutton_main_a">
                        		<span class="glyphicon glyphicon-user"></span>                      
                        		<span class="menu_item_btn">admin</span>
                        		<span class="menubtn_caret"></span>                                            
							</span>
						</div>
					</div>
					<div class="action_item">                  
                   		<div class="menubtn">
                      		<span class="menubutton_main_a">
                        		<span class="glyphicon glyphicon-cog"></span>
                        		<span class="menu_item_btn">操作</span>
                        		<span class="menubtn_caret"></span>                                            
                      		</span>
                      	</div>
					</div>
					<div class="action_item">                  
						<div class="menubtn">
                      		<span class="menubutton_main_a">
                      			<span class="glyphicon glyphicon-question-sign"></span>
                       			<span class="menu_item_btn">Help</span>
                       			<span class="menubtn_caret"></span>                                            
                      		</span>
                      		<ul class="dropdown-menu pull-right" style="display:none;">
                          		<li><a id="" href="" onclick=""><font langkey="">联机帮助</font></a></li>
                          		<li><a id="" href="#"><font langkey="">文档中心</font></a></li>
                          		<li><a id="" href="#"><font langkey="">视频教程</font></a></li>
                          		<li class="divider"></li>
                          		<li><a id="" href="#"><span langkey="">技术论坛</span></a></li>
                      		</ul>                                                                  
						</div>                                                                       
					</div> 
               </div>                                 
			</div>
		</div>
		
		<div id="main_menu" class="clearfix">
			<!-- <ul id="clusterTabs" class="nav nav-tabs-second"> 嵌套应用-->
			<!-- <ul id="clusterTabs" class="menu_float"> -->
			<ul>
				<li class="menu_float">
					<a href="#" class="menu_float">
						<h1 class="menu_list">首页</h1>
					</a>
				</li>
				<li class="menu_float">
					<a href="#" class="menu_float">
						<h1 class="menu-selected">云资源管理</h1>
					</a>
					<div class="main_menu_panel" style="display: none;">
						<ul class="ng-scope first_ul">
                          <li class="menu_float">
                              <a href="#" ><h2 class="menu_list">列表视图</h2></a>
                          </li>
                          <li class="menu_float">
                              <a href="#" class="menu_list">虚拟控制中心</a>
                          </li>
                          <li class="menu_float">
                              <a href="#" class="menu_list">集群</a>
                          </li>
                          <li class="menu_float">
                              <a href="#" class="menu_list">主机</a>
                          </li>
                          <li class="menu_float">
                              <a href="#" class="menu_list">虚拟数据中心</a>
                          </li>
                          <li class="menu_float">
                              <a href="#" class="menu_list">虚拟机</a>
                          </li>
						</ul>
						<ul class="menu_float common_ul">
                          <li class="menu_float">
                              <a href="#"><h2 class="menu_list">逻辑视图</h2></a>
                          </li>
						</ul>
						<ul class="menu_float common_ul">
                          <li class="menu_float">
                              <a href="#"><h2 class="menu_list">组织视图</h2></a>
                          </li>
						</ul>
					</div>
				</li>
				<li class="menu_float">
					<a href="#" class="menu_float">
					<h1 class="menu_list">云服务</h1></a>
				</li>
				<li class="menu_float">
					<a href="#" class="menu_float">
					<h1 class="menu_list">业务管理</h1></a>
				</li>
				<li class="menu_float">
					<a href="#" class="menu_float">
					<h1 class="menu_list">运维管理</h1></a>
				</li>
			</ul>
		</div>
	</div>
</div>
<!-- 顶层panel end-->

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
                            <p class="title_text" title="云资源管理">云资源管理</p>
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
                                  <span langkey="">列表视图</span>
                              </a>                                                      
                              <ul>
                                <li><a href="#">虚拟控制中心</a></li>
                                <li class="intercurrent"><a href="#">集群</a></li>                                
                                <li><a href="#">主机</a><span class="left_nav_tooltip" id="">3</span></li>
                                <li><a href="#">卷管理</a></li>
                              </ul>
                           </li>                      
                          <li id="">
                             <a href="#"> 
                                  <span langkey="">组织视图</span>                                  
                             </a>
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
			<div  class="curposition mt8 clearfix">云资源管理  &gt;  列表视图  &gt;  集群 &gt; 告警列表</div>
         	<!--当前位置 end-->
         	
         	<!-- 选项卡  start-->
         	<div class="tabs mt10 clearfix">
         		<ul id="clusterTabs" class="nav nav-tabs">
                	<li class="active"><a id="" href="#"><span langkey="">列表视图</span></a></li>
                	<li><a id="" href="#"><span langkey="">资源等级管理</span></a></li>
                	<li><a id="" href="#"><span langkey="">告警列表</span></a></li>
                	<li><a id="" href="#"><span langkey="">拓扑图</span></a></li>
                	<li><a id="" href="#"><span langkey="">选项示例</span></a></li>                    
            	</ul>
         	</div>
         	<!-- 选项卡  end-->

			<!-- 各种查询操作 start-->
			<div class="content_actionbar">
            <!--查询等操作-->
            <div class="query_action clearfix">
              <form class="form-inline">
              <span class="form-tit" style="margin-left:-12px;" langkey="">资源域</span>
                 <div class="form-group">
                    <label for="" class="sr-only">虚拟化类型</label>
                    <select style="width: 200px" class="select2-hidden-accessible" id="">
      	             <option selected="selected" value="all" langkey="">所有</option>
                     <option value="1" langkey="">VMware vCenter</option>
                     <option value="2" langkey="">浪潮 iVirtual</option>
                     <option value="4">IBM HMC</option>
                    </select>
                    <span  style="width:200px;"  class="select2-container select2-container--default select2-container--below">
                          <span  class="select2-selection select2-selection--single" >
                               <span  class="select2-selection__rendered">
                                   <span class="select2-selection__placeholder">所有</span>
                               </span>
                               <span class="select2-selection__arrow">
                                  <b></b>
                               </span>
                          </span>
                         <span class="dropdown-wrapper" ></span>                                                 
                   </span>                  
               </div>
            <span class="form-tit" langkey="account">账号：</span>
			<div class="form-group">
				<label class="sr-only" for=""> </label> <input class="form-control input-sm" id="nameFilter" langkey="inputUserName" placeholder="请输入账号" type="text" />
			</div>
			<span class="form-tit" langkey="">是否锁定</span>
			<div class="form-group">
				<label class="sr-only" for="exampleInputEmail2"></label>
				 <select type="email" class="form-control input-sm" id="">
				 <!-- <select class="form-control input-sm" id=""> -->
					<option selected="selected" value="" langkey="all">所有</option>
					<option langkey="" value="0">未锁定</option>
					<option langkey="" value="1">锁定</option>
				</select>
			</div> 
            <button id="filterSubmit" type="button" class="btn btn-search btn-sm">
				<span class="glyphicon glyphicon-search"></span><span langkey="confirm">确定</span>
			</button>                                                                                            
            </form>
         </div>
            <!--//查询等操作-->
            <!-- 分割线 -->
            <div class="layout_divider clearfix"></div> 
            <!-- //分割线 -->
            <!--添加创建等操作-->            
             <div class="other_action clearfix">
             <div class="fl" style="margin-left:26px;">
              <!--添加、创建、更多操作-->
                <div class="btn-group">
                  <button type="button" class="btn btn-add" data-toggle="dropdown" id="addCluster">
                    <span langkey="importCluster"><i class="glyphicon glyphicon-plus"></i> 主要添加创建</span>
                  </button>
                </div>               
                <div class="btn-group">
                  <button type="button" class="btn btn-add" data-toggle="dropdown" id="addCluster">
                    <span langkey="importCluster"><i class=" glyphicon glyphicon-import"></i> 导入集群信息</span> <span class="caret"></span>
                  </button>
                </div>
                <div class="btn-group">
                  <button type="button" class="btn btn-general" data-toggle="dropdown" id="addCluster">
                    <span langkey="importCluster"> 普通操作按钮</span>
                  </button>
                </div> 
                <div class="btn-group">
                  <button type="button" class="btn btn-general" data-toggle="dropdown" id="addCluster">
                    <span langkey="importCluster"> 通用操作按钮</span> <span class="caret"></span>
                  </button>
                </div>
                <div class="btn-group">
                  <button type="button" class="btn btn-general disabled" data-toggle="dropdown" id="addCluster">
                    <span langkey="importCluster"> 禁用按钮</span> <span class="caret"></span>
                  </button>
                </div>                                                  
                <div class="btn-group">
                  <div class="dropdown more_operations">                     
                     <span class="dropdown-toggle "><a href=""><span class="glyphicon glyphicon-cog"></span> 更多操作<span class="caret"></span></a></span>
                      <ul class="dropdown-menu" style="display:none;">
                          <li><a id="" href="" onclick=""><font langkey="">联机帮助</font></a></li>
                          <li><a id="" href="#"><font langkey="">视频教程</font></a></li>
                          <li class="divider"></li>
                          <li><a id="" href="#"><span langkey="">技术论坛</span></a></li>
                      </ul>                       
                  </div>
                </div>
               <!--//添加、创建、更多操作-->                
             </div>
             </div>
           <!--//添加创建等操作-->
         </div>
			<!-- 分割线 -->
			<div class="layout_divider clearfix"></div>
        	<!-- //分割线 -->
        	<!--table-->
         <div id="" class="table_panel mt10 clearfix">
              <table id="" class="table table-content table-hover idatatable">
                  <thead>
                    <tr class="even">
                      <th  rowspan="2" style="vertical-align:middle;"><input id="iDataTableChk" style="margin-top:0px;" type="checkbox"></th>
                      <!-- 名称 -->
                      <th class="sorting_asc"  rowspan="2" style="vertical-align:middle;"><span>名称</span><span class="column-sorter"></span></th>
                      <th class="sorting"  rowspan="2" style="vertical-align:middle;"><span>告警级别</span><span class="column-sorter"></span></th>
                      <!-- 状态 -->
                      <th class="sorting" rowspan="2" style="vertical-align:middle;"><span>状态</span><span class="column-sorter"></span></th>
                      <!-- vdc类型 -->
                      <th rowspan="2" datakey="vdcType" style="vertical-align:middle;">类型</th>
                      <!-- 资源域 -->
                      <th  rowspan="2" style="vertical-align:middle;">资源域</th>
                      <!-- 所属虚拟控制中心 -->
                    </tr>
                </thead>
                 <tbody>
                   <tr class="odd">
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                   </tr>
                   <tr class="even">
					 <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                   </tr>
                   <tr class="odd">
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                   </tr>
                   <tr class="even">
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                   </tr>
                   <tr class="odd">
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                     <td>&nbsp;</td>
                   </tr>
               </tbody>
           </table>         
         </div>
        <!--//table-->
        <!--tablefoot-->
        <div id="tfoot" class="widget-footer clearfix">
          <div class="pagination_left_panel clearfix">
               <div style="float:left;">
               <!--刷新-->
                    <a class="btn-link">
                        <div title="刷新" class="small_icon small_icon_refresh"></div>
                    </a>
                    <!--选择条数-->
                     <div class="accord_select">
                            <div class="form-group">
                                <label for="" class="sr-only">选择显示条数</label>
                                <select style="width: 56px;" class="select2-hidden-accessible" id="">
                                 <option selected="selected" value="all" langkey="">10</option>
                                 <option value="1" langkey="">20</option>
                                 <option value="2" langkey="">30</option>
                                 <option value="4">50</option>
                                </select>
                                <span  style="width:56px;"  class="select2-container select2-container--default select2-container--below">
                                      <span  class="select2-selection select2-selection--single">
                                           <span  class="select2-selection__rendered" >
                                               <span class="select2-selection__placeholder">10</span>
                                           </span>
                                           <span class="select2-selection__arrow">
                                              <b></b>
                                           </span>
                                      </span>
                                     <span class="dropdown-wrapper" ></span>                                                 
                               </span>                  
                           </div>
                    </div>
                    <!--总数选中-->
                    <div id="info" class="total_selected">共 <strong>3</strong> 条记录，当前选中 <strong>0</strong> 条</div>
                    <!--选择列-->
                    <a class="btn btn-xs btn-add" style="margin:0 0 0 5px; line-height:12px"><span class="glyphicon glyphicon-cog"></span>选择列</a>
               </div>  
          </div>          
          <!--分页-->
          <div class="pagination_right_panel">                                             
                       <div class="pagination_link_panel">
                           <a title="上一页" href="" class="pagination_num_button pagination_prev_span_simple pagination_prev_span pagination_prev_span_disabled"></a>
                           <a href="" class="pagination_link_button pagination_link_selected"><span>1</span></a>
                           <a href="" class="pagination_link_button pagination_num_button"><span>2</span></a>
                           <a href="" class="pagination_link_button pagination_num_button"><span>3</span></a>
                           <a href="" class="pagination_link_button pagination_num_button"><span>4</span></a>
                           <a href="" class="pagination_link_button pagination_num_button"><span>5</span></a>
                           <span class="pagination_ellipse_text">...</span>
                           <a href="" class="pagination_link_button pagination_num_button"><span>15</span></a>
                           <a title="下一页" href="" class="pagination_num_button pagination_next_span_simple pagination_next_span"></a>
                      </div>   
                                                               
                      <div class="pagination_goto_panel">
                          <span id="pagination_gototitle">跳转</span>
                          <input value="1" class="pagination_goto_input_text" type="text">
                          <div title="跳转" class="pagination_goto_link">
                              <a id="" class="pagination_goto_button pagination_num_button"><span><em class="pagination_goto_button_image"></em></span></a>
                          <div></div>
                         </div>
                     </div>    
          </div>
          <!--//分页-->          
        </div>
			<!--//tablefoot-->
			<!-- 各种查询操作 end-->

		</div>
	</div>
	<!-- 右侧所有内容都包含在这两层之下 start -->
	<!-- 底层-右边panel start -->
</div>
<!-- 底层panel end-->
</body>
</html>
