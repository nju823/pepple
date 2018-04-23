package nju.edu.cn.pepple.vo;

import java.util.List;

/**
 * Created by cong on 2018-04-23.
 */
public class InvokeCountShowVO {

    private List<String> sysNames;

    private List<SystemInvokeCountVO> counts;

    public List<String> getSysNames() {
        return sysNames;
    }

    public void setSysNames(List<String> sysNames) {
        this.sysNames = sysNames;
    }

    public List<SystemInvokeCountVO> getCounts() {
        return counts;
    }

    public void setCounts(List<SystemInvokeCountVO> counts) {
        this.counts = counts;
    }
}
