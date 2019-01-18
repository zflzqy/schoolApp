<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
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
    <link id="ie-style" href="/static/css/ie.css" rel="stylesheet">
    <![endif]-->

    <!--[if IE 9]>
    <link id="ie9style" href="/static/css/ie9.css" rel="stylesheet">
    <![endif]-->

    <!-- start: Favicon -->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- end: Favicon -->




</head>

<body>

<div class="container-fluid-full">
    <div class="row-fluid">


        <noscript>
            <div class="alert alert-block span10">
                <h4 class="alert-heading">Warning!</h4>
                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
            </div>
        </noscript>

        <!-- start: Content -->
        <div id="content" >


            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a onclick="gotoShouye()">后台管理</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <i class="icon-edit"></i>
                    <a >详情</a>
                </li>
            </ul>


            <div class="row-fluid sortable">
                <div class="box span12">
                    <div class="box-header" data-original-title>
                        <h2 id="tip"><i class="halflings-icon white edit"></i>用户修改还是任务修改</h2>
                    </div>
                    <div class="box-content">
                        <form class="form-horizontal">
                            <fieldset>
                                <div class="control-group">
                                    <label class="control-label" id="account" for="accountValue">账号or发布人账号</label>
                                    <div class="control-label" >

                                        <label id="accountValue" style="float: left;padding-left: 20px">hellp</label>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" id="nameOrRequest" for="nameOrRequestValue">名字or要求</label>
                                    <div class="control-label" >

                                        <label id="nameOrRequestValue" style="float: left;padding-left: 20px">hellp</label>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" id="ageOrtype" for="ageOrtype">年龄 类型</label>
                                    <div class="control-label">
                                        <label id="ageOrtypeValue" style="float: left;padding-left: 20px;">hellp</label>
                                    </div>
                                    <div id="priceContent">
                                    <label id="price" for="price" style="float: left;padding-top: 5px"> 价格</label>
                                        <div class="control-label">
                                            <label id="priceValue" style="float: left;padding-left: 20px">hellp</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" style="padding-top:5px" id="sexOrstarttime">性别or开始时间</label>
                                    <div class="control-label" >
                                        <label id="sexOrstarttimeValue" style="float: left;padding-left: 20px"></label>
                                    </div>
                                    <div id="needTimeContent">
                                        <label id="needtime" style="float: left;padding-top: 5px" >需要时间</label>
                                        <div class="control-label">
                                            <label id="needtimeValue" style="float: left;padding-left: 20px">asdasd</label>
                                        </div>
                                    </div>
                                    <div id="finisTimeContent">
                                        <label id="finishtime" style="float: left;padding-top: 5px"> 完成时间</label>
                                        <div class="control-label" style="display: inline">
                                            <label id="finishtimeValue" style="float: left;padding-left: 20px">asdasd</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" style="padding-top:5px" id="schoolOrreceive">所属学校or领取</label>
                                    <div  class="control-label">
                                        <label id="schoolOrreceiveValue" style="float: left;padding-left: 20px">dsadasddsa</label>
                                    </div>
                                    <div id="giveupContent">
                                        <label  id="giveup" style="float: left;padding-top: 5px" >放</label>
                                        <div  class="control-label" >
                                            <label id="giveupValue" style="float: left;padding-left: 20px">asdasd</label>
                                        </div>
                                    </div>
                                    <div id="finishContent">
                                        <label id="finish" style="float: left;padding-top: 5px" >完成</label>
                                        <div class="control-label">
                                            <label id="finishValue" style="float: left;padding-left: 20px">asdasd</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" style="padding-top:5px" id="passOrRecvie">passOR领取账号</label>
                                    <div  class="control-label">
                                        <label id="passOrRecvieValue" style="float: left;padding-left: 20px">dsadasddsa</label>
                                    </div>
                                </div>
                                <div  id="level" class="control-group">
                                    <label class="control-label" style="padding-top:5px;padding-right: 20px" id="appriasleve">评价等级</label>
                                    <div  class="control-label">
                                        <input type="text" id="appriasleveValue" style="float: left;">
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" style="padding-top:5px;padding-right: 20px" id="creditOrApprContet">信用和评价内容</label>

                                    <div  class="control-label">
                                        <input type="text" id="creditOrApprContetValue" style="float: left;">
                                    </div>
                                </div>
                                <div class="form-actions">
                                    <button type="button" id="saveChange" class="btn btn-primary">保存修改</button>
                                    <button id="previous" class="btn">返回</button>
                                </div>
                            </fieldset>
                        </form>

                    </div>
                </div><!--/span-->

            </div><!--/row-->



        </div><!--/.fluid-container-->

        <!-- end: Content -->
    </div><!--/#content.span10-->
    </div><!--/fluid-row-->


<div class="clearfix"></div>

<footer>


</footer>

<!-- start: JavaScript-->

