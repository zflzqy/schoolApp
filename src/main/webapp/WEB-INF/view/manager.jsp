<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>后台管理</title>
    <meta name="description" content="Bootstrap Metro Dashboard">
    <meta name="author" content="Dennis Ji">
    <meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- start: CSS -->
    <link id="bootstrap-style" href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link id="base-style" href="/static/css/style.css" rel="stylesheet">
    <link id="base-style-responsive" href="/static/css/style-responsive.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
    <!-- end: CSS -->

    <!-- Sweet Alert -->
    <link href="/static/js/sweetalert.css" rel="stylesheet">
    <link href="/static/js/datepicker3.css" rel="stylesheet">
    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link id="ie-style" href="css/ie.css" rel="stylesheet">
    <![endif]-->

    <!--[if IE 9]>
    <link id="ie9style" href="/static/css/ie9.css" rel="stylesheet">
    <![endif]-->

    <!-- start: Favicon -->
    <link rel="shortcut icon" href="/static/img/favicon.ico">
    <!-- end: Favicon -->




</head>

<body>
<!-- start: Header -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="/loginSuccess"><span>后台管理</span></a>

            <!-- start: Header Menu -->
            <div class="nav-no-collapse header-nav">
                <ul class="nav pull-right">



                    <!-- start: User Dropdown -->
                    <li class="dropdown">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="/login">
                            <i class="halflings-icon white user"></i> 退出
                        </a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>

<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->
        <div id="sidebar-left" class="span2">
            <div class="nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">
                    <li><a  id="userManager"><i class="icon-bar-chart"></i><span  class="hidden-tablet"> 用户管理</span></a></li>
                    <li><a  id="taskManager"><i class="icon-align-justify"></i><span class="hidden-tablet"> 订单管理</span></a></li>
                    <%--<li><a  id="managerManager"><i class="icon-align-justify"></i><span class="hidden-tablet">管理员管理</span></a></li>--%>
                </ul>
            </div>
        </div>
        <!-- end: Main Menu -->


        <!-- start: Content -->
        <div id="content" class="span10">
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="/loginSuccess">主页</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li><span id="bigTitle"></span></li>
            </ul>

            <div class="row-fluid sortable" style="padding-bottom: 20px">
                <div class="box span12">
                    <div class="box-header" data-original-title>
                        <h2><i class="halflings-icon white user"></i>
                            <span class="break" id="samllTitle"></span></h2>
                            <div style="display: inline;float: right">
                                <input id="searchRequire" type="text">
                              <span id="searchTaskType" >搜索类型:</span>
                                        <select  id="searchTaskOption" data-rel="chosen">
                                            <option>任务id</option>
                                            <option>发布人账号</option>
                                            <option>领取人账号</option>
                                            <option>类型</option>
                                            <option>价格</option>
                                        </select>
                                <button type="button" class="btn btn-primary" style="padding-bottom: 10px" id="searchTask">查找</button>
                                <button type="button" class="btn btn-primary" style="padding-bottom: 10px" id="searchByAccount">按账号查找</button>
                                <button type="button" class="btn btn-primary" style="padding-bottom: 10px" id="searchByName">按用户名查找</button>

                            </div>
                    </div>
                    <div style="height: 10px;background:#578ebe "></div>
                    <div class="box-content" style="padding-top: 20px">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">
                            <thead>
                            <tr>
                                <th id="one"></th>
                                <th id="two"></th>
                                <th id="three"></th>
                                <th id="four"></th>
                                <th id="five"></th>
                                <th id="six"></th>
                            </tr>
                            </thead>
                            <tbody id="Info">

                            </tbody>

                        </table>
                    </div>
                </div><!--/span-->
            </div>
            <!--/row-->
            <div style="text-align:center;float: bottom;">
                <a  id="first" >首  页</a>
                <a id="previous">上一页</a>
                <a id="next">下一页</a>
                <a id="end">末  页</a>
            </div>
        </div>

    </div>

</div>
<!-- start: JavaScript-->

<script src="/static/js/jquery-1.9.1.min.js"></script>
<script src="/static/js/sweetalert.min.js"></script>
<script src="/static/js/jquery.flot.js"></script>
<script src="/static/js/jquery.flot.pie.js"></script>
<script src="/static/js/jquery.flot.stack.js"></script>
<script src="/static/js/jquery.flot.resize.min.js"></script>

