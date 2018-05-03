<%--
  Created by IntelliJ IDEA.
  User: cong
  Date: 2018-04-24
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>调用链</title>
    <link href="template/css/bootstrap.min.css" rel="stylesheet">
    <link href="template/css/font-awesome.css" rel="stylesheet">

    <link href="template/css/animate.css" rel="stylesheet">
    <link href="template/css/style.css" rel="stylesheet">
    <link href="css/jquery.datetimepicker.css" rel="stylesheet"/>
</head>
<body>

<div class="wrapper wrapper-content">
    <!--搜索栏-->
    <div class="row" style="margin-bottom: 15px">

        <div class="col-sm-3">
            <input type="text" class="some_class form-control" id="searchDate" style="height:30px;width:240px;" placeholder="日期">
        </div>

        <div class="col-sm-3">
            <input type="text" class="form-control" id="root" style="height:30px;width:240px;" placeholder="服务名">
        </div>
        <div class="col-sm-4">
            <button class="btn btn-w-m btn-info" onclick="showChain()">搜索</button>
        </div>

    </div>

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox-content" id="chain-container">

            </div>
        </div>

    </div>
</div>

<!-- 全局js -->
<script src="template/js/plugins/layer/layer.min.js"></script>
<!-- Flot -->
<script src="template/js/plugins/flot/jquery.flot.js"></script>
<script src="template/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="template/js/plugins/flot/jquery.flot.resize.js"></script>
<script src="template/js/plugins/flot/jquery.flot.pie.js"></script>
<!-- 自定义js -->
<script src="template/js/content.js"></script>


<script src="js/jquery.datetimepicker.full.js"></script>
</body>
</html>