<script src="/static/js/jquery-1.9.1.min.js"></script>
<script src="/static/js/jquery-migrate-1.0.0.min.js"></script>

<script src="/static/js/jquery-ui-1.10.0.custom.min.js"></script>

<script src="/static/js/jquery.ui.touch-punch.js"></script>

<script src="/static/js/modernizr.js"></script>

<script src="/static/js/bootstrap.min.js"></script>

<script src="/static/js/jquery.cookie.js"></script>

<script src='/static/js/fullcalendar.min.js'></script>

<script src='/static/js/jquery.dataTables.min.js'></script>

<script src="/static/js/excanvas.js"></script>
<script src="/static/js/jquery.flot.js"></script>
<script src="/static/js/jquery.flot.pie.js"></script>
<script src="/static/js/jquery.flot.stack.js"></script>
<script src="/static/js/jquery.flot.resize.min.js"></script>

<script src="/static/js/jquery.chosen.min.js"></script>

<script src="/static/js/jquery.uniform.min.js"></script>

<script src="/static/js/jquery.cleditor.min.js"></script>

<script src="/static/js/jquery.noty.js"></script>

<script src="/static/js/jquery.elfinder.min.js"></script>

<script src="/static/js/jquery.raty.min.js"></script>

<script src="/static/js/jquery.iphone.toggle.js"></script>

<script src="/static/js/jquery.uploadify-3.1.min.js"></script>

<script src="/static/js/jquery.gritter.min.js"></script>

<script src="/static/js/jquery.imagesloaded.js"></script>

<script src="/static/js/jquery.masonry.min.js"></script>

<script src="/static/js/jquery.knob.modified.js"></script>

<script src="/static/js/jquery.sparkline.min.js"></script>

<script src="/static/js/counter.js"></script>

<script src="/static/js/retina.js"></script>

<script src="/static/js/custom.js"></script>
<!-- end: JavaScript-->
<%--隐藏部分不同--%>
<script>
    $(document).ready(function () {
        $("#priceContent").hide();
        $("#needTimeContent").hide();
        $("#finisTimeContent").hide();
        $("#giveupContent").hide();
        $("#finishContent").hide();
        $("#level").hide();
    })
</script>
<%--获取数据--%>
<script>
    var url  = document.URL;
    // console.log(url.substring(url.lastIndexOf("?")+1,url.lastIndexOf('='))) // 截取传递的是什么样的参数
    // 得到何种类型的传递
    var type = url.substring(url.lastIndexOf("?")+1,url.lastIndexOf('='));
    var  id;
    if(type=="account"){
        // 处理用户
        // console.log(url.substring(url.lastIndexOf("=")+1));
        var  account = url.substring(url.lastIndexOf("=")+1);
        $.ajax({
            url:"/searchByAccount",
            data:{
                account:account
            },
            type:"POST",
            datatype:'json',
            success:function (data) {
                console.log(data.users);
                var  user = data.users;
                // 显示页面
                showUser(user);

            },
            error:function () {
                alert("服务器有点小问题");
            }

        });
    }
    else  if(type=="id")
    {
        // 处理任务
        id = url.substring(url.lastIndexOf("=")+1);
        $.ajax({
            url:"/searchByRequired",
            data:{
                content:id,
                type:"任务id"
            },
            type:"POST",
            datatype:'json',
            success:function (data) {
                console.log(data.tasks[0]);
                var  task = data.tasks[0];
                // 显示页面
                showTask(task);
            },
            error:function () {
                alert("服务器有点小问题");
            }

        });
    }

