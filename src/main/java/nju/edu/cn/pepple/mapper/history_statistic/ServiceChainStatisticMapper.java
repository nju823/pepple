package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceChainStatisticVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceChainStatisticMapper {

    public ServiceChainStatisticVO selectByPrimaryKey(Long id);

    /**
     * 查询调用的的所有接口
     * @param date
     * @return
     */
    public List<String> getInvokedServices(String date);

    /**
     * 获取一天的统计量
     * @param service
     * @param date
     * @return
     */
    public List<ServiceChainStatisticVO> getStatisticByDate(@Param("service") String service
            , @Param("date") String date);

}