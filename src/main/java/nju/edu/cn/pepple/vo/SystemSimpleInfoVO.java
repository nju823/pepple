package nju.edu.cn.pepple.vo;

/**
 * Created by cong on 2018-04-11.
 */
public class SystemSimpleInfoVO {

    private String name;

    private long accessCount;

    private int successPercent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(long accessCount) {
        this.accessCount = accessCount;
    }

    public int getSuccessPercent() {
        return successPercent;
    }

    public void setSuccessPercent(int successPercent) {
        this.successPercent = successPercent;
    }
}
