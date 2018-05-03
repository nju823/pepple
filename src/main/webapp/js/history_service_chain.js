var chain=[];
var rootData={};
function showChain() {
    var date=$("#searchDate").val();
    var root=$("#root").val();
    if(date==null)
        date=yesteday();
    var url="/service/chain/"+root+"/"+date
    submitRequest("GET",url,"",false,
        function (data) {
            if(data.success){
                chain=data.content.chain;
                rootData=data.content.root;
                for(var i=0;i<chain.length;i++){
                    addChainNode(chain[i])
                }
            }else{
                alert("暂无数据")
            }
        },function () {

        });
}

function addChainNode(statistic){
    var title=statistic.service+" "+statistic.averageAccessTime+"ms";
    var width=statistic.averageAccessTime/rootData.averageAccessTime*100;
    var child='<h5>'+title+'</h5><div class="progress progress-striped"><div style="width:'+width+'%" role="progressbar" class="progress-bar"> </div> </div>';
    $("#chain-container").append(child)
}