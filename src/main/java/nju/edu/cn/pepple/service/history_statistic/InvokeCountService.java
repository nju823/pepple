package nju.edu.cn.pepple.service.history_statistic;

import nju.edu.cn.pepple.vo.InvokeCountShowVO;
import nju.edu.cn.pepple.vo.InvokeCountVO;
import nju.edu.cn.pepple.vo.ServiceInvokeCountVO;
import nju.edu.cn.pepple.vo.SystemInvokeCountVO;

import java.util.List;

/**
 * Created by cong on 2018-04-16.
 */
public interface InvokeCountService {


    public List<SystemInvokeCountVO> getInvokeSystemCount(String system, String date);


    public List<SystemInvokeCountVO> getTargetSystemCount(String system,String date);

    public List<ServiceInvokeCountVO> getInvokeServiceCount(String service, String date);

    public List<ServiceInvokeCountVO> getTargetServiceCount(String service,String date);

    public InvokeCountShowVO getSystemCount(String date);

}
