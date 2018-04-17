package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.vo.InvokeCountVO;
import nju.edu.cn.pepple.vo.SystemInvokeCountVO;

import java.util.List;

/**
 * Created by cong on 2018-04-16.
 */
public interface InvokeCountService {


    public List<SystemInvokeCountVO> getInvokeSystemCount(String system, String date);


    public List<SystemInvokeCountVO> getTargetSystemCount(String system,String date);

}
