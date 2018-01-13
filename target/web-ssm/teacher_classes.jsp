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
    <script src="js/toastr.js"></script>
    <link href="css/toastr.css" rel="stylesheet"/>
    <script src="js/teacher_classes.js"></script>
    <script src="js/common.js"></script>
    <link href="css/common.css" rel="stylesheet"/>
    <link href="css/teacher_classes.css" rel="stylesheet"/>

    <title>首页</title>
</head>
<body>
<div style="min-width: 1280px;">
    <div class="nav-left">
        <div class="nav-left-header">
        <div class="avaterContainer">
            <div class="avater">
            </div>
        </div>
            <div class="name_title">
                <h3 id="name_title"></h3>
            </div>
        </div>

        <div class="nav-left-footer">
            <ul>
                <li>
                    <div class="info_title"><span>用户名</span></div>
                    <div class="info_content"><input type="text" class="profile_input" id="user_name" value="Vac1ty"></div>
                </li>
                <li>   
                    <div class="info_title"><span>邮箱</span></div>
                    <div class="info_content"><input type="text" class="profile_input" id="user_email" value="879950363@qq.com"></div>
                </li>
                <li>
                    <div class="info_title"><span>工号</span></div>
                    <div class="info_content"><input type="text" class="profile_input" id="user_id" value="141250206"></div>
                </li>
            </ul>

            <button class="modify" id="profile_btn">修  改</button>
        </div>
    </div>

    <div style="vertical-align: top;display: inline-block;  min-width:800px;min-height:350px;width:73%;">
        <div class="class_container">
            <div><span class=title>我的课程</span></div>
        </div>
<hr style="margin:0 40px;height:1px;width:90%;background: #ccc"/>
         <div class="add_class_container">
            <div><span class=title>添加课程</span></div>
             <div class="form-group">
                <label class="input_label" for="class_name_input">课程名称</label>
                <input type="text" class="form-control input_content" id="class_name_input" placeholder="请输入课程名称">
            </div>
            <div class="form-group">
                <label class="input_label" for="class_description_input">课程描述</label>
                <input type="text" class="form-control input_content" id="class_description_input">
            </div>
            <button id="create_class_btn" type="submit" class="btn btn-primary" style="width:100px;margin-top:20px;">确认</button>
        </div>
    </div>
</div>
</body>
</html>