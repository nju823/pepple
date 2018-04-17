<%--
  Created by IntelliJ IDEA.
  User: cong
  Date: 2018-04-12
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>系统性能分析</title>
    <link href="template/css/bootstrap.min.css" rel="stylesheet">
    <link href="template/css/font-awesome.css" rel="stylesheet">

    <link href="template/css/animate.css" rel="stylesheet">
    <link href="template/css/style.css" rel="stylesheet">
    <link href="css/jquery.datetimepicker.css" rel="stylesheet"/>

    <!--表格-->
    <link href="template/css/plugins/jqgrid/ui.jqgrid.css?0820" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <!--搜索栏-->
    <div class="row" style="margin-bottom: 15px">
        <!--日期-->
        <div class="col-sm-offset-4 col-sm-4">
            <div class="row">
                <div class="col-sm-7">
                    <input type="text" class="some_class form-control" id="logStartTime" style="height:30px;width:240px;">
                </div>
                <div class="col-sm-4">
                    <button class="btn btn-w-m btn-info">搜索日期</button>
                </div>
            </div>

        </div>

        <!--日期-->
        <div class="col-sm-4">
            <div class="row">
                <div class="col-sm-7">
                    <input type="text" class="form-control"  style="height:30px;width:240px;">
                </div>
                <div class="col-sm-4">
                    <button class="btn btn-w-m btn-info">搜索接口</button>
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
                <div class="ibox-title" style="border-bottom:none;background:#fff;">
                    <h5>一周超时统计</h5>
                </div>
                <div class="ibox-content" style="border-top:none;">
                    <div id="week-slow" style="height:290px;">
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title" style="border-bottom:none;background:#fff;">
                    <h5>一月访问统计</h5>
                </div>
                <div class="ibox-content" style="border-top:none;">
                    <div id="month-access" style="height:290px;">
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--接口表格-->
    <div class="row">
        <div class="col-sm-12">
            <div class="jqGrid_wrapper">
                <table id="service_list_table"></table>
                <div id="service_list"></div>
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

<!-- jqGrid -->
<script src="template/js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
<script src="template/js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>

<script src="js/jquery.datetimepicker.full.js"></script>

<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {

        $.jgrid.defaults.styleUI = 'Bootstrap';
        // Examle data for jqGrid
        var mydata = [
            {
                id: "1",
                invdate: "2010-05-24",
                name: "test",
                note: "note",
                tax: "10.00",
                total: "2111.00"
            },
            {
                id: "2",
                invdate: "2010-05-25",
                name: "test2",
                note: "note2",
                tax: "20.00",
                total: "320.00"
            },
            {
                id: "3",
                invdate: "2007-09-01",
                name: "test3",
                note: "note3",
                tax: "30.00",
                total: "430.00"
            },
            {
                id: "4",
                invdate: "2007-10-04",
                name: "test",
                note: "note",
                tax: "10.00",
                total: "210.00"
            },
            {
                id: "5",
                invdate: "2007-10-05",
                name: "test2",
                note: "note2",
                tax: "20.00",
                total: "320.00"
            },
            {
                id: "6",
                invdate: "2007-09-06",
                name: "test3",
                note: "note3",
                tax: "30.00",
                total: "430.00"
            },
            {
                id: "7",
                invdate: "2007-10-04",
                name: "test",
                note: "note",
                tax: "10.00",
                total: "210.00"
            },
            {
                id: "8",
                invdate: "2007-10-03",
                name: "test2",
                note: "note2",
                amount: "300.00",
                tax: "21.00",
                total: "320.00"
            },
            {
                id: "9",
                invdate: "2007-09-01",
                name: "test3",
                note: "note3",
                amount: "400.00",
                tax: "30.00",
                total: "430.00"
            },
            {
                id: "11",
                invdate: "2007-10-01",
                name: "test",
                note: "note",
                amount: "200.00",
                tax: "10.00",
                total: "210.00"
            },
            {
                id: "12",
                invdate: "2007-10-02",
                name: "test2",
                note: "note2",
                amount: "300.00",
                tax: "20.00",
                total: "320.00"
            },
            {
                id: "13",
                invdate: "2007-09-01",
                name: "test3",
                note: "note3",
                amount: "400.00",
                tax: "30.00",
                total: "430.00"
            },
            {
                id: "14",
                invdate: "2007-10-04",
                name: "test",
                note: "note",
                amount: "200.00",
                tax: "10.00",
                total: "210.00"
            }
        ];

        // Configuration for jqGrid Example 1
        $("#service_list_table").jqGrid({
            data: mydata,
            datatype: "local",
            height: 250,
            autowidth: true,
            shrinkToFit: true,
            rowNum: 14,
            rowList: [10, 20, 30],
            colNames: ['序号', '日期', '客户', '金额', '运费', '总额', '备注'],
            colModel: [
                {
                    name: 'id',
                    index: 'id',
                    width: 60,
                    sorttype: "int"
                },
                {
                    name: 'invdate',
                    index: 'invdate',
                    width: 90,
                    sorttype: "date",
                    formatter: "date"
                },
                {
                    name: 'name',
                    index: 'name',
                    width: 100
                },
                {
                    name: 'amount',
                    index: 'amount',
                    width: 80,
                    align: "right",
                    sorttype: "float",
                    formatter: "number"
                },
                {
                    name: 'tax',
                    index: 'tax',
                    width: 80,
                    align: "right",
                    sorttype: "float"
                },
                {
                    name: 'total',
                    index: 'total',
                    width: 80,
                    align: "right",
                    sorttype: "float"
                },
                {
                    name: 'note',
                    index: 'note',
                    width: 150,
                    sortable: false
                }
            ],
            pager: "#pager_list_1",
            viewrecords: true,
            caption: "接口列表",
            hidegrid: false
        });
    });
</script>


</body>

</html>

