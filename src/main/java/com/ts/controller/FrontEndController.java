package com.ts.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ts.model.FronEndAnswer;
import com.ts.model.FrontEndQuestion;
import com.ts.model.FrontEndStudentExam;
import com.ts.model.MyTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 前端控制器
 */
@Controller
public class FrontEndController {

    /**
     * 把js获得的json丢到这里处理，然后存在session里
     * @param request
     * @param response
     * @param session
     */
    @RequestMapping("/postStudentExam")
    public String postStudentExam(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String str = request.getParameter("json");
        List<FrontEndStudentExam> examList = JSON.parseArray(str, FrontEndStudentExam.class);
        session.setAttribute("examList",examList);
        PrintWriter out = response.getWriter();
        out.write("yes");
        out.close();
        return null;


//        testQQ(session);
//        testT();
    }

    @RequestMapping("/postQuestion")
    public void postQuestion(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException {
        String str = request.getParameter("json");
        System.out.println(str+"!!");
        List<FrontEndQuestion> questionList = JSON.parseArray(str, FrontEndQuestion.class);
        for(FrontEndQuestion q: questionList){
            System.out.println("q: "+q.getDescription()+" "+q.getMulti());
            for(FronEndAnswer a : q.getAnswers()){
                System.out.println("a: "+a.getId()+" "+a.getChosen());
            }
        }
        session.setAttribute("questionList",questionList);

    }




    public void testQQ(HttpSession session){
        System.out.println("testQQQ");
        String json = "[\n" +
                "            {\n" +
                "         \"id\": 3,\n" +
                "         \"description\": \"下列程序段执行后t3的结果是（）。\\nint t1=2, t2=3, t3;\\nt3=t1<t2?t1:(t2+t1);\",\n" +
                "         \"courseId\": 1,\n" +
                "         \"isMulti\": true,\n" +
                "         \"answers\":          [\n" +
                "                        {\n" +
                "               \"id\": 1,\n" +
                "               \"description\": \"1\",\n" +
                "               \"questionId\": 3,\n" +
                "               \"isRight\": true\n" +
                "            },\n" +
                "                        {\n" +
                "               \"id\": 3,\n" +
                "               \"description\": \"3\",\n" +
                "               \"questionId\": 3,\n" +
                "               \"isRight\": true\n" +
                "            },\n" +
                "                        {\n" +
                "               \"id\": 2,\n" +
                "               \"description\": \"2\",\n" +
                "               \"questionId\": 3,\n" +
                "               \"isRight\": false\n" +
                "            },\n" +
                "                        {\n" +
                "               \"id\": 4,\n" +
                "               \"description\": \"4\",\n" +
                "               \"questionId\": 3,\n" +
                "               \"isRight\": false\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "            {\n" +
                "         \"id\": 4,\n" +
                "         \"description\": \"不考虑反射，String类型变量所指向内存空间中的内容是不能被改变的 。 （ ）\",\n" +
                "         \"courseId\": 1,\n" +
                "         \"isMulti\": false,\n" +
                "         \"answers\":          [\n" +
                "                        {\n" +
                "               \"id\": 9,\n" +
                "               \"description\": \"5\",\n" +
                "               \"questionId\": 4,\n" +
                "               \"isRight\": false\n" +
                "            },\n" +
                "                        {\n" +
                "               \"id\": 7,\n" +
                "               \"description\": \"2\",\n" +
                "               \"questionId\": 4,\n" +
                "               \"isRight\": false\n" +
                "            },\n" +
                "                        {\n" +
                "               \"id\": 8,\n" +
                "               \"description\": \"4\",\n" +
                "               \"questionId\": 4,\n" +
                "               \"isRight\": false\n" +
                "            },\n" +
                "                        {\n" +
                "               \"id\": 5,\n" +
                "               \"description\": \"1\",\n" +
                "               \"questionId\": 4,\n" +
                "               \"isRight\": false\n" +
                "            },\n" +
                "                        {\n" +
                "               \"id\": 6,\n" +
                "               \"description\": \"2\",\n" +
                "               \"questionId\": 4,\n" +
                "               \"isRight\": true\n" +
                "            }\n" +
                "         ]\n" +
                "      }\n" +
                "   ]";
        List<FrontEndQuestion> questionList = JSON.parseArray(json, FrontEndQuestion.class);
        for(FrontEndQuestion q: questionList){
            System.out.println("q: "+q.getDescription()+" "+q.getMulti());
            for(FronEndAnswer a : q.getAnswers()){
                System.out.println("a: "+a.getDescription()+" "+a.getRight());
            }
        }
        session.setAttribute("questionList",questionList);

    }


    public void testT(){
        System.out.println("testT");
        String json="[{\"id\":1,\"is\":true},{\"id\":2,\"is\":false}]";
        List<MyTest> list = JSON.parseArray(json,MyTest.class);
        for(MyTest t:list)
            System.out.println(t.getId()+"&&"+t.isIs());
    }

    @RequestMapping("/doSummary")
    public void doSummary(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException {
        List<FrontEndQuestion> questionList = (List<FrontEndQuestion>)session.getAttribute("questionList");

//        List<FrontEndQuestion> newQuestionList = new ArrayList<FrontEndQuestion>();

       int sum = Integer.parseInt(request.getParameter("sum"));
        for(int i = 1;i<sum;i++){
            List<FronEndAnswer> answerList = questionList.get(i-1).getAnswers();
//            List<FronEndAnswer> newAnswerList = new ArrayList<FronEndAnswer>();
            //每道题所选的答案的id
            String [] answers = request.getParameter(""+i).split(",");

            for(int j = 0;j<answerList.size();j++){
                FronEndAnswer fronEndAnswer = answerList.get(j);
                fronEndAnswer.setIsChosen(false);
                if(choose(fronEndAnswer.getId(),answers)){
                    fronEndAnswer.setIsChosen(true);
                }
//                newAnswerList.add(fronEndAnswer);

            }//enf inter for



        }//end outer for

        System.out.println("新的-------------------");
        for(FrontEndQuestion q: questionList){
            System.out.println("q: "+q.getDescription()+" "+q.getMulti());
            for(FronEndAnswer a : q.getAnswers()){
                System.out.println("a: "+a.getId()+" "+a.getChosen());
            }
        }
        session.setAttribute("questionList",questionList);
        String json = JSON.toJSONString(questionList);
        System.out.println(json+"!!");

//        String site = new String("/summary.jsp");
//        response.setStatus(response.SC_MOVED_TEMPORARILY);
//        response.setHeader("Location", site);
//        return "summary.jsp";

    }

    //判断答案是否被选择
    private boolean choose(int id, String[] answers) {
        String index = id+"";
        boolean isIn=false;
        for(int i=0;i<answers.length;i++){
            if(index.equals(answers[i])){
                isIn=true;
                break;
            }
        }
        return isIn;
    }


    /**
     * 获得最终 json
     * @param request
     * @param response
     * @param session
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/getFinishedJson")
    public void getFinishedJson(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        List<FrontEndQuestion> questionList = (List<FrontEndQuestion>)session.getAttribute("questionList");


        String s = request.getParameter("studentId");
        int examId = Integer.parseInt(request.getParameter("examId"));


        int studentId = Integer.parseInt(s);
        String json="{\"examId\":"+examId+",\"studentId\":\""+s+"\",\"questions\":[";
        for(int i = 0;i < questionList.size();i++){
            FrontEndQuestion q = questionList.get(i);
            json+="{";
            json+="\"questionNumber\":"+(i+1)+",";
            json+="\"answers\":[";


            List<FronEndAnswer> fronEndAnswer = questionList.get(i).getAnswers();
            for(int j = 0;j<fronEndAnswer.size();j++){
                FronEndAnswer a = fronEndAnswer.get(j);
                json+="{";
                json+="\"description\":\""+a.getDescription()+"\",";
                json+="\"id\":"+a.getId()+",";
                json+="\"isChoose\":"+a.getChosen()+",";
                json+="\"isRight\":"+a.getRight()+",";
                json+="\"questionId\":"+q.getId()+"}";
                if(j!=fronEndAnswer.size()-1){
                    json+=",";
                }else{
                    json+="],";
                }
            }

            json+="\"description\":\""+solveHH(q.getDescription())+"\",";
            json+="\"id\":"+q.getId()+"}";

            if(i!=questionList.size()-1){
                json+=",";
            }else{
                json+="]}";
            }


        }

        System.out.println("--------------");
        System.out.println(json);


        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(json);
        out.close();


    }

    /**
     * 解决json换行问题
     * @param s
     * @return
     */
    public String solveHH(String s){
        String r="";
        for(int i = 0;i<s.length();i++){
            if(s.substring(i,i+1).equals("\n")){
                r+="\\n";
            }else{
                r+=s.substring(i,i+1);
            }
        }
        return r;
    }



    }
