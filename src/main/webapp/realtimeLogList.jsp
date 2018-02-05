<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/1/27
  Time: 上午1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link href="css/realtimeLogList.css" rel="stylesheet"/>
    <link href="css/common.css" rel="stylesheet"/>
    <link href="css/jquery.datetimepicker.css" rel="stylesheet"/>
</head>
<body>
<div class="content" id="filter_container">
    <div class="form_container">
        <label class="input_label" for="logStartTime">调用时间</label>
        <input type="text" class="some_class form-control" id="logStartTime" style="height:34px"> 至
        <input type="text" class="some_class form-control" id="logEndTime" style="height:34px">
    </div>
    <div class="form_container">
        <label class="input_label" for="logSystem">参与系统</label>
        <input type="text" class="form-control" id="logSystem">
    </div>
    <div class="form_container">
        <label class="input_label" for="logParam">包含参数</label>
        <input type="text" class="form-control" id="logParam">
    </div>
</div>
<div id="logListContainer"></div>
</body>
</html>
