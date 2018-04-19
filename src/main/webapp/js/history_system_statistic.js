
var systemName;
var currentDate;
function loadData(sysName,date){
    systemName=sysName;
    currentDate=date;
    dayInfo(sysName,date);
    hourStatistic(sysName,date);
    sourceSystem(sysName,date);
    targetSystem(sysName,date);
    weekAccess(sysName,date);
    monthAccess(sysName,date);
    serviceList(sysName,date);
}

function searchByDate() {
    var searchDate=$("#searchDate").val();
    date=searchDate;
    loadData(sysName,date);
}

function searchService() {
    var service=$("#serviceName").val();

}

function dayInfo(sysName,date) {
    var url="/history/statistic/"+sysName+"/"+date;
    submitRequest("GET",url,"",false,
        function (msg) {
            $("#access_count").text(msg.accessCount);
            $("#average_access_time").text(msg.averageAccessTime);
            $("#error_count").text(msg.errorCount)
            $("#no_response_count").text(msg.noResponseCount)
        },function () {

        });
    
}

//基本统计
function hourStatistic(sysName,date) {
    var url="/history/statistic/hour/"+sysName+"/"+date;
    submitRequest("GET",url,"",false,
        function (data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('hour-statistic'));

            var hours=[];
            var accessCounts=[];
            var accessTime=[];
            var slowCounts=[];
            for(var i=0;i<data.length;i++){
                var statistic=data[i];
                hours.push(data[i].hour);
                accessCounts.push(data[i].accessCount);
                slowCounts.push(data[i].slowCount)
                accessTime.push(data[i].averageAccessTime)
            }
            // for(var i=0;i<24;i++){
            //     hours.push([i]);
            //     accessCounts.push(i*100);
            //     slowCounts.push(i*25);
            //     accessTime.push(2700-i*100);
            // }

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '一天访问统计'
                },

                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross'
                    }
                },
                legend: {
                    data:['访问量','超时次数','平均响应时间']
                },
                xAxis: {
                    data: hours
                },
                yAxis: [
                    {
                        type: 'value',
                        name: '访问量',
                        min: 0,
                        position: 'left',
                        axisLabel: {
                            formatter: '{value} 次'
                        }
                    },{
                        type: 'value',
                        name: '平均响应时间',
                        min: 0,
                        position: 'right',
                        axisLabel: {
                            formatter: '{value} ms'
                        }
                    }
                ]
                ,
                series: [{
                    name: '访问量',
                    type: 'bar',
                    data: accessCounts
                },{
                    name: '超时次数',
                    type: 'bar',
                    data: slowCounts
                },{
                    name:"平均响应时间",
                    type:"line",
                    data:accessTime,
                    yAxisIndex:1
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
            hourPercent(data)
        },function () {

        });


}

function sourceSystem(sysName,date) {
    var url="/count/source/"+sysName+"/"+date;
    submitRequest("GET",url,"",false,
        function (data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('source-pie'));

            var series=[];
            for(var i=0;i<data.length;i++){
                var statistic=data[i];
                series.push({
                    name:statistic.sourceSystem,
                    value:statistic.invokeCount
                })
            }

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '访问系统占比'
                },

                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                series: [ {
                    name: '姓名',
                    type: 'pie',
                    radius : '70%',
                    center: ['50%', '50%'],
                    data: series,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        },function () {

        });
}

function targetSystem(sysName,date) {
    var url="/count/target/"+sysName+"/"+date;
    submitRequest("GET",url,"",false,
        function (data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('target-pie'));

            var series=[];
            for(var i=0;i<data.length;i++){
                var statistic=data[i];
                series.push({
                    name:statistic.targetSystem,
                    value:statistic.invokeCount
                })
            }

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '依赖系统占比'
                },

                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                series: [ {
                    name: '姓名',
                    type: 'pie',
                    radius : '70%',
                    center: ['50%', '50%'],
                    data: series,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        },function () {

        });
}

