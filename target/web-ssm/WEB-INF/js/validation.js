$(document).ready(function () {
    var email = sessionStorage.getItem("email");
    var domain = email.split("@");
    var url="";
    switch (domain[1]){
        case "qq.com":url="http://mail.qq.com";break;
        case "sina.cn":url="http://mail.sina.com.cn";break;
        case "163.com":
        case "126.com":
        case "yeah.net":url="http://email.163.com/";break;
        case "souhu.com":url="http://mail.sohu.com";break;
        case "smail.nju.edu.cn":url="http://exmail.qq.com";break;
    }

    var a;
    if(url!=""){
       a = $("<a style='display: inline' href='"+url+"' target='view_window'>登录邮箱</a>");
    }else{
        a = $("<h5>登录邮箱</h5>")
    }

    var wlcomeH5 = $("#wlcomeH5");
    wlcomeH5.append(a);





})

var i=60;var t;
$(function(){
    $("#btn").click(function jishi(){
        $("#btn").text(i+"秒后重发邮件");
        i=i-1;
        $("#btn").attr("disabled",true);
        t=setTimeout(jishi,1000);
        if(i==0){
            clearTimeout(t);
            $("#btn").attr("disabled",false);
            $("#btn").text("重新发送短信");
            i=60;
        }
    });
});

function reSendEmail() {
    var email = sessionStorage.getItem("email");
    var data="email="+email;
    if(email!=null){
        $.ajax({
            type:"GET",
            url:"http://120.79.31.163:8080/user/email/send?email="+email,
            success:reSendEmailSuccess,
            error:reSendEmailError

        });
        // $.get("http://120.79.31.163:8080/user/email/send?email="+email);
        // submitRequest("GET","http://120.79.31.163:8080/user/email/send",data,true,reSendEmailSuccess,reSendEmailError);
    }else{
        toastr.warning("请先注册");
    }
}

function reSendEmailSuccess(data) {
    // alert(data.success);
    console.log(data.success);
}

function reSendEmailError(jqXHR, textStatus, errorThrown) {
    toastr.warning("请求错误");
}