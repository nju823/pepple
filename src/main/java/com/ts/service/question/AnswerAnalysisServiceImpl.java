package com.ts.service.question;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class AnswerAnalysisServiceImpl implements AnswerAnalysisService {

    /**
     * 将字符串转化为选项列表
     * @param s
     * @return
     */
    @Override
    public List<String> getAnswer(String s) {
        String[] formerArr = s.split("@@");
        int size = formerArr.length;
        System.out.println(size);
        List<String> answerList = new ArrayList<String>();

        //只有一个答案
        if(size == 1){
            answerList.add(formerArr[0]);
            return answerList;
        }
        //多个答案乱序输出
        else {
            Random random = new Random();
            for (int i=0;i<size;i++) {
                int p = random.nextInt(size);
                String temp = formerArr[i];
                formerArr[i] = formerArr[p];
                formerArr[p] = temp;
            }
            for(int i=0;i<size;i++){
                answerList.add(formerArr[i]);
            }
            System.out.println(answerList);
            return answerList;
        }

    }

    /**
     * 选项列表拼接成字符串
     * @param list
     * @return
     */
    @Override
    public String getAnswer(List<String> list) {
        int size = list.size();
        String result = "";
        if (size == 1) return list.get(0);
        else {
            for (int i=0;i<size;i++) {
                result += list.get(i) + "@@" ;
            }
            result = result.substring(0, result.length()-2);
        }
        return result;
    }

    public static void main(String[] args) {
        AnswerAnalysisServiceImpl aasi = new AnswerAnalysisServiceImpl();
        String a = "2@@4@@5@@6";
        List<String> list = aasi.getAnswer(a);
        System.out.println(list.toString());
        System.out.println(aasi.getAnswer(list));
    }
}
