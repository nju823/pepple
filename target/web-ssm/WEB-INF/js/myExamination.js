$("#testContent").css("height",window.screen.height-150 );

var marks = new Set();
$(document).ready(function () {
    $("#userName").text(localStorage.getItem("name"));
    $("#courseName").text(localStorage.getItem("studentCourseName"));
    // $("#userName").text(localStorage.getItem("name"));
    // console.log(localStorage.getItem("name")+"qqq");


    // marks.forEach(function(value) {
    //     $("#mark_button_"+id).css("display","none");
    //     $("#cancel_mark_button_"+id).css("display","inline");
    //     $("#q"+id).css("background","orange");
    // });

    for(var i = 1;i<10;i++){
        if(sessionStorage.getItem(""+i)==1){
                $("#mark_button_"+i).css("display","none");
                $("#cancel_mark_button_"+i).css("display","inline");
                $("#q"+i).css("background","orange");
        }
    }

})

$(document).ready(function () {
    window.addEventListener("DOMContentLoaded", function () {
        // Grab elements, create settings, etc.
        var canvas = document.getElementById("canvas"),
            context = canvas.getContext("2d"),
            video = document.getElementById("video"),
            videoObj = { "video": true },
            errBack = function (error) {
                console.log("Video capture error: ", error.code);
            };
        if (navigator.getUserMedia) { // Standard

            navigator.getUserMedia(videoObj, function (stream) {
//                video.src = stream;
                video.src = window.URL.createObjectURL(stream);
                video.play();
            }, errBack);
        } else if (navigator.webkitGetUserMedia) { // WebKit-prefixed引擎
            navigator.webkitGetUserMedia(videoObj, function (stream) {
                video.src = window.webkitURL.createObjectURL(stream);
                video.play();
            }, errBack);
        }
        else if (navigator.mozGetUserMedia) { // Firefox-prefixed
            navigator.mozGetUserMedia(videoObj, function (stream) {
                video.src = window.URL.createObjectURL(stream);
                video.play();
            }, errBack);
        }
        else{
            navigator.mozGetUserMedia(videoObj, function (stream) {
                video.src = window.URL.createObjectURL(stream);
                video.play();
            }, errBack);
        }
    }, false);

})

var endDate = new Date(localStorage.getItem("studentEndTime"));
var i=60;
var t;
$(function(){
    $("#userName").val(localStorage.getItem("name"));
    // console.log(localStorage.getItem("name")+"name");
    diffTime();
    console.log("调用");
    function diffTime() {
        var startDate= new Date();
        var diff=endDate.getTime() - startDate.getTime();//时间差的毫秒数
        // //计算出相差天数
        var days=Math.floor(diff/(24*3600*1000));

        //计算出小时数
        var leave1=diff%(24*3600*1000);    //计算天数后剩余的毫秒数
        var hours=Math.floor(leave1/(3600*1000));
        //计算相差分钟数
        var leave2=leave1%(3600*1000);        //计算小时数后剩余的毫秒数
        var minutes=Math.floor(leave2/(60*1000));

        //计算相差秒数
        var leave3=leave2%(60*1000);      //计算分钟数后剩余的毫秒数
        var seconds=Math.round(leave3/1000);

        if(seconds==0){
            tj();
        }

        var returnStr = seconds + "秒";
        if(minutes>0) {
            returnStr = minutes + "分" + returnStr;
        }
        if(hours>0) {
            returnStr = hours + "小时" + returnStr;
        }
        if(days>0) {
            returnStr = days + "天" + returnStr;
        }
        // return returnStr;
        $("#timeLeft").text(returnStr);
        // console.log(returnStr);
        t=setTimeout(diffTime,1000);
    }
});

function goToSummary() {
    top.location="summary.jsp";
}

$(document).ready(function () {
    // getQuestions();
})

