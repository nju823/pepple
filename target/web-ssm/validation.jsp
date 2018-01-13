<%--
  Created by IntelliJ IDEA.
  User: fjj
  Date: 2017/11/28
  Time: 下午10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <%--<script src="js/particles.js"></script>--%>
    <link href="css/validation.css" rel="stylesheet"/>
    <link href="css/toastr.css" rel="stylesheet"/>
    <title>邮箱验证</title>
</head>
<body style="font-family:微软雅黑;text-align: center">
    <div class="container" style="margin-top: 15%;">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h2  style="color: orange;text-align: center">欢迎加入在线考试网</h2>
            </div>
            <div class="panel-body" style="text-align: center">
                <h4 style="display: inline;" id="wlcomeH5">我们给您的邮箱发了一封激活邮件,</h4>
                <h4 style="display: inline-block;">进行验证</h4>
                <br>
                <br>
                <br>
                <button  id="btn" class="btn btn-success btn-lg" style="width: 40%" onclick="reSendEmail()">重新发送邮件</button>
            </div>
        </div>

    </div>
</body>
<script src="js/toastr.js"></script>
<script src="js/common.js"></script>
<script src="js/validation.js"></script>
</html>
