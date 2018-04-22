<%--
  Created by IntelliJ IDEA.
  User: cong
  Date: 2018-04-21
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>服务统计</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>系统性能分析</title>
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
        <!--日期-->
        <div class="col-sm-offset-4 col-sm-4">
            <div class="row">
                <div class="col-sm-7">
                    <input type="text" class="some_class form-control" id="searchDate" style="height:30px;width:240px;">
                </div>
                <div class="col-sm-4">
                    <button class="btn btn-w-m btn-info" onclick="searchServiceByDate()">搜索日期</button>
                </div>
            </div>

        </div>

        <!--日期-->
        <div class="col-sm-4">
            <div class="row">
                <div class="col-sm-7">
                    <input type="text" class="form-control" id="serviceName" style="height:30px;width:240px;">
                </div>
                <div class="col-sm-4">
                    <button class="btn btn-w-m btn-info" onclick="searchServices()">搜索接口</button>
                </div>
            </div>

        </div>
    </div>

    <!--基本信息-->
    <div class="row">
        <div class="col-sm-12">
            <div class="row">
                <div class="col-sm-4">
                    <div class="row row-sm text-center">
                        <div class="col-xs-6">
                            <div class="panel padder-v item">
                                <div class="h1 text-info font-thin h1" id="access_count">521万</div>
                                <span class="text-muted text-xs">访问次数</span>
                                <div class="top text-right w-full">
                                    <i class="fa fa-caret-down text-warning m-r-sm"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="panel padder-v item bg-info" >
                                <div class="h1 text-fff font-thin h1" id="average_access_time">521</div>
                                <span class="text-muted text-xs">响应时间ms</span>
                                <div class="top text-right w-full">
                                    <i class="fa fa-caret-down text-warning m-r-sm"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="panel padder-v item bg-primary">
                                <div class="h1 text-fff font-thin h1" id="error_count">521</div>
                                <span class="text-muted text-xs">异常次数</span>
                                <div class="top text-right w-full">
                                    <i class="fa fa-caret-down text-warning m-r-sm"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="panel padder-v item">
                                <div class="font-thin h1" id="no_response_count">$129</div>
                                <span class="text-muted text-xs">超时次数</span>
                                <div class="bottom text-left">
                                    <i class="fa fa-caret-up text-warning m-l-sm"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="ibox float-e-margins">
                        <!--class="ibox-content"-->
                        <div  style="border-top:none;">
                            <div id="hour-statistic" style="height:330px;">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <!--第一排图表-->
    <div class="row">
        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div style="border-top:none;">
                    <div id="source-pie" style="height:290px;">
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div  style="border-top:none;">
                    <div id="target-pie" style="height:290px;">
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div  style="border-top:none;">
                    <div id="hour-pie" style="height:290px;">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--第二排图表-->
    <div class="row">
        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div style="border-top:none;">
                    <div id="week-access" style="height:290px;">
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div  style="border-top:none;">
                    <div id="week-slow" style="height:290px;">
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div  style="border-top:none;">
                    <div id="month-access" style="height:290px;">
                    </div>
                </div>
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
