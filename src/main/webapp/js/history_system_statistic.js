function loadData(sysName,date){
    dayInfo(sysName,date);
    hourStatistic(sysName,date);
    sourceSystem(sysName,date);
    targetSystem(sysName,date);
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
            // for(var i=0;i<data.length;i++){
            //     var statistic=data[i];
            //     hours.push(data[i].hour);
            //     accessCounts.push(data[i].accessCount);
            // }
            for(var i=0;i<24;i++){
                hours.push([i]);
                accessCounts.push(i*100);
                slowCounts.push(i*25);
                accessTime.push(2700-i*100);
            }

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