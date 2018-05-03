$(document).ready(function(){

    $(".left-nav").load("left_nav.jsp",function(){

    });

    $(".right-body").load("realtimePerformance.jsp",function(){
        loadSystemPerformancMinute();
        $(".left-nav").css("height","1000px");
    });


    $(document).on("click","#realtime-monitor",function(){
        $(".right-body").load("realtimePerformance.jsp",function(){
            $(".left-nav").css("height","1000px");
            loadSystemPerformancMinute();
        });
    });


    $(document).on("click","#realtime-log",function () {
        $(".right-body").load("realtimeLogList.jsp",function(){
            loadSearchInfo();
            $('.some_class').datetimepicker();
            loadSearchHistory();
            initFilterInfo();
            loadLog();
            $(".left-nav").css("height","2000px");
        });
    });

    //历史性能
    $(document).on("click","#history-monitor",function () {
        $(".right-body").load("history.jsp",function(){
            showAllSystemHistory();
        });
    });

    $(document).on("click","#system-invoke",function () {
        $(".right-body").load("history_invoke.jsp",function(){
            showInvoke(yesteday())
        });
    });

    $(document).on("click","#chain",function () {
        $(".right-body").load("history_service_chain.jsp",function(){
            $('.some_class').datetimepicker({
                timepicker:false,
                lang:"ch",
                format:"Y-m-d"
            });
        });
    });
});