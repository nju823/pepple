//展示各个系统性能
function showAllSystemHistory() {
    var url="/history/statistic/all"
    var systemSimpleInfos = [];
    submitRequest("GET",url,"",false,
        function (msg) {
            systemSimpleInfos = msg;
        },function () {

        });

    $("#system_history_performance_container").empty();
    for(var i=0;i<systemSimpleInfos.length;i++){
        var v="\"";
        $("#system_hostory_performance_container").append("<div class='system_performance content' id='system_"+i+"' onclick='showSystemHistory("+v+systemSimpleInfos[i].name+v+")'>" +
            "<div class='system_name'><p class='number_p' style='margin-left: 10px'>"+systemSimpleInfos[i].name+"</p></div>" +
            "<div class='system_performance_content_left'><p class='explain_p'>调用次数</p><p class='number_p'>"+systemSimpleInfos[i].accessCount+"</p></div>" +
            "<div class='split_line'></div>"+
            "<div class='system_performance_content_right'><p class='explain_p'>成功率</p><p class='number_p'>"+systemSimpleInfos[i].successPercent+"%"+"</p></div></div>");
    }
}

//历史性能
function showSystemHistory(sysName) {
    $(".right-body").load("history_system_statistic.jsp",function(){
        $('.some_class').datetimepicker({
            timepicker:false,
            lang:"ch",
            format:"Y-m-d"
        });
        loadData(sysName,yesteday())
    });

}

