var logInfo = [];

$(document).ready(function() {
    $('.some_class').datetimepicker();

});

function loadLog() {
    logInfo = [
        {"content":"\u0000","currentMillis":1516798086353,"parentSpanId":-1,"serviceName":"exam.student.{param}","serviceUrl":"http://izwz9bb7xjnbywqhq9l3f7z:9086/student/141250888","spanId":6361912280778539011,"target":"exam","traceId":6361912280744984579,"type":5},
        {"content":"{\"studentId\":\"141250888\"}","currentMillis":1516798086354,"parentSpanId":-1,"serviceName":"exam.ExamStudentMapper.getExams","serviceUrl":"exam.ExamStudentMapper.getExams","spanId":6361912280778539011,"traceId":6361912280744984579,"type":3},
        {"content":"{\"examId\":44}","currentMillis":1516798086359,"parentSpanId":-1,"serviceName":"exam.ExamMapper.getExam","serviceUrl":"exam.ExamMapper.getExam","spanId":6361912280778539011,"traceId":6361912280744984579,"type":3},
        {"content":"[44,45,48]","currentMillis":1516798086359,"parentSpanId":-1,"serviceName":"exam.ExamStudentMapper.getExams","serviceUrl":"exam.ExamStudentMapper.getExams","spanId":6361912280778539011,"traceId":6361912280744984579,"type":4},
        {"content":"{\"examId\":45}","currentMillis":1516798086361,"parentSpanId":-1,"serviceName":"exam.ExamMapper.getExam","serviceUrl":"exam.ExamMapper.getExam","spanId":6361912280778539011,"traceId":6361912280744984579,"type":3},
        {"content":"null","currentMillis":1516798086361,"parentSpanId":-1,"serviceName":"exam.ExamMapper.getExam","serviceUrl":"exam.ExamMapper.getExam","spanId":6361912280778539011,"traceId":6361912280744984579,"type":4},
        {"content":"{\"examId\":48}","currentMillis":1516798086363,"parentSpanId":-1,"serviceName":"exam.ExamMapper.getExam","serviceUrl":"exam.ExamMapper.getExam","spanId":6361912280778539011,"traceId":6361912280744984579,"type":3},
        {"content":"{\"courseId\":24,\"description\":\"这是测试考试\",\"endTime\":1517407200000,\"id\":45,\"questionNum\":5,\"score\":20,\"startTime\":1515160800000,\"teacherId\":\"t233\",\"title\":\"模拟考试2\"}","currentMillis":1516798086363,"parentSpanId":-1,"serviceName":"exam.ExamMapper.getExam","serviceUrl":"exam.ExamMapper.getExam","spanId":6361912280778539011,"traceId":6361912280744984579,"type":4},
        {"content":"{\"courseId\":24,\"description\":\"test3\",\"endTime\":1515218400000,\"id\":48,\"questionNum\":4,\"score\":20,\"startTime\":1515214800000,\"teacherId\":\"t233\",\"title\":\"模拟考试3\"}","currentMillis":1516798086367,"parentSpanId":-1,"serviceName":"exam.ExamMapper.getExam","serviceUrl":"exam.ExamMapper.getExam","spanId":6361912280778539011,"traceId":6361912280744984579,"type":4},
        {"content":"{\"schoolId\":\"t233\"}","currentMillis":1516798086367,"parentSpanId":6361912280778539011,"serviceName":"user.{param}","source":"exam","spanId":6361912280854036483,"target":"user","traceId":6361912280744984579,"type":1},
        {"content":"{\"content\":{\"id\":56,\"name\":\"测试老师\",\"schoolId\":\"t233\",\"email\":\"1921762406@qq.com\",\"password\":\"e10adc3949ba59abbe56e057f20f883e\",\"clazz\":\"2\",\"grade\":\"大四\",\"active\":true,\"token\":\"8dc1250a0a1b4477c5abb1423d9d2eea\",\"isTeacher\":1},\"success\":true}","currentMillis":1516798086388,"parentSpanId":6361912280778539011,"spanId":6361912280854036483,"traceId":6361912280744984579,"type":2},
        {"content":"{\"id\":24}","currentMillis":1516798086389,"parentSpanId":6361912280778539011,"serviceName":"course.id.{param}","source":"exam","spanId":6361912280942116867,"target":"course","traceId":6361912280744984579,"type":1},
        {"content":"{\"content\":{\"id\":24,\"name\":\"软件工程2\",\"description\":\"软件工程2\",\"ownerId\":\"t233\",\"ownerName\":\"测试老师\"},\"success\":true}","currentMillis":1516798086446,"parentSpanId":6361912280778539011,"spanId":6361912280942116867,"traceId":6361912280744984579,"type":2},
        {"content":"{\"schoolId\":\"t233\"}","currentMillis":1516798086446,"parentSpanId":6361912280778539011,"serviceName":"user.{param}","source":"exam","spanId":6361912281185386499,"target":"user","traceId":6361912280744984579,"type":1},
        {"content":"{\"content\":{\"id\":56,\"name\":\"测试老师\",\"schoolId\":\"t233\",\"email\":\"1921762406@qq.com\",\"password\":\"e10adc3949ba59abbe56e057f20f883e\",\"clazz\":\"2\",\"grade\":\"大四\",\"active\":true,\"token\":\"8dc1250a0a1b4477c5abb1423d9d2eea\",\"isTeacher\":1},\"success\":true}","currentMillis":1516798086463,"parentSpanId":6361912280778539011,"spanId":6361912281185386499,"traceId":6361912280744984579,"type":2},
        {"content":"{\"id\":24}","currentMillis":1516798086463,"parentSpanId":6361912280778539011,"serviceName":"course.id.{param}","source":"exam","spanId":6361912281256689667,"target":"course","traceId":6361912280744984579,"type":1},
        {"content":"{\"content\":{\"id\":24,\"name\":\"软件工程2\",\"description\":\"软件工程2\",\"ownerId\":\"t233\",\"ownerName\":\"测试老师\"},\"success\":true}","currentMillis":1516798086503,"parentSpanId":6361912280778539011,"spanId":6361912281256689667,"traceId":6361912280744984579,"type":2},
        {"content":"{\"examId\":45,\"studentId\":\"141250888\"}","currentMillis":1516798086504,"parentSpanId":-1,"serviceName":"exam.PaperMapper.getGrade","serviceUrl":"exam.PaperMapper.getGrade","spanId":6361912280778539011,"traceId":6361912280744984579,"type":3},
        {"content":"80","currentMillis":1516798086509,"parentSpanId":-1,"serviceName":"exam.PaperMapper.getGrade","serviceUrl":"exam.PaperMapper.getGrade","spanId":6361912280778539011,"traceId":6361912280744984579,"type":4},
        {"content":"{\"examId\":48,\"studentId\":\"141250888\"}","currentMillis":1516798086509,"parentSpanId":-1,"serviceName":"exam.PaperMapper.getGrade","serviceUrl":"exam.PaperMapper.getGrade","spanId":6361912280778539011,"traceId":6361912280744984579,"type":3},
        {"content":"0","currentMillis":1516798086520,"parentSpanId":-1,"serviceName":"exam.PaperMapper.getGrade","serviceUrl":"exam.PaperMapper.getGrade","spanId":6361912280778539011,"traceId":6361912280744984579,"type":4},
        {"content":"{\"success\":true,\"message\":null,\"content\":[{\"id\":45,\"questionNum\":5,\"score\":20,\"startTime\":\"2018-01-05 22:00:00\",\"endTime\":\"2018-01-31 22:00:00\",\"courseId\":24,\"teacherId\":\"t233\",\"title\":\"模拟考试2\",\"description\":\"这是测试考试\",\"teacherName\":\"测试老师\",\"courseName\":\"软件工程2\",\"grade\":80.0,\"status\":2,\"statusDesc\":\"考试中\"},{\"id\":48,\"questionNum\":4,\"score\":20,\"startTime\":\"2018-01-06 13:00:00\",\"endTime\":\"2018-01-06 14:00:00\",\"courseId\":24,\"teacherId\":\"t233\",\"title\":\"模拟考试3\",\"description\":\"test3\",\"teacherName\":\"测试老师\",\"courseName\":\"软件工程2\",\"grade\":0.0,\"status\":3,\"statusDesc\":\"考试结束\"}]}","currentMillis":1516798086522,"parentSpanId":-1,"spanId":6361912280778539011,"traceId":6361912280744984579,"type":2}
        ];

    for(var i =0;i<logInfo.length;i++) {
        if (logInfo[i].parentSpanId === -1) {
            $("#logListContainer").append("<div class='content logCointainer'>" +
                "<div class='typeContainer' style='background-color: " + getTypeColor(logInfo[i].type) + "'>" + getTypeContent(logInfo[i].type) + "</div>" +
                "<div class='simpleLogInfo'><div class='logTimeContainer'>" + new Date(logInfo[i].currentMillis) +"</div>"
                +"<div>"+"接口名称： "+logInfo[i].serviceName+"</div>"
                +"<div>"+"接口地址： "+logInfo[i].serviceUrl+"</div>"
                +"</div><div class='slideLogBtn closeLog' id='slide_"+i+"'><img src='img/down-icon.png'></div></div>");
        }
    }
}

