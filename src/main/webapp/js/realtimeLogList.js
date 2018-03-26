var logInfo = [];

var systemInfo = [];

var typeInfo = [];

//加载复选框内容，systems,types
function loadSearchInfo(){
    submitRequest("POST","getSystems","",false,
        function(msg){
            systemInfo = msg.content;
    },
        function(msg){
            alert(msg.message);
    });

    typeInfo = ["正常日志","异常日志"];

    $('.some_class').datetimepicker();

    for(var i =0;i<systemInfo.length;i++){
        $("#system_search_contianer").append("<div class='checkbox_container'><input class='checkbox' type='checkbox' id='system_"+i+"'>"+systemInfo[i]+"</div>");
    }

    for(var i =0;i<typeInfo.length;i++){
        $("#type_search_contianer").append("<div class='checkbox_container'><input class='checkbox' type='checkbox' id='type_"+i+"'>"+typeInfo[i]+"</div>");
    }
}

//初始化搜索条件
function initFilterInfo() {
    //构造yyyy/mm/dd hh:mm 的日期
    var date = new Date();
    var seperator1 = "/";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    var hourNow = date.getHours();
    $("#logStartTime").val(currentdate+" 00:00");
    $("#logEndTime").val(currentdate+" "+hourNow+":00");
    $("#logServiceName").val("");
    $("#logServiceUrl").val("");
    $("#logSpanId").val("");
    $("#logTraceId").val("");
    $("#logParam").val("");

    for(var i =0;i<systemInfo.length;i++){
        $("#system_"+i).attr("checked",true);
    }

    for(var i =0;i<typeInfo.length;i++){
        $("#type_"+i).attr("checked",true);
    }
}

//return filter
function loadFilterInfo() {
    var filter ={};
    var systems = [];
    var types = [];
    filter.startTime = new Date($("#logStartTime").val()).getTime();
    filter.endTime = new Date($("#logEndTime").val()).getTime();
    filter.logServiceName = $("#logServiceName").val();
    filter.logServiceUrl = $("#logServiceUrl").val();
    filter.logParam = $("#logParam").val();

    for(var i =0;i<systemInfo.length;i++){
        if($("#system_"+i).attr("checked")){
            systems.push(systemInfo[i]);
        }
    }
    systems.push("");

    for(var i =0;i<typeInfo.length;i++){
        if(i==0){
            types.push(1);
            types.push(2);
        }else if (i==1){
            types.push(3);
        }

        // if($("#type_"+i).attr("checked")){
        //     types.push(i+1);
        // }
    }

    filter.systems = systems;
    filter.types = types;
    console.log(filter);
    return filter;
}

function loadSearchHistory() {

}

//点击搜索loadLog()
$(document).on("click","#search_btn",function () {
    loadLog();
});

$(document).on("click","#exact_search_btn",function () {
    //精确搜索
    loadSearchHistory();
});

function loadLog() {
    var filter = loadFilterInfo();
    submitRequest("POST","getLog",filter,false,
        function(msg){
            logInfo = msg.content;
        },
        function(msg){
            alert(msg.message);
        });

    $("#logListContainer").empty();
    for(var i =0;i<logInfo.length;i++) {

            $("#logListContainer").append("<div class='content logCointainer'>" +
                "<div class='typeContainer' style='background-color: " + getTypeColor(logInfo[i].root.type) + "'>" + getTypeContent(logInfo[i].root.type) + "</div>" +
                "<div class='simpleLogInfo'><div class='logTimeContainer'>" + new Date(logInfo[i].root.requestCurrentMillis) +"</div>"
                +"<div>"+"接口名称： "+logInfo[i].root.serviceName+"</div>"
                +"<div>"+"接口地址： "+logInfo[i].root.serviceUrl+"</div>"
                +"</div><div class='slideLogBtn closeLog' id='slide_"+i+"'><img src='img/down-icon.png'></div></div>");
        }

}

function getTypeColor(type){
    switch (type){
        case 1: return "rgb(100, 155, 244)";break;
        //case 2: return "rgb(100, 155, 244)";break;
        case 2: return "rgb(25, 182, 152)";break;
        //case 4: return "rgb(25, 182, 152)";break;
        case 3: return "rgb(221, 68, 68)";break;
    }
}

function getTypeContent(type){
    switch (type){
        case 1: return "http请求";break;
        //case 2: return "http响应";break;
        case 2: return "数据库请求";break;
        //case 4: return "数据库响应";break;
        case 3: return "异常";break;
    }
}

$(document).on("click",".slideLogBtn",function (e) {
    var id = e.target.parentNode.id.split("_")[1];
    var log = logInfo[id].root;
    if($(e.target.parentNode).hasClass("closeLog")){        //点击展开
        $(e.target).attr("src","img/up-icon.png");
        $(e.target.parentNode).removeClass("closeLog");
        $(e.target.parentNode).addClass("openLog");
        $(e.target.parentNode.parentNode).after("<div class='detailLogContainer content' id='detail_"+id+"'><div class=''></div></div>");
        //生成树形结构
       addNode(id,log,0);
    }else{
        $(e.target).attr("src","img/down-icon.png");
        $(e.target.parentNode).addClass("closeLog");
        $(e.target.parentNode).removeClass("openLog");
        $(e.target.parentNode.parentNode.nextSibling).remove();
    }
});

function addNode(id,log,indent){
    var trace = logInfo[id];
    var nameStr="";
    for(var j=0;j<indent-1;j++){
        nameStr +="&nbsp&nbsp";
    }
    if(indent === 0){

    }else{
        nameStr += "|__";
    }
    nameStr+=log.serviceName;
    $("#detail_"+id).append("<br><div class='interfaceNode'>"+nameStr+"</div>");
    $("#detail_"+id).append("<div class='timeNode' style='width: "+computeWidthFromTime(log.time)+";'>"+log.time+"s</div>");
    for(var i =0;i<trace.logs.length;i++){
        if(trace.logs[i].parentSpanId === log.spanId){
            addNode(id,trace.logs[i],indent+1);
        }
    }
}

function computeWidthFromTime(time) {
    if(time>30)
        return "800px";
    else if(time<1)
        return "40px";
    else
        return (time/30*700+40)+"px";
}
