package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceChainStatisticVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceChainStatisticDayMapper {
    int insert(ServiceChainStatisticVO record);

    int insertSelective(ServiceChainStatisticVO record);

    List<ServiceChainStatisticVO> getChainStatistic(@Param("root") String root,@Param("date") String date);
}