function getQuestions() {
    var postData = {};
    postData.examId = localStorage.getItem("studentExamId");
    submitRequest("POST","http://120.79.31.163:8080/exam/createPaper",postData,true,getQuestionSuccess,getQuestionError)
}
function getQuestionSuccess(data) {
    console.log(data);
    $.ajax({
        url: "postQuestion",
        type: "POST",
        dataType: "json",
        data: "json="+JSON.stringify(data.content),
        // data: "json="+JSON.stringify(r),
        success: function (result) {

        }
    });
}

function getQuestionError() {
    toastr.error("出错");
}

function doMark(id) {
    console.log("mark"+id);
    $("#mark_button_"+id).css("display","none");
    $("#cancel_mark_button_"+id).css("display","inline");
    $("#q"+id).css("background","orange");

    sessionStorage.setItem(""+id,1);

    marks.add(id);
}

function cancelMark(id) {
    console.log("cancelmark"+id);
    $("#mark_button_"+id).css("display","inline");
    $("#cancel_mark_button_"+id).css("display","none");
    $("#q"+id).css("background","#eeeeee");

    sessionStorage.setItem(""+id,0);
    marks.delete(id);
}

function testSummary() {
    console.log($("#testForm").serialize()+"!!");
    var answers = $("#testForm").serialize().split("&");
    var as =[];

    for(var i=0;i<answers.length;i++){
        var a = answers[i].split("=");
        if(as[a[0]]){
            var q = as[a[0]]+","+a[1];
            as[a[0]]=q;
        }else{
            as[a[0]]=a[1];
        }
    }

    var postData="sum="+as.length;
    for(var i=1;i<as.length;i++){
        console.log(i+"---------");
        console.log(as[i]);
        // if(i==1){
        //     postData+=(i+"=");
        // }else{
            postData+=("&"+i+"=");
        // }
        if(as[i]){
            postData+=as[i];
        }else{
            postData+="n";
        }


    }

    console.log(postData);

    $.ajax({
        type:"POST",
        data:postData,
        url:"doSummary",
        success:function (data) {
            // toastr.success("yes");
            top.location="summary.jsp";
        },
        error:function () {
            // toastr.error("no");
            top.location="summary.jsp";
        }


    })
}

function doSummary() {
    console.log($("#testForm").serialize()+"!!");
    var answers = $("#testForm").serialize().split("&");
    var as =[];

    for(var i=0;i<answers.length;i++){
        var a = answers[i].split("=");
        if(as[a[0]]){
            var q = as[a[0]]+","+a[1];
            as[a[0]]=q;
        }else{
            as[a[0]]=a[1];
        }
    }

    var postData="sum="+as.length;
    for(var i=1;i<as.length;i++){
        console.log(i+"---------");
        console.log(as[i]);
        // if(i==1){
        //     postData+=(i+"=");
        // }else{
        postData+=("&"+i+"=");
        // }
        if(as[i]){
            postData+=as[i];
        }else{
            postData+="n";
        }


    }

    console.log(postData);

    $.ajax({
        type:"POST",
        data:postData,
        url:"doSummary",
        success:function () {
            setTimeout(function () {
                $.ajax({
                    type:"POST",
                    url:"getFinishedJson",
                    async:false,
                    data:"examId="+localStorage.getItem("studentExamId")+"&studentId="+localStorage.getItem("schoolId"),
                    success:function (json) {
                        console.log("111");
                        console.log(json);

                        setTimeout(function () {
                            $.ajax({
                                type:"POST",
                                data:json,
                                url:"http://120.79.31.163:8080/exam/paper/add",
                                dataType: 'json',
                                contentType: "application/json; charset=utf-8",
                                success:function (data) {
                                    console.log(data);
                                    toastr.success("提交成功")
                                },
                                error:function () {
                                    // toastr.error("")
                                    console.log("error");
                                }
                            })
                        },100)
                    },
                    error:function (json) {
                        console.log(json);
                    }
                })
            },100)
        }

    })
}
function tj() {
    doSummary();
    localStorage.setItem("isLogin","0");
    top.location="finish.jsp";
}

