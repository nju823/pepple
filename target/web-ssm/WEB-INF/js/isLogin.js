$(document).ready(function () {
    if(localStorage.getItem("isLogin")=="0"){
        top.location="index.jsp";
    }
})