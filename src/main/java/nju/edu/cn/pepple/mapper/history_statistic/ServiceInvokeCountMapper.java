package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceInvokeCountVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceInvokeCountMapper {

    ServiceInvokeCountVO selectByPrimaryKey(Long id);

    /**
     * 获取某天调用的服务
     * @param date
     * @return
     */
    List<String> getInvokedService(String date);

    /**
     * 获取统计
     * @param date
     * @param service
     * @return
     */
    List<ServiceInvokeCountVO> getStatistic(@Param("date") String date,@Param("service") String service);

}