

var email;


function signUp() {
    var i = 0 ;
    $("input.up").each(function(){  //遍历input标签，判断是否有内容未填写
        var vl=$(this).val();
        if(vl==""){
            i++;
        }
    });
    console.log(i);
    if(i>0){
        toastr.warning("请填写完整信息");
    }
    else if($("#UpPassword").val()!=$("#UpPassword2").val()){
        toastr.warning("两次密码不同");

    }
    else{
        email=$("#UpEmail").val();
        // alert($("#UpEmail").val());
        // alert(email)
        // var basicInfo = JSON.stringify($("#signUpForm").serializeObject());
        submitRequest("POST","http://120.79.31.163:8080/user/register",$("#signUpForm").serializeObject(),false,signUpSuccess,signUpError)

        // $.ajax({
        //     type: 'POST',
        //     url: "http://120.79.31.163:8080/user/register",
        //     // url: "register",
        //     data: basicInfo,
        //     dataType: 'json',
        //     async:false,//取消异步请求
        //     contentType: "application/json; charset=utf-8",
        //     success: function(data) {
        //         alert(data.success);
        //         alert(data.content);
        //         alert(data.message);
        //         if(data.success){
        //             //跳转验证界面
        //             top.location="validation.jsp";
        //         }else{
        //             toastr.warning(data.message);
        //         }
        //     },
        //     error: function (jqXHR, textStatus, errorThrown) {
        //         /*弹出jqXHR对象的信息*/
        //         alert(jqXHR.responseText);//null
        //         alert(jqXHR.status);//404
        //         alert(jqXHR.readyState);//4
        //         alert(jqXHR.statusText);//error
        //         /*弹出其他两个参数的信息*/
        //         alert(textStatus);//error
        //         alert(errorThrown);//null
        //     }
        //
        // });
    }

}

function signUpSuccess(data) {
    if(data.success){
        //跳转验证界面
        sessionStorage.setItem("email", email);

        top.location="validation.jsp";
    }else{
        toastr.warning(data.message);
    }
}

function signUpError(jqXHR, textStatus, errorThrown) {
    toastr.warning("请求错误");
}

function logIn() {
    var i = 0 ;
    $("input.in").each(function(){  //遍历input标签，判断是否有内容未填写
        var vl=$(this).val();
        if(vl==""){
            i++;
        }
    });
    if(i>0){
        toastr.warning("请填写完整信息");
    }else{
        // var basicInfo = JSON.stringify($("#logInForm").serializeObject());
        submitRequest("POST","http://120.79.31.163:8080/user/login",$("#logInForm").serializeObject(),true,loginSuccess,loginError)

        // $.ajax({
        //     type: 'POST',
        //     url: "http://120.79.31.163:8080/user/login",
        //     data: basicInfo,
        //     dataType: 'json',
        //     async:true,//取消异步请求
        //     contentType: "application/json; charset=utf-8",
        //     success: function(data) {
        //         if(data.success){
        //             top.location="myExamination.jsp";
        //         }else{
        //             toastr.warning(data.message);
        //         }
        //     },
        //     error: function (jqXHR, textStatus, errorThrown) {
        //     }
        //
        // });
    }
}
 function loginSuccess(data) {
     if(data.success){
         var toUrl="";
         var c = data.content;
         if(c.isTeacher == 0)
           toUrl = "student.jsp";
         else
           toUrl = "teacher_classes.jsp";

         localStorage.setItem("id",c.id);
         localStorage.setItem("name",c.name);
         localStorage.setItem("schoolId",c.schoolId);
         localStorage.setItem("email",c.email);
         localStorage.setItem("grade",c.grade);
         localStorage.setItem("class",c.clazz);
         localStorage.setItem("isLogin","1");
         if(c.isTeacher == 0)
            initExamList(toUrl);
         else
             top.location=toUrl;

     }else{
         toastr.warning(data.message);
     }
 }

 function loginError(jqXHR, textStatus, errorThrown) {
     toastr.warning("请求错误");
 }

//回车确认
function stopDefault(e) {
    //如果提供了事件对象，则这是一个非IE浏览器
    if(e && e.preventDefault) {
        //阻止默认浏览器动作(W3C)
        e.preventDefault();
    } else {
        //IE中阻止函数器默认动作的方式
        window.event.returnValue = false;
    }
    return false;
}



$(document).ready(function () {
    var userName=$.cookie("userName_cookie");
    $("#userName").val(userName);

    $("input.in").keydown(function(event) {
        if (event.keyCode == 13) {
            stopDefault(event);
            logIn();
        }
    })
    $("input.up").keydown(function(event) {
        if (event.keyCode == 13) {
            stopDefault(event);
            signUp();
        }
    })
})


function initExamList(toUrl) {
    var studentId=localStorage.getItem("schoolId");
    // submitRequest("GET","http://120.79.31.163:8080/exam/student","",true,studentSucess,studentError);
    $.ajax({
        type:"GET",
        url:"http://120.79.31.163:8080/exam/student/"+studentId,
        success:function (data) {
            console.log(data);
            console.log("json="+JSON.stringify(data.content));
           // if(data.content!=null){
               console.log("111");
               $.ajax({
                   url: "postStudentExam",
                   type: "POST",
                   dataType: "json",
                   data: "json="+JSON.stringify(data.content),
                   // data: "json="+JSON.stringify(r),
                   success: function (result) {
                       console.log("success");
                       top.location=toUrl;
                   },
                   error:function () {
                       console.log("error");
                       top.location=toUrl;
                   }

               });
           // }
           // else{
           //     top.location=toUrl;
           // }


        }
    });
}

