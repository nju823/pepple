var classesInfo = [];
$(document).ready(function(){


    loadUserInfo();

    loadClassInfo();

  //创建课程
  $("#create_class_btn").click(function () {
    var className =  $("#class_name_input").val();
    var clasDescription = $("#class_description_input").val();

    if(className != "" && className.length>10) {
      alert("错误的课程名称");
    }

    var postData = {};
    postData.name = className;
    postData.description = clasDescription;
    postData.ownerId = localStorage.getItem("schoolId");

    submitRequest("POST","http://120.79.31.163:8080/course/add",postData,true,
        function (data) {
            alert("创建成功");
            //刷新数据
            loadClassInfo();
        },
        function (data) {
            alert("通信异常");
        });

  });

    $(document).on("click",".edit_exam",function(e){
        //输入验证
        localStorage.setItem("classInfo",JSON.stringify(classesInfo[Number(e.target.id)]));
        top.location="teacher_exam_edit.jsp";

    });

});

function loadClassInfo() {
    $(".class_container").html("<div><span class=title>我的课程</span></div>");
    submitRequest("GET","http://120.79.31.163:8080/course/teacher/"+localStorage.getItem("schoolId"),null,true,
        function (data) {
            var classes = data.content;
            classesInfo = classes;
            for(var i =0;i<classes.length;i++){
                $(".class_container").append(
                    "<div class='class_info content'><div class='class_name'><span style='font-size:18px;'>"+classes[i].name+"</span><br><span>"+classes[i].ownerId+"</span></div>" +
                    "<div class='class_des_owner'>描述:  "+classes[i].description+"" +
                    "<img class='edit_exam' id='"+i+"' src='img/examIcon.png'></img></div>");
            }
        },function (data) {
            alert("通信异常");
        });
//如果没有课程
}

function loadUserInfo() {
    $("#user_name").val(localStorage.getItem("name"));
    $("#user_email").val(localStorage.getItem("email"));
    $("#user_id").val(localStorage.getItem("schoolId"));
    $("#name_title").html(localStorage.getItem("name"));
}
