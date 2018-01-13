<%--
  Created by IntelliJ IDEA.
  User: fjj
  Date: 2017/11/7
  Time: 上午9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Online_Examination</title>
</head>
<body>

    <!--导航栏-->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#example-navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">On The Way</a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="op" id="myExamination"><a href="student.jsp">我的考试</a></li>
                    <%--<li class="op" id="statistics"><a href="statistics">统计</a></li>--%>
                    <%--<li class="op dropdown" id="manage">--%>
                        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                            <%--管理<b class="caret"></b>--%>
                        <%--</a>--%>
                        <%--<ul class="dropdown-menu">--%>
                            <%--<li><a href="manageStaff">人员管理</a></li>--%>
                            <%--<li><a href="manageQuestion">考核管理</a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
                    <li><a href="index.jsp"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
                </ul>
            </div>
        </div>
    </nav>


</body>
<script type="text/javascript">
    $(document).ready(function() {
        $('#manage').hover(function() {
            $('ul', this).slideDown(200);
            $(this).children('a:first').addClass("hov");
        }, function() {
            $('ul', this).slideUp(100);
            $(this).children('a:first').removeClass("hov");
        });
        $('#statistics').hover(function() {
            $('ul', this).slideDown(200);
            $(this).children('a:first').addClass("hov");
        }, function() {
            $('ul', this).slideUp(100);
            $(this).children('a:first').removeClass("hov");
        });
    });
</script>
<script src="js/isLogin.js"></script>
<script src="js/navigation.js"></script>

</html>
