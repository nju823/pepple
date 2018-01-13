<%@ page import="com.ts.model.FrontEndQuestion" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ts.model.FronEndAnswer" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <link href="css/index.css" rel="stylesheet"/>
    <link href="css/toastr.css" rel="stylesheet"/>

    <title>考后汇总</title>
</head>
<body>

<h1 style="text-align: center;top:40%">考试结束后汇总</h1>






<div class="container">
    <p>考生姓名：<span id="userName"></span></p>
    <p>考生学号：<span id="studentId"></span></p>
    <p>考试科目：<span id="courseName"></span></p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>题号</th>
            <th>题目内容</th>
            <th>备选答案</th>
            <th>你的选择</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<FrontEndQuestion> questionList = (List<FrontEndQuestion>)session.getAttribute("questionList");
            for(int i = 0;i<questionList.size();i++){
        %>
        <tr>
            <td>
                <%=i+1%>
            </td>
            <td>
                <%=questionList.get(i).getDescription()%>
            </td>
            <td>
                <%
                    FrontEndQuestion question1 = questionList.get(i);
                    List<FronEndAnswer> ansewerList1 = questionList.get(i).getAnswers();
                    for(int j=0;j<ansewerList1.size();j++){

                %>
                <%=ansewerList1.get(j).getDescription()%><br>
                <%

                %>

                <%
                    }
                %>
            </td>
            <td>
                <%
                    FrontEndQuestion question = questionList.get(i);
                    List<FronEndAnswer> ansewerList = questionList.get(i).getAnswers();
                    for(int j=0;j<ansewerList.size();j++){
                        if(ansewerList.get(j).getChosen()){
                %>
                <%=ansewerList.get(j).getDescription()%><br>
                <%
                    }
                %>

                <%
                    }
                %>

            </td>
        </tr>
        <%}
        %>

        </tbody>
    </table>


    <div id="testContent" style="padding:15px;background: #f3f3f3">
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
                        <input type="checkbox" name="<%=i+1%>" value="<%=answer.getId()%>" disabled
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
                        <input type="radio" name="<%=i+1%>" id="optionsRadios1" value="<%=answer.getId()%>" disabled
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
<script src="js/finish.js"></script>
</html>