function getTypeColor(type){
    switch (type){
        case 1: return "rgb(100, 155, 244)";break;
        case 2: return "rgb(100, 155, 244)";break;
        case 3: return "rgb(25, 182, 152)";break;
        case 4: return "rgb(25, 182, 152)";break;
        case 5: return "rgb(221, 68, 68)";break;
    }
}

function getTypeContent(type){
    switch (type){
        case 1: return "http请求";break;
        case 2: return "http响应";break;
        case 3: return "数据库请求";break;
        case 4: return "数据库响应";break;
        case 5: return "异常";break;
    }
}

$(document).on("click",".slideLogBtn",function (e) {
    var id = e.target.parentNode.id.split("_")[1];
    var log = logInfo[id];
    if($(e.target.parentNode).hasClass("closeLog")){        //点击展开
        $(e.target).attr("src","img/up-icon.png");
        $(e.target.parentNode).removeClass("closeLog");
        $(e.target.parentNode).addClass("openLog");
        $(e.target.parentNode.parentNode).after("<div class='detailLogContainer content'><div class=''></div></div>")
    }else{
        $(e.target).attr("src","img/down-icon.png");
        $(e.target.parentNode).addClass("closeLog");
        $(e.target.parentNode).removeClass("openLog");
        $(e.target.parentNode.parentNode.nextSibling).remove();
    }
});