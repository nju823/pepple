package nju.edu.cn.pepple.vo;

/**
 * Created by cong on 2018-04-02.
 */
public class StatisticVO {

    protected Integer accessCount;

    protected Integer averageAccessTime;

    protected Integer errorCount;

    protected Integer noResponseCount;

    protected Integer slowCount;

    public void add(StatisticVO statisticVO){
        calculateAverage(statisticVO);

        accessCount+=statisticVO.accessCount;
        errorCount+=statisticVO.errorCount;
        noResponseCount+=statisticVO.noResponseCount;
        slowCount+=statisticVO.slowCount;

    }

    private void calculateAverage(StatisticVO statisticVO){
        double countSum=accessCount+statisticVO.accessCount;
        double averageAccessTime=this.averageAccessTime*(accessCount/countSum)+statisticVO.averageAccessTime*(statisticVO.accessCount/countSum);
        this.averageAccessTime=(int)averageAccessTime;
    }


    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }

    public Integer getAverageAccessTime() {
        return averageAccessTime;
    }

    public void setAverageAccessTime(Integer averageAccessTime) {
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
