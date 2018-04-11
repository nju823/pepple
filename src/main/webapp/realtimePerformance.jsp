<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/4/3
  Time: 下午3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/realtimePerformance.css" rel="stylesheet" />
    <link href="css/common.css" rel="stylesheet" />
</head>
<body>


<hr class="hr" />
<div id="system_performance_detail">
    <div id="system_day_performance_container">
        <div id="system_day_chart"></div>
    </div>
    <hr class="hr" />
    <div id="service_performance_tip">接口性能</div>
    <p class="explain_p time_tip"></p>
    <div id="service_minute_performance_container"></div>
</div>

<div id="sysyem_performance_list">
    <div class="header" id="header">系统实时调用情况</div>
    <p class="explain_p" id="time_tip"></p>
    <div id="system_minute_performance_container"></div>
</div>
</body>
</html>
