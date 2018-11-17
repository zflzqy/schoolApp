
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
                    <li><a ><i class="icon-bar-chart"></i><span id="userManager" class="hidden-tablet"> 用户管理</span></a></li>
                    <li><a><i class="icon-align-justify"></i><span id="orderManager" class="hidden-tablet"> 订单管理</span></a></li>
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

            <div class="row-fluid sortable">
                <div class="box span12">
                    <div class="box-header" data-original-title>
                        <h2><i class="halflings-icon white user"></i>
                            <span class="break" id="samllTitle"></span></h2>
                    </div>
                    <div class="box-content">
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
                            <tbody>
                            <tr>
                                <td>zfl</td>
                                <td class="center">123123</td>
                                <td class="center">10</td>
                                <td class="center">10</td>
                                <td class="center">1100</td>
                                <td class="center" id="more" >这是多出来了的给订单用的</td>
                                <td class="center">
                                    <a class="btn btn-info" href="#">
                                        <i class="halflings-icon white edit"></i>
                                    </a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div><!--/span-->
            </div>
            <!--/row-->
            <div style="text-align:center;float: bottom;">
                <a href="?start=0">首  页</a>
                <a href="?start=${page.start-page.count}">上一页</a>
                <a href="?start=${page.start+page.count}">下一页</a>
                <a href="?start=${page.last}">末  页</a>
            </div>
        </div>

    </div>

</div>

<!-- start: JavaScript-->

<script src="/static/js/jquery-1.9.1.min.js"></script>

<script src="/static/js/jquery.flot.js"></script>
<script src="/static/js/jquery.flot.pie.js"></script>
<script src="/static/js/jquery.flot.stack.js"></script>
<script src="/static/js/jquery.flot.resize.min.js"></script>
<script>
    $(document).ready(function () {
        document.getElementById("content").style.display="none";
    });
    $("#userManager").click(function () {
        // 用户管理
        document.getElementById("content").style.display="";
        alert("hi，这是用户");
        $.ajax({
            url:"",
            data:{
                // 执行对应请求 1===》代表用户管理，2===》订单管理
                code:1
            },
            success:function () {
                document.getElementById("bigTitle").innerText="用户管理";
                document.getElementById("samllTitle").innerText="用户";
                document.getElementById("one").innerText="用户名";
                document.getElementById("two").innerText="账号";
                document.getElementById("three").innerText="发布量";
                document.getElementById("four").innerText="领取量";
                document.getElementById("five").innerText="详细";
                document.getElementById("six").innerText="信用等级";
                document.getElementById("more").style.display="none";
                alert("成功啦");
            },
            error:function () {
                alert("服务器出了点小问题啦");
            }
        })
    });
    $("#orderManager").click(function () {
        // 用户管理
        document.getElementById("content").style.display="";
        alert("hi，这是订单");
    });
</script>
</body>
</html>

