package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceStatisticVO;

public interface ServiceStatisticDayMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ServiceStatisticVO record);

    int insertSelective(ServiceStatisticVO record);

    ServiceStatisticVO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ServiceStatisticVO record);

    int updateByPrimaryKey(ServiceStatisticVO record);
}