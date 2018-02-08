var logInfo = [];

$(document).ready(function() {
    $('.some_class').datetimepicker();

});

function loadLog() {
    logInfo = [
        {"content":"\u0000","currentMillis":1516798086353,"parentSpanId":"-1","serviceName":"exam.student.{param}","serviceUrl":"http://izwz9bb7xjnbywqhq9l3f7z:9086/student/141250888","spanId":"6361912280778539011","target":"exam","traceId":"6361912280744984579","type":5},
        {"content":"{\"studentId\":\"141250888\"}","currentMillis":1516798086354,"parentSpanId":"-1","serviceName":"exam.ExamStudentMapper.getExams","serviceUrl":"exam.ExamStudentMapper.getExams","spanId":"6361912280778539011","traceId":"6361912280744984579","type":3},
        {"currentMillis":1517921954183,"parentSpanId":"-1","serviceName":"exam.paper.{param}","serviceUrl":"http://localhost:9086/paper/19","spanId":"6366626123794612227","target":"exam","traceId":"6366626123614257155","type":1},
        {"currentMillis":1517921954225,"parentSpanId":"6366626123794612227","serviceName":"exam.PaperMapper.getPaper","source":"exam","spanId":"6366626123962384387","target":"exam_db","traceId":"6366626123614257155","type":3},
        {"currentMillis":1517921954334,"parentSpanId":"6366626123794612227","serviceName":"exam.PaperMapper.getPaper","source":"exam","spanId":"6366626123962384387","target":"exam_db","traceId":"6366626123614257155","type":4},
        {"currentMillis":1517921954381,"parentSpanId":"6366626123794612227","serviceName":"exam.QuestionMapper.getQuestionByPaper","source":"exam","spanId":"6366626124599918595","target":"exam_db","traceId":"6366626123614257155","type":3},
        {"currentMillis":1517921954435,"parentSpanId":"6366626123794612227","serviceName":"exam.QuestionMapper.getQuestionByPaper","source":"exam","spanId":"6366626124599918595","target":"exam_db","traceId":"6366626123614257155","type":4},
        {"currentMillis":1517921954475,"parentSpanId":"6366626124599918595","serviceName":"exam.AnswerMapper.getAnswersByQuestion","source":"exam","spanId":"6366626125023543299","target":"exam_db","traceId":"6366626123614257155","type":3},
        {"currentMillis":1517921954526,"parentSpanId":"6366626124599918595","serviceName":"exam.AnswerMapper.getAnswersByQuestion","source":"exam","spanId":"6366626125023543299","target":"exam_db","traceId":"6366626123614257155","type":4},
        {"currentMillis":1517921954563,"parentSpanId":"6366626123794612227","serviceName":"exam.AnswerMapper.getAnswersByQuestion","source":"exam","spanId":"6366626125392642051","target":"exam_db","traceId":"6366626123614257155","type":3},
        {"currentMillis":1517921954604,"parentSpanId":"6366626123794612227","serviceName":"exam.AnswerMapper.getAnswersByQuestion","source":"exam","spanId":"6366626125392642051","target":"exam_db","traceId":"6366626123614257155","type":4},
        {"currentMillis":1517921954624,"parentSpanId":"-1","spanId":"6366626123794612227","traceId":"6366626123614257155","type":2}
        ];

    for(var i =0;i<logInfo.length;i++) {
        if (logInfo[i].parentSpanId === "-1") {
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
        $(e.target.parentNode.parentNode).after("<div class='detailLogContainer content' id='detail_"+id+"'><div class=''></div></div>");
        //生成树形结构
       addNode("detail_"+id,log,0);
    }else{
        $(e.target).attr("src","img/down-icon.png");
        $(e.target.parentNode).addClass("closeLog");
        $(e.target.parentNode).removeClass("openLog");
        $(e.target.parentNode.parentNode.nextSibling).remove();
    }
});

function addNode(detailDivId,log,indent){
    var nameStr="";
    for(var j=0;j<indent-1;j++){
        nameStr +="&nbsp&nbsp";
    }
    if(indent === 0){

    }else{
        nameStr += "|__";
    }
    nameStr+=log.serviceName;
    $("#"+detailDivId).append("<br><div class='interfaceNode'>"+nameStr+"</div>");
    for(var i =0;i<logInfo.length;i++){
        if(logInfo[i].parentSpanId === log.spanId){
            addNode(detailDivId,logInfo[i],indent+1);
        }
    }
}
