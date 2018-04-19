package nju.edu.cn.pepple.vo;

import nju.edu.cn.pepple.util.ScaleUtil;

/**
 * Created by cong on 2018-04-02.
 */
public class StatisticVO {

    protected Integer accessCount=0;

    protected double averageAccessTime=0;

    protected Integer errorCount=0;

    protected Integer noResponseCount=0;

    protected Integer slowCount=0;

    public void add(StatisticVO statisticVO){
        calculateAverage(statisticVO);

        accessCount+=statisticVO.accessCount;
        errorCount+=statisticVO.errorCount;
        noResponseCount+=statisticVO.noResponseCount;
        slowCount+=statisticVO.slowCount;

    }

    private void calculateAverage(StatisticVO statisticVO){
        double countSum=accessCount+statisticVO.accessCount;
        averageAccessTime=this.averageAccessTime*(accessCount/countSum)+statisticVO.averageAccessTime*(statisticVO.accessCount/countSum);
        averageAccessTime= ScaleUtil.scale(averageAccessTime,2);
    }

    public static void main(String[] args){
        StatisticVO v1=new StatisticVO();
        v1.setAccessCount(200);
        v1.setAverageAccessTime(11);
        StatisticVO v2=new StatisticVO();
        v2.setAccessCount(45673);
        v2.setAverageAccessTime(20);
        v1.add(v2);
        System.out.println(v1.averageAccessTime);

    }


    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }

    public double getAverageAccessTime() {
        return averageAccessTime;
    }

    public void setAverageAccessTime(double averageAccessTime) {
        this.averageAccessTime = averageAccessTime;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Integer getNoResponseCount() {
        return noResponseCount;
    }

    public void setNoResponseCount(Integer noResponseCount) {
        this.noResponseCount = noResponseCount;
    }

    public Integer getSlowCount() {
        return slowCount;
    }

    public void setSlowCount(Integer slowCount) {
        this.slowCount = slowCount;
    }
}