<%--删除任务--%>
<script>
    // 删除任务
    function deleteOrder(self) {
        swal({
            title: "是否删除",
            type: "warning",
            showCancelButton: true,
            cancelButtonText:"取消",
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定删除",
            closeOnConfirm: true
        },function () {
            // 这里写删除操作
            var task = self.value;
            // 请求删除
            $.ajax({
                url:"/deletTask",
                data:{
                    id:self.value
                },
                type:"POST",
                datatype:"json",
                success:function () {
                    // 删除后重新触发请求用户
                    user.click();
                },
                error:function () {
                    alert("删除失败");
                }
            })
        });
    }
    // 详细跳转
    function userDetail(self) {
        console.log(self.value);
        document.location.href="/turnUserDetail?account="+self.value;
        return false;
    }
    function taskDetail(self) {
        console.log(self.value);
        document.location.href="/turnUserDetail?id="+self.value;
        return false;
    }
</script>
<%--删除用户--%>
<script>
    function deleteUser(self) {
        swal({
            title: "是否删除",
            type: "warning",
            showCancelButton: true,
            cancelButtonText:"取消",
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定删除",
            closeOnConfirm: true
        },function () {
            // 这里写删除操作
            // 请求删除
            $.ajax({
                url:"/deleteUser",
                data:{
                    account:self.value
                },
                type:"POST",
                datatype:"json",
                success:function () {
                    // 删除后重新触发请求用户
                    user.click();
                },
                error:function () {
                    alert("删除失败");
                }
            })
        });
    }
</script>
<%--显示--%>
<script>
    // 初始化分页开始为0
    var  userstart = 0;
    var  taskstart = 0;
    // 每页的分页数量
    var  count = 10;
    var  userlast,tasklast;
    var  users,tasks; // 存放数据
    $(document).ready(function () {
        document.getElementById("content").style.display="none";
        $("#managerManager").hide(); // 超级管理员，未做
        console.log(document.URL);
        var  url = document.URL;
        // 获取哪种操作
        var  who= "";
        who= url.substring(url.indexOf("?")+1,url.indexOf("="));
        console.log(who);
        if (who=="account"){
            // 从用户详细返回
            console.log("user");
            $("#userManager").click();

        } else  if (who=="id"){
            //  从任务详细返回
            console.log("task");
            $("#taskManager").click();
        }
    });
    $("#userManager").click(function () {
        // 用户管理
        document.getElementById("content").style.display="";
        //显示查询
        document.getElementById("searchByAccount").style.display="";
        document.getElementById("searchByName").style.display="";
        // 隐藏任务查询
        document.getElementById("searchTaskOption").style.display="none";
        document.getElementById("searchTask").style.display="none";
        document.getElementById("searchTaskType").style.display="none";
        // 清空查询条件
        $("#searchRequire").val("");
        $.ajax({
            url:"/getUser",
            data:{
                start:userstart,
                type:3
            },
            success:function (data) {
                // 接收分页最后一页
                userlast = data.userlast;
                document.getElementById("bigTitle").innerText="用户管理";
                document.getElementById("samllTitle").innerText="用户";
                document.getElementById("one").innerText="用户名";
                document.getElementById("two").innerText="账号";
                document.getElementById("three").innerText="发布量";
                document.getElementById("four").innerText="领取量";
                document.getElementById("five").innerText="信用等级";
                document.getElementById("six").innerText="详细";
                users =data.users;
                showUsers();
                //

            },
            error:function () {
                alert("服务器出了点小问题啦");
            }
        })
    });
    $("#taskManager").click(function () {
        // 任务管理
        document.getElementById("content").style.display="";
        //隐藏用户查询
        document.getElementById("searchByAccount").style.display="none";
        document.getElementById("searchByName").style.display="none";
        // 显示查询
        document.getElementById("searchTaskOption").style.display="";
        document.getElementById("searchTask").style.display="";
        document.getElementById("searchTaskType").style.display="";
        $("#searchRequire").val("");
        $.ajax({
            url:"/taskManager",
            data:{
                start:taskstart
            },
            success:function (data) {
                // 接收分页最后一页
                tasklast = data.tasklast;
                document.getElementById("bigTitle").innerText="任务管理";
                document.getElementById("samllTitle").innerText="任务";
                document.getElementById("one").innerText="任务id";
                document.getElementById("two").innerText="发布人账号";
                document.getElementById("three").innerText="领取人账号";
                document.getElementById("four").innerText="类型";
                document.getElementById("five").innerText="价格";
                document.getElementById("six").innerText="详细";
                tasks= data.tasks;

                showTasks();
            },
            error:function () {
                alert("服务器出了点小问题啦");
            }
        })
    });
