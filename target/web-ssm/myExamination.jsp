<%@ page import="com.ts.model.FrontEndQuestion" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ts.model.FronEndAnswer" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <link href="css/myExamination.css" rel="stylesheet"/>
    <link href="css/toastr.css" rel="stylesheet"/>
    <title>考试中</title>
</head>
<body style="font-family:微软雅黑;">
    <%@ include file="/navigation.jsp"%>
    <script type="text/javascript">
        $(".op").removeClass('active');
        $("#myExamination").addClass('active');
    </script>
    <div class="container" style="margin-top: 80px">

        <%
            List<FrontEndQuestion> questionList = (List<FrontEndQuestion>)session.getAttribute("questionList");
        %>
        <div id="testVideo">
            <form id="form1" runat="server">
                <%--<img src="img/touxiang.jpg" width="80%" height="80%" alt="">--%>
                    <video id="video" width="80%" height="80%" autoplay></video>
                    <h3>考试中</h3>
                    <canvas id="canvas" width="80%" height="80%"></canvas>
            </form>
            <div id="test">
                <div class="testinfo">
                    <label>考试科目</label>
                    <span id="courseName">离散数学</span>
                </div>
                <div class="testInfo">
                    <label>考生姓名</label>
                    <span id="userName">张三</span>
                </div>
                <div class="testInfo">
                    <label>时间剩余</label>
                    <span id="timeLeft"></span>
                </div>
                <div id="summary">
                    <button type="button" class="btn btn-success" onclick="testSummary()">汇总</button>
                    <button type="button" class="btn btn-success" onclick="tj()">提交</button>
                </div>
                <%--<button class="btn btn-success btn-block" onclick="goToSummary()" style="width: 84%;margin-top: 20px">汇总</button>--%>
            </div>


        </div>
        <div id="testContent">
            <form method="post" id="testForm">


            <%
                for(int i = 0;i<questionList.size();i++){
                    FrontEndQuestion question = questionList.get(i);
                    List<FronEndAnswer> ansewerList = questionList.get(i).getAnswers();

            %>
            <div class="question" id="q<%=i+1%>">
                <div class="question_head">
                    <span class="question_number_span">题号:
                        <span class="question_number"><%=i+1%></span>
                    </span>
                    <span class="question_mark">
                        <button id="mark_button_<%=i+1%>" type="button" class="btn btn-warning btn-xs" onclick="doMark(<%=i+1%>)">标注</button>
                        <button id="cancel_mark_button_<%=i+1%>" type="button" class="btn btn-danger btn-xs" style="display:none;" onclick="cancelMark(<%=i+1%>)">取消标注</button>
                    </span>
                </div>
                <div><h4 ><%=question.getDescription()%></h4></div>


            <%  if(question.getMulti()){
            %>
                <%--多选题--%>
            <%
                    for(int j = 0;j<ansewerList.size();j++){
                        FronEndAnswer answer = ansewerList.get(j);
            %>
                        <div class="myCheckbox">
                            <label>
                                <input type="checkbox" name="<%=i+1%>" value="<%=answer.getId()%>"
                                <%if(answer.getChosen()){
                                %>
                                    checked
                                    <%
                                }%>

                                >
                                <%=answer.getDescription()%>
                            </label>
                        </div>
            <%
                    }
            %>
            <%
            }else{
            %>
                <%--单选题--%>
            <%
                    for(int j = 0;j<ansewerList.size();j++){
                        FronEndAnswer answer = ansewerList.get(j);
            %>
                        <div class="myRadio">
                            <label>
                                <input type="radio" name="<%=i+1%>" id="optionsRadios1" value="<%=answer.getId()%>"
                                    <%if(answer.getChosen()){
                                %>
                                       checked
                                    <%
                                }%>
                                >
                                <%=answer.getDescription()%>
                            </label>
                        </div>
            <%
                }
            %>
            <%
            }%>

            </div>
            <%
            }
            %>
            </form>
        </div>
    </div>
</body>

<script src="js/toastr.js"></script>
<script src="js/common.js"></script>
<script src="js/myExamination.js"></script>

</html>
