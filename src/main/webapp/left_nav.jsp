<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/1/14
  Time: 下午1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link href="css/left_nav.css" rel="stylesheet"/>
    <link href="css/common.css" rel="stylesheet"/>
    <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>


</head>
<body>
    <div class="left-nav-container">
        <div id="left-user-info">在线考试系统</div>
        <div id="left-nav-accordion">
            <ul>
                <li class="parent parent-open" id="monitor-parent">
                    <img class="icon" src="img/nav-monitor-icon.png">
                    <span>系统监控</span>
                    <img class="arrow" src="img/nav-right-icon.png">
                    <ul id="monitor-subul" style="display: block;">
                        <li class="child child-open" id="realtime-monitor">
                            <span>实时性能</span>
                        </li>
                        <li class="child" id="history">
                            <span>历史性能</span>
                        </li>
                    </ul>
                </li>

                <li class="parent">
                    <img class="icon" src="img/nav-log-icon.png">
                    <span>日志记录</span>
                    <img class="arrow" src="img/nav-down-icon.png">
                    <ul id="log-subul">
                        <li class="child" id="realtime-log">
                            <span>实时日志</span>
                        </li>
                        <li class="child">
                            <span>历史日志</span>
                        </li>
                    </ul>
                </li>
                <li class="parent">
                    <img class="icon" src="img/nav-setting-icon.png">
                    <span>系统设置</span>
                    <img class="arrow" src="img/nav-down-icon.png">
                    <ul id="setting-subul">
                        <li class="child">
                            <span>密码修改</span>
                        </li>
                        <li class="child">
                            <span>监控设置</span>
                        </li>
                        <li class="child">
                            <span>日志设置</span>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</body>

<script type="text/javascript">

</script>

</html>
