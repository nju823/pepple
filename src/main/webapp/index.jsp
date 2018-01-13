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

    <link href="css/index.css" rel="stylesheet"/>
    <link href="css/toastr.css" rel="stylesheet"/>

    <title>登录</title>
</head>
<body>
<div class="main">
    <header><!--页头-->
        <div id="banner">
            <div class="inner">


                <h3>在线考试支持系统</h3>

                <p style="color: #2F96B4">考试吧少年！</p>
                <hr>
                <div class="tag">
                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active" id="aIn">
                            <a href="#signIn" data-toggle="tab">
                                登录
                            </a>
                        </li>
                        <li id="aUp"><a href="#signUp" data-toggle="tab" >注册</a></li>
                    </ul>


                    <div id="myTabContent" class="tab-content">

                        <div class="tab-pane fade in active" id="signIn">
                            <form class="form-horizontal" role="form" method="post" id="logInForm">
                                <!--用户名-->
                                <div class="form-group">
                                    <span id="signInTip">&nbsp;</span>
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control in" id="InUsername" name="username" placeholder="学生学号或老师工号">
                                    </div>
                                </div>
                                <!--密码-->
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="password" class="form-control in"  name="password" id="InPassword" placeholder="密码">
                                    </div>
                                </div>

                                <!--登录按钮-->
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="button" class="btn btn-info btn-block" onclick="logIn()">登录</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!--注册模块-->
                        <div class="tab-pane fade" id="signUp">
                            <form class="form-horizontal" role="form" method="post" id="signUpForm">
                                <!--姓名-->
                                <div class="form-group">
                                    <span id="signUpTip">&nbsp;</span>
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control up" name="name" id="UpUsername" placeholder="姓名">
                                    </div>
                                </div>

                                <!--学号-->
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control up" name="schoolId" id="UpSchoolId" placeholder="学生学号或老师工号">
                                    </div>
                                </div>

                                <!--邮箱-->
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control up" name="email" id="UpEmail" placeholder="邮箱">
                                    </div>
                                </div>

                                <!--密码-->
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="password" class="form-control up" name="password" id="UpPassword" placeholder="密码">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="password" class="form-control up" name="password2" id="UpPassword2" placeholder="重复所输入密码">
                                    </div>
                                </div>



                                <!--班级-->
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control up" name="clazz" id="UpClass" placeholder="班级">
                                    </div>
                                </div>

                                <!--年级-->
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <input type="text" class="form-control up" name="grade" id="UpGrade" placeholder="年级">
                                    </div>
                                </div>

                                <div >
                                    <div class="col-sm-12" style="text-align: left;margin-bottom: 10px">
                                        身份:
                                        <input type="radio" name="isTeacher"  value="0" checked>学生
                                        &nbsp;
                                        <input type="radio" name="isTeacher"  value="1" >教师

                                    </div>
                                </div>


                                <!--验证码-->
                                <!--注册按钮-->
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="button" class="btn btn-info btn-block" onclick="signUp()">注册</button>
                                    </div>
                                </div>
                                <%--<input type="submit" style="display: none">--%>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
</div>

</body>
<%--<script src="js/particlesBackground.js"></script>--%>
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="js/toastr.js"></script>
<script src="js/common.js"></script>
<script src="js/index.js"></script>
</html>