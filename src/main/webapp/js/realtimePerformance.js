
function loadSystemPerformancMinute() {

    $("#sysyem_performance_list").show();
    $("#system_performance_detail").hide();

    var systemMinutePerformances = [];
    submitRequest("GET","getAllSystemMinutePerformance","",false,
        function (msg) {
            systemMinutePerformances = msg.content;
        },function () {

        });
    $(".time_tip").html("统计时段为"+new Date(systemMinutePerformances[0].insertTime-60*1000).toLocaleTimeString()+" — "+new Date(systemMinutePerformances[0].insertTime).toLocaleTimeString());

    $("#system_minute_performance_container").empty();
    for(var i=0;i<systemMinutePerformances.length;i++){
        $("#system_minute_performance_container").append("<div class='system_performance content' id='system_"+i+"'>" +
            "<div class='system_name'><p class='number_p' style='margin-left: 10px'>"+systemMinutePerformances[i].systemName+"</p></div>" +
            "<div class='system_performance_content_left'><p class='explain_p'>调用次数</p><p class='number_p'>"+systemMinutePerformances[i].invokeTime+"</p></div>" +
            "<div class='split_line'></div>"+
            "<div class='system_performance_content_right'><p class='explain_p'>成功率</p><p class='number_p'>"+(1-systemMinutePerformances[i].errorPercentage)*100+"%"+"</p></div></div>");
    }
}

function loadServicePerformanceBySystemName(systemName) {

    $("#sysyem_performance_list").hide();
    $("#system_performance_detail").show();

    var systemDayPerformance = [];
    var serviceMinutePerformances = [];
    submitRequest("GET","getSystemDayPerformanceBySystemName?systemName="+systemName,"",false,
        function (msg) {
            systemDayPerformance = msg.content;
            var x_time = [];
            var y_error = [];
            var y_normal = [];
            for(var i =0;i<(systemDayPerformance||[]).length;i++){
                x_time.push(new Date(systemDayPerformance[i].insertTime).toLocaleTimeString());
                y_error.push(systemDayPerformance[i].errorTime);
                y_normal.push(systemDayPerformance[i].invokeTime-systemDayPerformance[i].errorTime);
            }
            var myChart = echarts.init(document.getElementById('system_day_chart'));
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: systemName+"今日调用"
                },
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data:['异常','正常']
                },
                xAxis: {
                    data: x_time
                },
                yAxis: {
                    type: 'value'
                },
                series: [ {
                    name: '异常',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: y_error
                },
                    {
                        name: '正常',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideRight'
                            }
                        },
                        itemStyle:{
                            normal:{
                                color:'rgb(25, 182, 152)'
                            }
                        },
                        data: y_normal
                    }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        },function () {

        });

    submitRequest("GET","getServiceMinutePerformanceBySystemName?systemName="+systemName,"",false,
        function (msg) {
            serviceMinutePerformances = msg.content;
        },function () {

        });

    $("#service_minute_performance_container").empty();

    $(".time_tip").html("统计时段为"+new Date(serviceMinutePerformances[0].insertTime-60*1000).toLocaleTimeString()+" —— "+new Date(serviceMinutePerformances[0].insertTime).toLocaleTimeString());

    for(var i=0;i<serviceMinutePerformances.length;i++){
        $("#service_minute_performance_container").append("<div class='service_performance content'><div class='service_performance_name'>"+serviceMinutePerformances[i].serviceName+"</div>" +
            "<div class='service_performance_text_left explain_p'>调用次数</div><div class='service_performance_text_right'>"+serviceMinutePerformances[i].invokeTime+"</div>" +
            "<div class='service_performance_text_left explain_p'>错误次数</div><div class='service_performance_text_right'>"+serviceMinutePerformances[i].errorTime+"("+serviceMinutePerformances[i].errorPercentage*100+"%"+")</div>" +
            "<div class='service_performance_text_left explain_p'>平均耗时</div><div class='service_performance_text_right'>"+serviceMinutePerformances[i].averageTime+"</div>" +
            "<div class='service_performance_text_left explain_p'>最大耗时</div><div class='service_performance_text_right'>"+serviceMinutePerformances[i].maxTime+"</div></div>")
    }

}

$(document).on("click",".system_performance",function (e) {
    var systemName = $(e.target).parents(".system_performance").find(".system_name").children().html()
    loadServicePerformanceBySystemName(systemName);
});