</script>
<%--显示--%>
<script>
    function showUser(user) {
        // 用户修改
        $("#tip").text("用户修改");
        // 1.显示账号
        showdetail($("#account"),"账号",$("#accountValue"),user.account);
        // 2.显示名字
        showdetail($("#nameOrRequest"),"姓名",$("#nameOrRequestValue"),user.name);
        // 3.显示年龄
        showdetail($("#ageOrtype"),"年龄",$("#ageOrtypeValue"),user.age);
        // 4.性别
        showdetail($("#sexOrstarttime"),"性别",$("#sexOrstarttimeValue"),user.sex);
        // 5.学校
        showdetail($("#schoolOrreceive"),"所属学校",$("#schoolOrreceiveValue"),user.school);
        // 6.密码
        showdetail($("#passOrRecvie"),"密码",$("#passOrRecvieValue"),user.password);
        // val属性不能用该方法
        // 7.信用 这里修改要检测是否是数字
        $("#creditOrApprContet").text("信用");
        $("#creditOrApprContetValue").val(user.credit);

    };
    function showTask(task) {
        // 任务修改
        $("#tip").text("任务修改");
        // 先解除隐藏
        $("#priceContent").show();
        $("#needTimeContent").show();
        $("#finisTimeContent").show();
        $("#giveupContent").show();
        $("#finishContent").show();
        $("#level").show();
        // 1.显示发布账号
        showdetail($("#account"),"发布人账号",$("#accountValue"),task.issueAccount);
        // 2.显示要求
        showdetail($("#nameOrRequest"),"要求",$("#nameOrRequestValue"),task.request);
        // 3.显示类型，价格
        showdetail($("#ageOrtype"),"类型",$("#ageOrtypeValue"),task.type);
        showdetail($("#price"),"价格",$("#priceValue"),task.price);
        // 4.开始时间，需要时间，完成时间\
        showdetail($("#sexOrstarttime"),"开始时间",$("#sexOrstarttimeValue"),task.starttime);
        showdetail($("#needtime"),"需要时间",$("#needtimeValue"),task.endtime);
        showdetail($("#finishtime"),"完成时间",$("#finishtimeValue"),task.finishtime);
        // 5.是否领取，是否放弃，是否完成 均单独判断先不写
        // 5.1 是否领取
        $("#schoolOrreceive").text("是否领取");
        if (task.accept==0){
            $("#schoolOrreceiveValue").text("未领取");
        }else if (task.accept==1){
            $("#schoolOrreceiveValue").text("已被领取");
        } 
        // 5.2 是否放弃
        $("#giveup").text("是否放弃");
        if (task.giveup==0){
            $("#giveupValue").text("未放弃");
        }else  if (task.giveup==1||task.giveup==2) {
            $("#giveupValue").text("已放弃，等待对方同意");
        }else  if (task.giveup==3||task.giveup==4) {
            $("#giveupValue").text("已放弃");
        }
        // 5.3完成
        $("#finish").text("是否完成");
        if (task.finished==0){
            $("#finishValue").text("未完成");
        } else if (task.finished==1){
            $("#finishValue").text("已完成，等待付款");
        }else if (task.finished==2||task.finished==3){
            $("#finishValue").text("已完成");
        }
        // 6.密码
        showdetail($("#passOrRecvie"),"领取人账号",$("#passOrRecvieValue"),task.receiveaccount);
        // 7.评价等级
        $("#appriasleve").text("评价等级");
        $("#appriasleveValue").val(task.appraiselevel);
        // 8.评价内容
        $("#creditOrApprContet").text("评价内容");
        $("#creditOrApprContetValue").val(task.appraise);

    }
    function showdetail(self,tip,selfValue,value) {
        self.text(tip);
        if (value==null){
            selfValue.text("未设置");
        } else {
            selfValue.text(value);
        }
    }
</script>
<%--返回上一页--%>
<script>
    // 返回上一页
    $("#previous").click(function () {
        if(type=="account"){
            document.location.href="/loginSuccess"+"?account="+account;
            return false;
        }else if (type=="id") {
            document.location.href="/loginSuccess"+"?id="+id;
            return false;
        }
    });
</script>
<%--修改--%>
<script>
    $("#saveChange").click(function () {
        // 1. 获取账号label应该用htnl()获取值
        var account = $("#accountValue").html();
        // 2.获取信用分或者评价内容
        var  creditOrApprContet =  $("#creditOrApprContetValue").val();
        // 3. 获取任务评价等级(任务id在全局变量中)
        var  level = $("#appriasleveValue").val();
        if (type=="account"){
            // 这里判断信用是否是数字
            if (!checkRate(creditOrApprContet)){
                alert("您输入的不是有效数据");
                return false;
            };
            // 如果是用户的信息修改
            $.ajax({
                url:"/updateUser",
                data:{
                    account:account,
                    credit:creditOrApprContet
                },
                type:"POST",
                datatype:"json",
                success:function (data) {
                    if (data==""){
                        // 后台返回了null
                        alert("修改失败");
                    } else {
                        alert("修改成功");
                    }
                },
                error:function () {
                    alert("服务器有点小问题");
                }
            });
        } else if (type=="id"){
            // 这里不仅判断正整数而且判断数据范围在1——5之间
            if (!checkRate(level)){
                alert("您输入的不是有效数据");
                return false;
            }
            // 判断数值范围
            if (level<1||level>5){
                alert("评价等级应该在1-5之间，包含1-5");
            }
            // 任务修改
            $.ajax({
                url:"/updateTask",
                data:{
                    id:id,
                    appraise:creditOrApprContet,
                    appraiselevel:level,
                },
                type:"POST",
                datatype:"json",
                success:function (data) {
                    alert("成功修改");
                },
                error:function () {
                    alert("服务器有点小问题");
                }
            });
        }
    });
    //判断字符串是否为数字
    function checkRate(nubmer) {
        //判断正整数
        var re = /^\d+$/;
        if (re.test(nubmer)) {
            return true;
        }else{
            return false;
        }
    }
</script>
<%--返回首页--%>
<script>
    function gotoShouye() {
        $("#previous").click();
    }
</script>
</body>

</html>