</script>
<%--分页处理--%>
<script>
    // 当点击的显示信息
    var who = document.getElementById("samllTitle");
    // 获取ajax请求按钮对象
    var user = document.getElementById("userManager");
    var task = document.getElementById("taskManager");
    // 这里必须要who.innerText才能取值，而且无法保存到变量
    // 首页
    $("#first").click(function () {
       // 点击首页的时候的处理
        if (who.innerText=="用户") {
            if (userstart==0){
                alert("到第一页啦");
            }
            userstart = 0;
            // 触发获取用户信息请求
            user.click();
        }else if(who.innerText=="任务"){
            if (taskstart==0){
                alert("到第一页啦");
            }
            taskstart = 0;
            // 触发获取任务信息请求
            task.click();
        }
    });
    // 上一页
    $("#previous").click(function () {
        // 点击上一页的时候的处理
        if (who.innerText=="用户") {
            if (userstart==0){
                alert("到首页啦啦啦");
                return false;
            } else {
                userstart = userstart-count;
                // 触发获取用户信息请求
                user.click();
            }
        }else if(who.innerText=="任务"){
            if (taskstart==0){
                alert("到首页啦啦啦");
                return false;
            } else {
                taskstart = taskstart-count;
                // 触发获取任务信息请求
                task.click();
            }
        }
    });
    // 下一页
    $("#next").click(function () {
        // 点击下一页的时候的处理
        if (who.innerText=="用户") {
            if (userstart==userlast){
                alert("到地啦");
                return false;
            } else {
                userstart = userstart+count;
                // 触发获取用户信息请求
                user.click();
            }
        }else if(who.innerText=="任务"){
            if (taskstart==tasklast){
                alert("到地啦");
                return false;
            } else {
                taskstart = taskstart+count;
                // 触发获取任务信息请求
                task.click();
            }
        }
    });
    // 尾页
    $("#end").click(function () {
        // 点击下一页的时候的处理
        if (who.innerText=="用户") {
            if (userstart==userlast){
                alert("到地啦");
                return false;
            } else {
                userstart = userlast;
                // 触发获取用户信息请求
                user.click();
            }
        }else if(who.innerText=="任务"){
            if (taskstart==tasklast){
                alert("到地啦");
                return false;
            } else {
                taskstart = tasklast;
                // 触发获取任务信息请求
                task.click();
            }
        }
    });
</script>
<%--按不同的名字查找用户--%>
<script>
    var  content;
    // 按用户名查找
    $("#searchByName").click(function () {
        content = document.getElementById("searchRequire").value;
        if (content.trim()==""){
            alert("没输入呢");
            return false;
        }else {
            $.ajax({
                url:"/searchByName",
                data:{
                    name:content,
                    type:3
                },
                datatype:"json",
                success:function (data) {
                    if (data =="") {
                        alert("没有查到对应的数据，重新输入把");
                    }else {
                        users =data.users;
                        showUsers();
                    }
                },
                error: function () {
                    alert("服务器有点小问题呢");
                }
            })
        }
    });
    // 按账号查询
    $("#searchByAccount").click(function () {
        content = document.getElementById("searchRequire").value;
        if (content.trim()==""){
            alert("没输入呢");
            return false;
        }else {
            $.ajax({
                url:"/searchByAccount",
                data:{
                    account:content,
                    type:3
                },
                datatype:"json",
                success:function (data) {
                    console.log(data);
                    if (data =="") {
                        alert("没有查到对应的数据，重新输入把");
                    } else {
                        // 清空信息
                        $("#Info").empty();
                        // 循环打印输出
                        var html ="";
                            html +="<tr>";
                            html+="<td >"+data.users.name+"</td>"; // 拼接名称
                            html +="<td>"+data.users.account+"</td>"; // 拼接账号
                            html +="<td>"+data.users.issueCount+"</td>"; // 拼接发布量
                            html +="<td>"+data.users.receiveCount+"</td>"; // 拼接发布量
                            html +="<td>"+data.users.credit+"</td>"; // 拼接信用
                            html +="<td>"+"<button onclick='userDetail(self)' class=\"btn btn-info\" value='value=\""+users.account+"\"' ><i class=\"halflings-icon white edit\"></i></button>"+"</td>"; // 拼接详细
                            html+="</tr>";

                        $("#Info").append(html);
                    }
                },
                error: function () {
                    alert("服务器有点小问题呢");
                }
            })
        }
    });
