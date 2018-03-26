package nju.edu.cn.pepple.dto;

public class searchDto {

    private String startTime;
    private String endTime;
    private String logServiceName;
    private String logServiceUrl;
    private String logSpanId;
    private String logTraceId;
    private String logParam;
    private String [] systems;
    private int [] types;

    public String[] getSystems() {
        return systems;
    }

    public void setSystems(String[] systems) {
        this.systems = systems;
    }

    public int[] getTypes() {
        return types;
    }

    public void setTypes(int[] types) {
        this.types = types;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLogServiceName() {
        return logServiceName;
    }

    public void setLogServiceName(String logServiceName) {
        this.logServiceName = logServiceName;
    }

    public String getLogServiceUrl() {
        return logServiceUrl;
    }

    public void setLogServiceUrl(String logServiceUrl) {
        this.logServiceUrl = logServiceUrl;
    }

    public String getLogSpanId() {
        return logSpanId;
    }

    public void setLogSpanId(String logSpanId) {
        this.logSpanId = logSpanId;
    }

    public String getLogTraceId() {
        return logTraceId;
    }

    public void setLogTraceId(String logTraceId) {
        this.logTraceId = logTraceId;
    }

    public String getLogParam() {
        return logParam;
    }

    public void setLogParam(String logPara) {
        this.logParam = logPara;
    }
}
