package nju.edu.cn.pepple.vo;

import java.io.Serializable;
import java.util.Date;

public class ServiceChainStatisticVO extends StatisticVO implements Serializable {
    private Integer id;

    private String service;

    private String rootService;

    private String parentService;

    private Date date;

    private String target;

    private int hour;

    private Date addTime;

    private static final long serialVersionUID = 1L;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    public String getRootService() {
        return rootService;
    }

    public void setRootService(String rootService) {
        this.rootService = rootService == null ? null : rootService.trim();
    }

    public String getParentService() {
        return parentService;
    }

    public void setParentService(String parentService) {
        this.parentService = parentService == null ? null : parentService.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}