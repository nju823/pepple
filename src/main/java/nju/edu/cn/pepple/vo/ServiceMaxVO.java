package nju.edu.cn.pepple.vo;

import java.io.Serializable;
import java.util.Date;

public class ServiceMaxVO implements Serializable {
    private Long id;

    private String service;

    private String system;

    private Date date;

    private Long accessCount;

    private String accessCountSecond;

    private Long averageAccessTime;

    private String averageAccessTimeSecond;

    private Integer errorCount;

    private String errorCountSecond;

    private Integer noResponseCount;

    private String noResponseCountSecond;

    private Integer slowCount;

    private String slowCountSecond;

    private Date addTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system == null ? null : system.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Long accessCount) {
        this.accessCount = accessCount;
    }

    public String getAccessCountSecond() {
        return accessCountSecond;
    }

    public void setAccessCountSecond(String accessCountSecond) {
        this.accessCountSecond = accessCountSecond == null ? null : accessCountSecond.trim();
    }

    public Long getAverageAccessTime() {
        return averageAccessTime;
    }

    public void setAverageAccessTime(Long averageAccessTime) {
        this.averageAccessTime = averageAccessTime;
    }

    public String getAverageAccessTimeSecond() {
        return averageAccessTimeSecond;
    }

    public void setAverageAccessTimeSecond(String averageAccessTimeSecond) {
        this.averageAccessTimeSecond = averageAccessTimeSecond == null ? null : averageAccessTimeSecond.trim();
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public String getErrorCountSecond() {
        return errorCountSecond;
    }

    public void setErrorCountSecond(String errorCountSecond) {
        this.errorCountSecond = errorCountSecond == null ? null : errorCountSecond.trim();
    }

    public Integer getNoResponseCount() {
        return noResponseCount;
    }

    public void setNoResponseCount(Integer noResponseCount) {
        this.noResponseCount = noResponseCount;
    }

    public String getNoResponseCountSecond() {
        return noResponseCountSecond;
    }

    public void setNoResponseCountSecond(String noResponseCountSecond) {
        this.noResponseCountSecond = noResponseCountSecond == null ? null : noResponseCountSecond.trim();
    }

    public Integer getSlowCount() {
        return slowCount;
    }

    public void setSlowCount(Integer slowCount) {
        this.slowCount = slowCount;
    }

    public String getSlowCountSecond() {
        return slowCountSecond;
    }

    public void setSlowCountSecond(String slowCountSecond) {
        this.slowCountSecond = slowCountSecond == null ? null : slowCountSecond.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}