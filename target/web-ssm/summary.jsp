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

    <title>汇总</title>
</head>
<body>
<%@ include file="/navigation.jsp"%>
<script type="text/javascript">
    $(".op").removeClass('active');
    $("#myExamination").addClass('active');
</script>
<div class="container" style="margin-top: 80px">

    <table class="table table-bordered">
        <caption>汇总表格</caption>
        <thead>
        <tr>
            <th>题号</th>
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
                <a href="myExamination.jsp#q<%=i+1%>"> <%=i+1%></a>

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
</div>
</body>

</html>
