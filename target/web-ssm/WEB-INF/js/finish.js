$(document).ready(function () {
    $("#userName").text(localStorage.getItem("name"));
    $("#courseName").text(localStorage.getItem("studentCourseName"));
    $("#studentId").text(localStorage.getItem("schoolId"));
    // console.log(localStorage.getItem("name"))
})