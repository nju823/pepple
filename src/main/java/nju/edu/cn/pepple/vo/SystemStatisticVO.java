package nju.edu.cn.pepple.vo;

import java.io.Serializable;
import java.util.Date;

public class SystemStatisticVO implements Serializable {
    private Long id;

    private String system;

    private Date date;

    private Integer averageAccessTime;

    private Long errorCount;

    private Long noResponseCount;

    private Long slowCount;

    private Date addTime;

    private Long accessCount;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getAverageAccessTime() {
        return averageAccessTime;
    }

    public void setAverageAccessTime(Integer averageAccessTime) {
        this.averageAccessTime = averageAccessTime;
    }

    public Long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Long errorCount) {
        this.errorCount = errorCount;
    }

    public Long getNoResponseCount() {
        return noResponseCount;
    }

    public void setNoResponseCount(Long noResponseCount) {
        this.noResponseCount = noResponseCount;
    }

    public Long getSlowCount() {
        return slowCount;
    }

    public void setSlowCount(Long slowCount) {
        this.slowCount = slowCount;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Long accessCount) {
        this.accessCount = accessCount;
    }
}