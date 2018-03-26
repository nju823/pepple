package nju.edu.cn.pepple.model;

import java.util.ArrayList;

public class Trace {
    String traceId;
    Log root;
    ArrayList<Log> logs = new ArrayList<Log>();

    public Log getRoot() {
        return root;
    }

    public void setRoot(Log root) {
        this.root = root;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public void setLogs(ArrayList<Log> logs) {
        this.logs = logs;
    }

    public void findRoot(){
        for(int i=0;i<logs.size();i++){
            if(logs.get(i).getParentSpanId() == -1){
                this.root = logs.get(i);
                break;
            }
        }
    }

}
