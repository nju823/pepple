
$(document).ready(function () {
    //注意匹配真的学号
    var studentId=localStorage.getItem("schoolId");
    // submitRequest("GET","http://120.79.31.163:8080/exam/student","",true,studentSucess,studentError);
    $.ajax({
        type:"GET",
        url:"http://120.79.31.163:8080/exam/student/"+studentId,
        success:function (data) {
            console.log("json="+JSON.stringify(data.content));
            // var test = "[{\"id\":1,\"questionNum\":1,\"score\":1,\"startTime\":\"2017-12-04 21:05:00\",\"endTime\":\"2017-12-15 08:00:00\",\"courseId\":1,\"teacherId\":\"6661\",\"title\":\"期中考试\",\"description\":\" \",\"teacherName\":\"congye6\",\"courseName\":\"软件工程2\"}," +
            //     "{\"id\":2,\"questionNum\":1,\"score\":1,\"startTime\":\"2017-12-15 21:05:00\",\"endTime\":\"2017-12-16 08:00:00\",\"courseId\":1,\"teacherId\":\"6661\",\"title\":\"期中考试\",\"description\":\" \",\"teacherName\":\"congye6\",\"courseName\":\"软件工程2\"}," +
            //     "{\"id\":3,\"questionNum\":1,\"score\":1,\"startTime\":\"2017-12-02 21:05:00\",\"endTime\":\"2017-12-03 08:00:00\",\"courseId\":1,\"teacherId\":\"6661\",\"title\":\"期中考试\",\"description\":\" \",\"teacherName\":\"congye6\",\"courseName\":\"软件工程2\"}]";
            // var r=eval(test);

            $.ajax({
                url: "postStudentExam",
                type: "POST",
                dataType: "json",
                data: "json="+JSON.stringify(data.content),
                // data: "json="+JSON.stringify(r),
                success: function (result) {

                }
            });
        }
    });
})

// function studentSucess(data) {
//     toastr.success(data.success);
//     toastr.success(data.content);
// }
//
// function studentError() {
//     toastr.error("出错");
// }

$(function () {
    $("#table_local").dataTable({
        //lengthMenu: [5, 10, 20, 30],//这里也可以设置分页，但是不能设置具体内容，只能是一维或二维数组的方式，所以推荐下面language里面的写法。
        paging: true,//分页
        ordering: true,//是否启用排序
        searching: true,//搜索
        language: {
            lengthMenu: '<select class="form-control input-xsmall">' + '<option value="1">1</option>' + '<option value="10">10</option>' + '<option value="20">20</option>' + '<option value="30">30</option>' + '<option value="40">40</option>' + '<option value="50">50</option>' + '</select>条记录',//左上角的分页大小显示。
            search: '<span class="label label-success">搜索：</span>',//右上角的搜索文本，可以写html标签

            paginate: {//分页的样式内容。
                previous: "上一页",
                next: "下一页",
                first: "第一页",
                last: "最后"
            },

            zeroRecords: "没有考试",//table tbody内容为空时，tbody的内容。
            //下面三者构成了总体的左下角的内容。
            info: "总共_PAGES_ 页，显示第_START_ 到第 _END_ ，筛选之后得到 _TOTAL_ 条，初始_MAX_ 条 ",//左下角的信息显示，大写的词为关键字。
            infoEmpty: "0条记录",//筛选为空时左下角的显示。
            infoFiltered: ""//筛选之后的左下角筛选提示，
        },
        paging: true,
        pagingType: "full_numbers",//分页样式的类型

    });
    $("#table_local_filter input[type=search]").css({ width: "auto" });//右上角的默认搜索文本框，不写这个就超出去了。
});

function validatePassword(id,couserName,endTime) {
    var schoolId = localStorage.getItem("schoolId");
    var password = $("#testPassword"+id).val();
    var postData={};
    postData.examId = id;
    postData.studentId = schoolId;
    postData.password = password;
    console.log(id+" "+schoolId+" "+password);
    submitRequest("POST","http://120.79.31.163:8080/exam/student/password/valid",postData,true,validSuccess,validError)

    function validSuccess(data) {
        //这里的密码123要换成真的密码
        // if(data.content){
        console.log(id)
        console.log(data)

        if(data.content){
            localStorage.setItem("studentExamId",id);
            localStorage.setItem("studentCourseName",couserName);
            localStorage.setItem("studentEndTime",endTime);

            var postData = {};
            postData.examId = id;
            // top.location="myExamination.jsp";
            submitRequest("POST","http://120.79.31.163:8080/exam/createPaper",postData,true,getQuestionSuccess,getQuestionError)
        }else{
            toastr.error("考试密码错误");
        }
        }

    function validError(data) {
        toastr.error("出错");
        console.log(data)
        console.log("¥¥")
    }

    }







function getQuestionSuccess(data) {
    console.log(data);
    console.log(data.content);
    // alert(data);
    $.ajax({
        url: "postQuestion",
        type: "POST",
        dataType: "json",
        data: "json="+JSON.stringify(data.content),
        // data: "json="+JSON.stringify(r),
        success: function (result) {
            toastr.success("success");
            console.log(result);
            top.location="myExamination.jsp";
        },error:function () {
            setTimeout(function () {
                top.location="myExamination.jsp";
            },200)
        }
    });
}

function getQuestionError() {
    toastr.error("出错");
}

