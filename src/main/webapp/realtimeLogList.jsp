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
        <input type="text" class="some_class form-control" id="logStartTime" style="height:34px;width:188px;"> 至
        <input type="text" class="some_class form-control" id="logEndTime" style="height:34px;width:188px;">
    </div>
    <div class="form_container">
        <label class="input_label" for="logServiceName">接口名称</label>
        <input type="text" class="form-control input-400" id="logServiceName" placeholder="请输入关键词">
    </div>
    <div class="form_container">
        <label class="input_label" for="logServiceUrl">接口地址</label>
        <input type="text" class="form-control input-400" id="logServiceUrl" placeholder="请输入关键词">
    </div>
    <div class="form_container">
        <label class="input_label" for="logParam">包含参数</label>
        <input type="text" class="form-control input-400" id="logParam" placeholder="请输入关键词">
    </div>
    <div class="form_container" id="system_search_contianer">
        <label class="input_label">参与系统</label>
    </div>
    <div class="form_container" id="type_search_contianer">
        <label class="input_label">日志类型</label>
    </div>
    <div class="form_container">
        <button type="button" id="search_btn" class="btn btn-primary">搜索</button>
    </div>
</div>
<div class="content" id="id_search_container">
    <div class="input-group form_container">
        <input type="text" class="form-control input-400" id="logSpanId" placeholder="请输入traceId 或 spanId">
        <span class="input-group-btn">
        <button class="btn btn-default" type="button" id="exact_search_btn">Go!</button>
      </span>
    </div>
    <div id="search_history">
        <p class="explain_p">搜索历史：</p>
    </div>
</div>
<div id="logListContainer"></div>
</body>
</html>
