package nju.edu.cn.pepple.vo;

import java.io.Serializable;
import java.util.Date;

public class SystemInvokeCountVO implements Serializable {
    private Long id;

    private String sourceSystem;

    private String targetSystem;

    private Date invokeDate;

    private int invokeHour;

    private Long invokeCount;

    private Date addTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getInvokeHour() {
        return invokeHour;
    }

    public void setInvokeHour(int invokeHour) {
        this.invokeHour = invokeHour;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem == null ? null : sourceSystem.trim();
    }

    public String getTargetSystem() {
        return targetSystem;
    }

    public void setTargetSystem(String targetSystem) {
        this.targetSystem = targetSystem == null ? null : targetSystem.trim();
    }

    public Date getInvokeDate() {
        return invokeDate;
    }

    public void setInvokeDate(Date invokeDate) {
        this.invokeDate = invokeDate;
    }

    public Long getInvokeCount() {
        return invokeCount;
    }

    public void setInvokeCount(Long invokeCount) {
        this.invokeCount = invokeCount;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}