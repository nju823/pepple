$(document).ready(function(){

    $(".left-nav").load("left_nav.jsp",function(){

    });

    $(".right-body").load("realtimeLogList.jsp",function(){
        loadSearchInfo();
        loadSearchHistory();
        initFilterInfo();
        loadLog();
        $(".left-nav").css("height",$(".right-body").css("height"));
    });
});