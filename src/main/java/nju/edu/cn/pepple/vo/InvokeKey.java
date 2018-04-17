package nju.edu.cn.pepple.vo;

import javafx.beans.binding.ObjectExpression;

/**
 * Created by cong on 2018-04-17.
 */
public class InvokeKey {

    private String source;

    private String target;

    public InvokeKey(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public int hashCode(){
        return source.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null)
            return false;
        InvokeKey key=(InvokeKey)obj;
        return source.equals(key.getSource())&&target.equals(key.getTarget());
    }

}
