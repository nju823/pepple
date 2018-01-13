var classData;
var examData;
$(document).ready(function(){
    $('.some_class').datetimepicker();

    loadClassInfo();

    loadExamInfo();

    //上传试题
    $('#upload_question_btn').on('click', function() {
        alert("上传成功");
    });

    $("#go_classes_btn").click(function () {
        top.location="teacher_classes.jsp";
    });

    //创建考试
    $("#create_exam_btn").click(function(){
        var examName;
        var examDes;
        var examQuestionNum;
        var examTotalScore;
        var examStartTime;
        var examEndTime;

        examDes = $("#examDesInput").val();

        if(validateInputNull($("#examNameInput"))){
            examName = $("#examNameInput").val();
            $("#examNameInput").css("border", "1px solid rgb(204, 204, 204)");
        }else {
            $("#examNameInput").css("border", "1px solid red");
            return false;
        }

        if(validateInputNull($("#examQuestionNumInput"))){
            examQuestionNum = $("#examQuestionNumInput").val();
            $("#examQuestionNumInput").css("border", "1px solid rgb(204, 204, 204)");
        }else {
            $("#examQuestionNumInput").css("border", "1px solid red");
            return false;
        }

        if(validateInputNull($("#examTotalScore"))){
            examTotalScore = $("#examTotalScore").val();
            $("#examTotalScore").css("border", "1px solid rgb(204, 204, 204)");

        }else {
            $("#examTotalScore").css("border", "1px solid red");
            return false;
        }

        if(validateInputNull($("#examStartTime"))){
            examStartTime = $("#examStartTime").val();
            $("#examStartTime").css("border", "1px solid rgb(204, 204, 204)");

        }else {
            $("#examStartTime").css("border", "1px solid red");
            return false;
        }

        if(validateInputNull($("#examEndTime"))){
            examEndTime = $("#examEndTime").val();
            $("#examEndTime").css("border", "1px solid rgb(204, 204, 204)");

        }else {
            $("#examEndTime").css("border", "1px solid red");
            return false;
        }

        var file  = $("#studentListInputFile").get(0).files[0];

        if(!file) {
            alert("请选择文件");
            return false;
        }
        examStartTime=dateFormat(examStartTime);
        examEndTime = dateFormat(examEndTime);

        var postData = {};
        postData.title = examName;
        postData.description = examDes;
        postData.questionNum = examQuestionNum;
        postData.score = examTotalScore;
        postData.startTime = examStartTime;
        postData.endTime = examEndTime;
        postData.courseId= classData.id;
        postData.teacherId = localStorage.getItem("schoolId");
        submitRequest("POST","http://120.79.31.163:8080/exam/create",postData,false,
            function (data) {
            if(data.success){
                document.studentList_upload_form.action="http://120.79.31.163:8080/exam/student/file/upload/"+classData.id+"/" + data.content;
                $('#studentList_upload_form').submit();
                loadExamInfo();
                alert("创建成功");
            }else{
                alert(data.message);
                return false;
            }

            },
            function (data) {
                alert("通信异常");
            });

    });

    //表格操作
    $(document).on("click",".analysis_btn",function(e){
        var btn = e.target.id;
        var rowId = btn.id.split("_")[1];
        var examId = examData[rowId].id;
        submitRequest("POST","http://120.79.31.163:8080/exam/grade/list/download/"+examId,null,false,function(){

        },function () {

        });
    });
    //导出成绩
})

function dateFormat(dateStr) {
    dateStr+=":00";
    var dateCom = dateStr.split("/");
    var result = dateCom.join("-");
    return result;
}

function loadClassInfo(){
    classData = JSON.parse(localStorage.getItem("classInfo"));
    $("#class_name_span").html("课程名称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+classData.name);
    $("#class_owner_span").html("课程教师:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+classData.ownerName);
    $("#class_description_span").html("课程描述:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+classData.description);
    document.question_upload_form.action="http://120.79.31.163:8080/question/upload/"+classData.id;
}

function loadExamInfo() {
    $("tbody").html("");
    submitRequest("POST","http://120.79.31.163:8080/exam/course/"+classData.id,null,true,
        function (data) {
            var examList=data.content;
            examData = examList;
            var examUnstart =0;
            var examIng = 0;
            var examEnded = 0;
            for(var i =0;i<(examList||[]).length;i++){
                switch(examList[i].status){
                    case 1:examList[i].status = "未开始";examList[i].grade="--";examUnstart++;break;
                    case 2:examList[i].status = "进行中";examList[i].grade="--";examIng++;break;
                    case 3:examList[i].status = "已结束";examEnded++;break;
                    default :examList[i].status = "异 常";break;
                }
                if(examList[i].status != "已结束"){
                    $("tbody").append("<tr><td>"+examList[i].title+"</td><td>"+examList[i].status+"</td><td>"+examList[i].startTime+"</td><td>"+examList[i].endTime+"</td><td>"+examList[i].grade+"</td><td><a href='http://120.79.31.163:8080/exam/paperDownload/beforeExam/"+examList[i].id+"'><img class='export_btn' id='export_"+i+"' src='img/exportPaperIcon.png' title='导出试卷'></a></td></tr>");
                }else{
                    $("tbody").append("<tr><td>"+examList[i].title+"</td><td>"+examList[i].status+"</td><td>"+examList[i].startTime+"</td><td>"+examList[i].endTime+"</td><td>"+examList[i].grade+"</td><td><a href='http://120.79.31.163:8080/exam/paperDownload/beforeExam/"+examList[i].id+"'><img class='export_btn' id='export_"+i+"' src='img/exportPaperIcon.png' title='导出试卷'></a>&nbsp;&nbsp;<a href='http://120.79.31.163:8080/exam/grade/list/download/"+examList[i].id+"'><img class='analysis_btn' id='analysis_"+i+"' src='img/analysisPaperIcon.png' title='导出成绩'></a></td></tr>")
                }
            }

            $("#exam_total_span").html((examList||[]).length);
            $("#exam_unstart_span").html(examUnstart);
            $("#exam_ing_span").html(examIng);
            $("#exam_ended_span").html(examEnded);
        },
        function () {

        });
}