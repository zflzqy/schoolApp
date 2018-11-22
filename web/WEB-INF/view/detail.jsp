<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <a >后台管理</a>
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
                        <h2><i class="halflings-icon white edit"></i><span class="break"></span>用户修改还是任务修改</h2>
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
                                        <label id="ageOrtypeValue" style="float: left;padding-left: 20px">hellp</label>
                                    </div>
                                    <div id="priceContent">
                                    <label id="price" class="control-label" for="price" style="float: left"> 价格</label>
                                        <div class="control-label">
                                            <label id="priceValue" style="float: left;padding-left: 20px">hellp</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" id="sexOrstarttime">性别or开始时间</label>
                                    <div class="control-label" >
                                        <label id="sexOrstarttimeValue" style="float: left;padding-left: 20px"></label>
                                    </div>
                                    <div id="needTimeContent">
                                        <label id="needtime" class="control-label"style="float: left;" >需要时间</label>
                                        <div class="control-label">
                                            <label id="needtimeValue" style="float: left;padding-left: 20px"></label>
                                        </div>
                                    </div>
                                    <div id="finisTimeContent">
                                        <label id="finishtime" class="control-label" > 完成时间</label>
                                        <div class="control-label">
                                            <label id="finishtimeValue" style="float: left;padding-left: 20px"></label>
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" id="schoolOrreceive">所属学校or领取</label>
                                    <div class="control-label" >
                                        <label id="schoolOrreceiveValue" style="float: left;padding-left: 20px"></label>
                                    </div>
                                    <div id="giveupContent">
                                        <label id="giveup" class="control-label" > 放弃</label>
                                        <div class="control-label">
                                            <label id="giveupValue" style="float: left;padding-left: 20px"></label>
                                        </div>
                                    </div>
                                    <div id="finishContent">
                                        <label id="finish" class="control-label" >完成</label>
                                        <div class="control-label">
                                            <label id="finishValue" style="float: left;padding-left: 20px"></label>
                                        </div>
                                    </div>
                                </div>
                                <div class="control-group success">
                                    <label class="control-label" for="inputSuccess">Input with success</label>
                                    <div class="controls">
                                        <input type="text" id="inputSuccess">
                                        <span class="help-inline">Woohoo!</span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="selectError2">Group Select</label>
                                    <div class="controls">
                                        <select data-placeholder="Your Favorite Football Team" id="selectError2" data-rel="chosen">
                                            <option value=""></option>
                                            <optgroup label="NFC EAST">
                                                <option>Dallas Cowboys</option>
                                                <option>New York Giants</option>
                                                <option>Philadelphia Eagles</option>
                                                <option>Washington Redskins</option>
                                            </optgroup>
                                            <optgroup label="NFC NORTH">
                                                <option>Chicago Bears</option>
                                                <option>Detroit Lions</option>
                                                <option>Green Bay Packers</option>
                                                <option>Minnesota Vikings</option>
                                            </optgroup>
                                            <optgroup label="NFC SOUTH">
                                                <option>Atlanta Falcons</option>
                                                <option>Carolina Panthers</option>
                                                <option>New Orleans Saints</option>
                                                <option>Tampa Bay Buccaneers</option>
                                            </optgroup>
                                            <optgroup label="NFC WEST">
                                                <option>Arizona Cardinals</option>
                                                <option>St. Louis Rams</option>
                                                <option>San Francisco 49ers</option>
                                                <option>Seattle Seahawks</option>
                                            </optgroup>
                                            <optgroup label="AFC EAST">
                                                <option>Buffalo Dennis Jis</option>
                                                <option>Miami Dolphins</option>
                                                <option>New England Patriots</option>
                                                <option>New York Jets</option>
                                            </optgroup>
                                            <optgroup label="AFC NORTH">
                                                <option>Baltimore Ravens</option>
                                                <option>Cincinnati Bengals</option>
                                                <option>Cleveland Browns</option>
                                                <option>Pittsburgh Steelers</option>
                                            </optgroup>
                                            <optgroup label="AFC SOUTH">
                                                <option>Houston Texans</option>
                                                <option>Indianapolis Colts</option>
                                                <option>Jacksonville Jaguars</option>
                                                <option>Tennessee Titans</option>
                                            </optgroup>
                                            <optgroup label="AFC WEST">
                                                <option>Denver Broncos</option>
                                                <option>Kansas City Chiefs</option>
                                                <option>Oakland Raiders</option>
                                                <option>San Diego Chargers</option>
                                            </optgroup>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-actions">
                                    <button type="submit" class="btn btn-primary">Save changes</button>
                                    <button class="btn">Cancel</button>
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
        // $("#priceContent").hide();
        // $("#needTimeContent").hide();
        // $("#finisTimeContent").hide();
        // $("#giveupContent").hide();
        // $("#finishContent").hide();
    })
</script>
<%--获取数据--%>
<script>
    var url  = document.URL;
    // console.log(url.substring(url.lastIndexOf("?")+1,url.lastIndexOf('='))) // 截取传递的是什么样的参数
    // 得到何种类型的传递
    var type = url.substring(url.lastIndexOf("?")+1,url.lastIndexOf('='));
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

        })
    }
    else  if(type=="id")
    {
        // 处理任务

    }

</script>

<script>
    function showUser(user) {
        // 1.显示账号
        $("#account").text("账号");
        $("#accountValue").text(user.account);
        // 2.显示名字
        $("#nameOrRequest").text("姓名");
        $("#nameOrRequestValue").text(user.name);
        // 3.显示年龄
        $("#ageOrtype").text("年龄");
        $("#ageOrtypeValue").text(user.age);
        // 4.性别
        $("#sexOrstarttime").text("性别");
        $("#sexOrstarttimeValue").text(user.sex);
        // 5.学校
        $("#schoolOrreceive").text("所属学校");
        $("#schoolOrreceiveValue").text(user.school);

    }
</script>
</body>

</html>
