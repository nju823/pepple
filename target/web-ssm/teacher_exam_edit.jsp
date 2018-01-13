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
    <script src="js/teacher_exam_edit.js"></script>
    <script src="js/toastr.js"></script>
    <link href="css/toastr.css" rel="stylesheet"/>
    <script src="js/common.js"></script>
    <link href="css/common.css" rel="stylesheet"/>
    <link href="css/teacher_exam_edit.css" rel="stylesheet"/>
    <script src="js/jquery.datetimepicker.full.js"></script>
    <script src="http://malsup.github.io/jquery.form.js"></script>
    <link href="css/jquery.datetimepicker.css" rel="stylesheet"/>
    <link href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    <title>考试</title>
</head>
<body>
    <div class="class-edit-left content">
        <div>
            <span class=title>课程信息</span>
            <div class="class_info_container" style="margin-top: 50px;">
                <span id="class_name_span"></span>
            </div>

            <div class="class_info_container">
                <span id="class_owner_span"></span>
            </div>
            <div class="class_info_container">
                <span id="class_description_span"></span>
            </div>
            <button id="go_classes_btn" class="btn btn-default" style="float: right;margin-top: 50px;"><i class="fa fa-reply">&nbsp;&nbsp;返回主页</i></button>
        </div>
    </div>
    <div class="content" id="exam_info_container">
        <div>
            <span class=title>考试信息</span>
            <div class="examdetail_info_container" style="margin-top: 50px;">
                <div class="exam_info_title">考试总次数</div>
                <div class="exam_info_content" style="background-color: steelblue;"><span id="exam_total_span"></span></div>
            </div>

            <div class="examdetail_info_container">
                <div class="exam_info_title">未开始的考试</div>
                <div class="exam_info_content" style="background-color: #5cb85c;"><span id="exam_unstart_span"></span></div>
            </div>
            <div class="examdetail_info_container">
                <div class="exam_info_title">进行中的考试</div>
                <div class="exam_info_content" style="background-color: #ff604f;"><span id="exam_ing_span"></span></div>
            </div>
            <div class="examdetail_info_container">
                <div class="exam_info_title">已结束的考试</div>
                <div class="exam_info_content" style="background-color: #17c3e5;"><span id="exam_ended_span"></span></div>
            </div>
        </div>
    </div>
   <div class="exam-add-right">
       <div><span class=title>添加考试</span></div>
       <div class="form-group">
           <label class="input_label" for="examNameInput">考试名称</label>
           <input type="text" class="form-control input_content" id="examNameInput">
       </div>
       <div class="form-group">
           <label class="input_label" for="examDesInput">考试描述</label>
           <input type="text" class="form-control input_content" id="examDesInput">
       </div>
       <div class="form-group">
           <label class="input_label" for="examQuestionNumInput">题目数量</label>
           <input type="text" class="form-control input_content" id="examQuestionNumInput" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
       </div>
       <div class="form-group">
           <label class="input_label" for="examTotalScore">试卷总分</label>
           <input type="text" class="form-control input_content" id="examTotalScore" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
       </div>
       <div class="form-group">
           <label class="input_label" for="examStartTime">考试时间</label>
           <input type="text" class="some_class" id="examStartTime" style="height:34px"> 至
           <input type="text" class="some_class" id="examEndTime" style="height:34px">
       </div>
       <form name="studentList_upload_form" id="studentList_upload_form" enctype="multipart/form-data" method="post" target="nm_iframe">
       <div class="form-group">
           <label class="input_label" for="studentListInputFile">学生名单</label>
           <input type="file" name="file" id="studentListInputFile" class="input_content" style="width:165px;display: inline-block;">
           <div class="download_template_container">
               <a class="help-block" href="http://120.79.31.163:8080/exam/file/downloadStudentTemplate">下载模版  <img src="img/downloadIcon.png"></a>
           </div>
       </div>
       <button class="btn btn-primary submit_btn" id="create_exam_btn">确 定</button>
       </form>

   </div>
<div class="exam-add-right">
    <div><span class=title>上传试题</span></div>
    <form id="question_upload_form" name="question_upload_form" enctype="multipart/form-data" action="" method="post" target="nm_iframe">
        <div class="form-group">
            <label class="input_label" for="QuestionInputFile">考试题目</label>
            <input name="file" type="file" id="QuestionInputFile" class="input_content" style="width:165px;display:inline-block;">
            <div class="download_template_container">
                <a class="help-block" href="http://120.79.31.163:8080/question/file/downloadTemplate">下载模版  <img src="img/downloadIcon.png"></a>

            </div>

        </div>
        <button type="submit" class="btn btn-primary submit_btn" id="upload_question_btn">确 定</button>
    </form>
    <iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>
</div>
<hr style="margin:20px 390px;height:1px;width:90%;background: #ccc">
    <div id="exam_table_container">
    <div><span class=title>所有考试</span></div>
    <table class="table" id="exam_table">

        <thead>
        <tr>
            <th>课程名称</th>
            <th>状态</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>分数</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
    </div>
</body>
</html>