</script>
<%--任务查询--%>
<script>
    $("#searchTask").click(function () {
        var  required = $("#searchTaskOption option:selected").val();
        content = document.getElementById("searchRequire").value;
       $.ajax({
           url:"/searchByRequired",
           data:{
               content:content,
               type:required
           },
           datatype:'json',
           success:function (data) {
               if (data =="") {
                   alert("没有查到对应的数据，重新输入把");
               }else {
                   tasks =data.tasks;
                  showTasks();
               }
           },
           error:function () {
               alert("服务器有点小问题");
           }
       })
    });
</script>
<%--显示相关信息--%>
<script>
    function showUsers() {
        // 清空信息
        $("#Info").empty();
        // 循环打印输出
        var html ="";
        for (var i=0;i<users.length;i++){
            html +="<tr>";
            if (users[i].name==null) {
                html+="<td >"+"未设置"+"</td>"; // 拼接名称
            }else {

                html+="<td >"+users[i].name+"</td>"; // 拼接名称
            }
            html +="<td>"+users[i].account+"</td>"; // 拼接账号
            html +="<td>"+users[i].issueCount+"</td>"; // 拼接发布量
            html +="<td>"+users[i].receiveCount+"</td>"; // 拼接发布量
            html +="<td>"+users[i].credit+"</td>"; // 拼接账号
            html +="<td>"+"<button onclick='userDetail(this)' class=\"btn btn-info\"  value=\""+users[i].account+"\"><i class=\"halflings-icon white edit\"></i></button>"+""; // 拼接详细
            html +="<button onclick='deleteUser(this)' class=\"btn btn-danger\" href=\"#\" id='' value=\""+users[i].account+"\"><i class=\"halflings-icon white trash\"></i></button>";  // 删除
            html+="</td></tr>";

        }
        $("#Info").append(html);
    };
    function showTasks() {
        // 清空信息
        $("#Info").empty();
        // 循环打印输出
        var html ="";
        console.log(tasks);
        for (var i=0;i<tasks.length;i++){
            html +="<tr>";
            html+="<td >"+tasks[i].id+"</td>"; // 拼接id
            html +="<td>"+tasks[i].issue_account+"</td>"; // 拼接发布账号
            if (tasks[i].receive_account==null){
                // 如果无人领取
                html +="<td>"+"未领取"+"</td>";
            }else {
                html +="<td>"+tasks[i].receive_account+"</td>"; // 拼接领取人账号
            }
            html +="<td>"+tasks[i].type+"</td>"; // 拼接类型
            html +="<td>"+tasks[i].price+"</td>"; // 拼接价格
            html +="<td>"+"<button class=\"btn btn-info\" onclick='taskDetail(this)' value=\""+tasks[i].id+"\"><i class=\"halflings-icon white edit\"></i></button>"; // 拼接详细
            html +="<button onclick='deleteOrder(this)' class=\"btn btn-danger\" href=\"#\" id='' value=\""+tasks[i].id+"\"><i class=\"halflings-icon white trash\"></i></button>";  // 删除
            html+="</td></tr>";

        }
        $("#Info").append(html);
    }
</script>
<%--处理谁跳转这个页面--%>
<%--处理从详细跳转过来的请求--%>
<script>

</script>
</body>
</html>

