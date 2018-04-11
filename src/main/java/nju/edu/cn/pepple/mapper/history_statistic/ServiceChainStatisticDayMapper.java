package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceChainStatisticVO;

public interface ServiceChainStatisticDayMapper {
    int insert(ServiceChainStatisticVO record);

    int insertSelective(ServiceChainStatisticVO record);
}