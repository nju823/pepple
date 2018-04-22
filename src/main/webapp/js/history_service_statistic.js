var serviceName;
var currentDate;
function loadServiceData(service,date){
    serviceName=service;
    currentDate=date;
    serviceDayInfo(service,date);
    serviceHourStatistic(service,date);
    sourceService(service,date);
    targetService(service,date);
    serviceWeekAccess(service,date);
    serviceMonthAccess(service,date);
}

function searchServiceByDate() {
    var searchDate=$("#searchDate").val();

    var url="/history/service/statistic/has/"+serviceName+"/"+searchDate;
    submitRequest("GET",url,"",false,
        function (data) {
            if(data.success){
                loadServiceData(serviceName,searchDate);
            }else{
                alert("暂无数据")
            }
        },function () {

        })


}

function searchServices() {
    var service=$("#serviceName").val();
    var url="/history/service/statistic/has/"+service+"/"+currentDate;
    submitRequest("GET",url,"",false,
        function (data) {
            if(data.success){
                loadServiceData(service,currentDate);
            }else{
                alert("暂无数据")
            }
        },function () {

        })
}

function serviceDayInfo(service,date) {
    var url="/history/service/statistic/"+service+"/"+date;
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
function serviceHourStatistic(service,date) {
    var url="/history/service/statistic/hour/"+service+"/"+date;
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
            serviceHourPercent(data)
        },function () {

        });


}

function sourceService(service,date) {
    var url="/count/service/source/"+service+"/"+date;
    submitRequest("GET",url,"",false,
        function (data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('source-pie'));

            var series=[];
            for(var i=0;i<data.length;i++){
                var statistic=data[i];
                series.push({
                    name:statistic.source,
                    value:statistic.count
                })
            }

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '访问接口占比'
                },

                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                series: [ {
                    name: '接口',
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

function targetService(service,date) {
    var url="/count/service/target/"+service+"/"+date;
    submitRequest("GET",url,"",false,
        function (data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('target-pie'));

            var series=[];
            for(var i=0;i<data.length;i++){
                var statistic=data[i];
                series.push({
                    name:statistic.target,
                    value:statistic.count
                })
            }

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '依赖接口占比'
                },

                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                series: [ {
                    name: '接口',
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

function serviceHourPercent(data) {
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

function serviceWeekAccess(service,date){
    var url="/history/service/statistic/week/"+service+"/"+date;
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
            serviceWeekSlow(days,slowCounts);
        },function () {

        });
}

function serviceWeekSlow(days,slowCounts) {
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

function serviceMonthAccess(service,date) {
    var url="/history/service/statistic/month/"+service+"/"+date;
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
