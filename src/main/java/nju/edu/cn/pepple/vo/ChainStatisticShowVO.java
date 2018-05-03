package nju.edu.cn.pepple.vo;

import java.util.List;

/**
 * Created by cong on 2018-04-25.
 */
public class ChainStatisticShowVO {

    private List<ServiceChainStatisticVO> chain;

    private ServiceChainStatisticVO root;

    public List<ServiceChainStatisticVO> getChain() {
        return chain;
    }

    public void setChain(List<ServiceChainStatisticVO> chain) {
        this.chain = chain;
    }

    public ServiceChainStatisticVO getRoot() {
        return root;
    }

    public void setRoot(ServiceChainStatisticVO root) {
        this.root = root;
    }
}
