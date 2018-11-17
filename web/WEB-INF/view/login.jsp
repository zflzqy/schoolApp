<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>登录</title>
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

    <style type="text/css">
        body { background: url(/static/img/bg-login.jpg) !important; }
    </style>

</head>

<body>
<h1>${fail}</h1>
<div class="container-fluid-full">
    <div class="row-fluid">

        <div class="row-fluid">
            <div class="login-box">
                <h2>登录账号</h2>
                    <fieldset>

                        <div class="input-prepend" title="Username">
                            <span class="add-on"><i class="halflings-icon user"></i></span>
                            <input class="input-large span10" name="account" id="username" type="text" placeholder="账号"/>
                        </div>
                        <div class="clearfix"></div>

                        <div class="input-prepend" title="Password">
                            <span class="add-on"><i class="halflings-icon lock"></i></span>
                            <input class="input-large span10" name="password" id="password" type="password" placeholder="密码"/>

                        </div>
                        <div class="clearfix"></div>

                        <label class="remember" for="remember"><input type="checkbox" name="remember" id="remember" />记住密码</label>

                        <div class="button-login">
                            <button type="submit" class="btn btn-primary" id="login">登录</button>

                        </div>
                        <div class="clearfix"></div>
                    </fieldset>
                <hr>
            </div><!--/span-->
        </div><!--/row-->

    </div><!--/.fluid-container-->

</div><!--/fluid-row-->=
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
<%--取出记住的密码--%>
<script>
    $(document).ready(function () {
       document.getElementById("username").value=${sessionScope.account};
        document.getElementById("password").value=${sessionScope.password};
    });
</script>
<%--登录控制--%>
<script>
    $("#login").click(function () {
       var  account = document.getElementById("username").value;
       if (!checkRate(account)||account.length>10){
           alert("请输入正确的账号");
           return false;
       }
       var  password = document.getElementById("password").value;
       var  remember = document.getElementById("remember").checked;
        $.ajax({
            url:"/loginController",
            data:{
              account:account,
              password:password,
              remember:remember
            },
            type:"POST",
            success:function (data) {
                if (data.fail=="fail"){
                    alert("账号或密码有误");
                }else {
                    window.location.href='/loginSuccess';
                }
            },
            error:function () {
                alert("服务器有点小问题啦");
            }
        })

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
</body>
</html>
