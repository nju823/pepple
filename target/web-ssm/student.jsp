<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% Date nowDate = new Date(); request.setAttribute("nowDate", nowDate); %>
<%!
    public int before(String time1) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //将字符串形式的时间转化为Date类型的时间
        Date a=sdf.parse(time1);
        Date b=new Date();
        if(a.getTime()-b.getTime()<0)
            return -1;
        else if(a.getTime()-b.getTime()==0)
            return 0;
        else
            return 1;
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <%--<script src="js/particles.js"></script>--%>
    <link href="css/login.css" rel="stylesheet"/>
    <link href="css/toastr.css" rel="stylesheet"/>
    <link href="css/dataTables.bootstrap.css" rel="stylesheet"/>

    <title>我的考试</title>
</head>
<body style="font-family:微软雅黑;">
<%@ include file="/navigation.jsp"%>
<script type="text/javascript">
    $(".op").removeClass('active');
    $("#myExamination").addClass('active');
</script>
<div class="container" style="margin-top: 80px">


    <div class="panel panel-success">
        <div class="panel-heading">
            <div class="panel-title" style="text-align: center">
                考试信息一览表
            </div>
        </div>
        <div class="table-responsive">
            <div class="panel-body">
                <table id="table_local" class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>课程</th>
                        <th>标题</th>
                        <th>描述</th>
                        <th>教师</th>
                        <th>题数</th>
                        <th>分值</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>详情</th>
                    </tr>
                    </thead>

                    <tbody id="staffTable">
                    <c:forEach items="${examList}" var="el" varStatus="status">
                        <tr id="tr${el.id}">
                            <td>${el.courseName}</td>
                            <td>${el.title}</td>
                            <td>${el.description}</td>
                            <td>${el.teacherName}</td>
                            <td>${el.questionNum}</td>
                            <td>${el.score}</td>
                            <td>${el.startTime}</td>
                            <c:set var="studentStartTime" value="${el.startTime}" scope="request"></c:set>
                            <c:set var="studentEndTime" value="${el.endTime}" scope="request"></c:set>
                            <td>${el.endTime}</td>
                            <td>
                                <%String studentStartTime =request.getAttribute("studentStartTime").toString();
                                    String studentEndTime =request.getAttribute("studentEndTime").toString();

                                %>
                                <%
                                if(before(studentStartTime)==-1&&before(studentEndTime)==1){//开始时间早于此刻，结束时间晚于此刻，表示考试进行中
                                %>
                                <button class="btn btn-info btn-xs" data-toggle="modal" data-target="#${el.id}">进行考试</button>
                                <!-- 模态框（Modal） -->
                                <div class="modal fade" id="${el.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="myModalLabel">验证<span style="color: saddlebrown">${el.courseName}--${el.title}</span>的密码</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form method="post" id="testPasswordForm${el.id}">
                                                    <%--<label style="display: inline"></label>--%>
                                                    <input type="text" class="form-control" name="testPassword" id="testPassword${el.id}"  placeholder="请输入考试密码">
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="validatePassword(${el.id},'${el.courseName}','${el.endTime}')">确认</button>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>
                                <%
                                }else if(before(studentEndTime)==-1){//结束时间早于此刻，表示考试已经结束
                                    %>
                                考试结束<br>
                                得分:<span style="color: #007fff;font-weight: 800">${el.grade}</span>分
                                <%
                                }else {
                                    %>
                                尚未开始
                                <%
                                }

                                %>
                               

                            </td>
                        </tr>



                    </c:forEach>






                    <%--</c:forEach>--%>

                    </tbody>

                </table>
            </div>
        </div>

    </div>
</div>
</body>

<script src="js/jquery.dataTables.js"></script>
<script src="js/dataTables.bootstrap.js"></script>
<script src="js/toastr.js"></script>
<script src="js/common.js"></script>
<script src="js/student.js"></script>
</html>
