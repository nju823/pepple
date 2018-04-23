function showInvoke(date) {
    var url="/count/system/"+date;
    submitRequest("GET",url,"",false,
        function (data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('invoke'));
            var sysNames=data.sysNames;
            var positions=[];
            for(var i=0;i<sysNames.length/2;i++){
                positions.push({
                    x:300+i*300,
                    y:300,
                    name:sysNames[i]
                })
            }
            for(var i=0;i+sysNames.length/2<sysNames.length;i++){
                positions.push({
                    x:300+i*300,
                    y:700,
                    name:sysNames[i+sysNames.length/2]
                })
            }

            var counts=data.counts;
            var links=[];
            for(var i=0;i<counts.length;i++){
                var count=counts[i];
                links.push({

                    source: count.sourceSystem,
                    target: count.targetSystem,
                    lineStyle: {
                        normal: {
                            curveness: 0.2 ,
                            // width: count.invokeCount/5000
                            width:count.invokeCount/10000
                        }
                    }
                });
            }

            var option = {
                tooltip: {},
                animationDurationUpdate: 1500,
                animationEasingUpdate: 'quinticInOut',
                series : [
                    {
                        type: 'graph',
                        layout: 'none',
                        symbolSize: 150,
                        roam: true,
                        label: {
                            normal: {
                                show: true
                            }
                        },
                        edgeSymbol: ['circle', 'arrow'],
                        edgeSymbolSize: [10, 20],
                        edgeLabel: {
                            normal: {
                                textStyle: {
                                    fontSize: 60
                                }
                            }
                        },
                        data: positions,
                        // links: [],
                        links: links,
                        lineStyle: {
                            normal: {
                                opacity: 0.9,
                                width: 2,
                                curveness: 0
                            }
                        }
                    }
                ]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        },function () {

        });
    
}