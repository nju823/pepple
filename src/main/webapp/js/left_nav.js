$(document).ready(function(){

    $(document).on("click",".parent",function(){
        if($(this).hasClass("parent-open")){
            $(this).removeClass("parent-open");
            $(this).find("ul").slideUp();
            $(this).find(".arrow").attr("src","img/nav-down-icon.png");
        }else{
            $(".parent-open").removeClass("parent-open");
            $(this).addClass("parent-open");
            $(this).find("ul").slideDown();
            $(this).find(".arrow").attr("src","img/nav-right-icon.png");
        }
    });

    $(document).on("click",".child",function (e) {
        if($(this).hasClass("child-open")){
            e.stopPropagation();
            return;
        }else{
            $(".child-open").removeClass("child-open");
            $(".child-open").css("border-left","0");
            $(this).addClass("child-open");
            e.stopPropagation();
        }
    });



});