function hourPercent(data) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('hour-pie'));

    var series=[];
    for(var i=0;i<data.length;i++){
        var statistic=data[i];
        series.push({
            name:statistic.hour,
            value:statistic.accessCount
        })
    }

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '访问时间占比'
        },

        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series: [ {
            name: '时间',
            type: 'pie',
            radius : '70%',
            center: ['50%', '50%'],
            data: series,
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

function weekAccess(sysName,date){
    var url="/history/statistic/week/"+sysName+"/"+date;
    submitRequest("GET",url,"",false,
        function (data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('week-access'));

            var days=[];
            var accessCounts=[];
            var accessTime=[];
            var slowCounts=[];
            for(var i=0;i<data.length;i++){
                var date=new Date(data[i].date);
                days.push(date.getDate());
                accessCounts.push(data[i].accessCount);
                accessTime.push(data[i].averageAccessTime);
                slowCounts.push(data[i].slowCounts);
            }
            // for(var i=0;i<7;i++){
            //     days.push([i]);
            //     accessCounts.push(i*100);
            //     slowCounts.push(i*25);
            //     accessTime.push(2700-i*100);
            // }

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '一周访问统计'
                },

                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross'
                    }
                },
                legend: {
                    data:['访问量','平均响应时间']
                },
                xAxis: {
                    data: days
                },
                yAxis: [
                    {
                        type: 'value',
                        name: '访问量',
                        min: 0,
                        position: 'left',
                        axisLabel: {
                            formatter: '{value}'
                        }
                    }, {
                        type: 'value',
                        name: '平均响应时间',
                        min: 0,
                        position: 'right',
                        axisLabel: ""
                    }
                ]
                ,
                series: [{
                    name: '访问量',
                    type: 'bar',
                    data: accessCounts
                },{
                    name:"平均响应时间",
                    type:"line",
                    data:accessTime,
                    yAxisIndex:1
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
            weekSlow(days,slowCounts);
        },function () {

        });
}

function weekSlow(days,slowCounts) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('week-slow'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '一周超时统计'
        },

        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data:['超时次数']
        },
        xAxis: {
            data: days
        },
        yAxis: [
            {
                type: 'value',
                name: '超时次数',
                min: 0,
                position: 'left',
                axisLabel: {
                    formatter: '{value} 次'
                }
            }
        ]
        ,
        series: [{
            name: '超时次数',
            type: 'line',
            data: slowCounts
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

function monthAccess(sysName,date) {
    var url="/history/statistic/month/"+sysName+"/"+date;
    submitRequest("GET",url,"",false,
        function (data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('month-access'));

            var days=[];
            var accessCounts=[];
            var accessTime=[];
            var slowCounts=[];
            for(var i=0;i<data.length;i++){
                var date=new Date(data[i].date);
                days.push(date.getDate());
                accessCounts.push(data[i].accessCount);
                accessTime.push(data[i].averageAccessTime);
                slowCounts.push(data[i].slowCounts);
            }

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '一月访问统计'
                },

                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross'
                    }
                },
                legend: {
                    data:['访问量','平均响应时间']
                },
                xAxis: {
                    data: days
                },
                yAxis: [
                    {
                        type: 'value',
                        name: '访问量',
                        min: 0,
                        position: 'left',
                        axisLabel: {
                            formatter: '{value}'
                        }
                    },{
                        type: 'value',
                        name: '平均响应时间',
                        min: 0,
                        position: 'right',
                        axisLabel: ""
                    }
                ]
                ,
                series: [{
                    name: '访问量',
                    type: 'bar',
                    data: accessCounts
                },{
                    name:"平均响应时间",
                    type:"line",
                    data:accessTime,
                    yAxisIndex:1
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        },function () {

        });
}


//

function serviceList(sysName,date) {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    var url="/history/service/statistic/system/"+sysName+"/"+date
    submitRequest("GET",url,"",false,
        function (data) {

        table(data)

        },function () {

        })
}

function table(data) {
    alert(data.length)
    // Configuration for jqGrid Example 1
    $("#service_list_table").jqGrid({
        data: data,
        datatype: "local",
        height: 250,
        autowidth: true,
        shrinkToFit: true,
        rowNum: 14,
        rowList: [10, 20, 30],
        colNames: ['接口名称', '访问量', '平均响应时间', '超时次数'],
        colModel: [
            {
                name: 'service',
                index: 'service',
                width: 150
            },
            {
                name: 'accessCount',
                index: 'accessCount',
                width: 60,
                sorttype: "int"
            },
            {
                name: 'averageAccessTime',
                index: 'averageAccessTime',
                width: 60
            },
            {
                name: 'slowCount',
                index: 'slowCount',
                width: 60,
                sorttype: "int"
            }
        ],
        pager: "#service_list",
        viewrecords: true,
        caption: "接口列表",
        hidegrid: false
    });
}
