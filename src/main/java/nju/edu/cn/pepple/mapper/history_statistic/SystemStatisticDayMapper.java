package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import nju.edu.cn.pepple.vo.SystemStatisticVO;

import java.util.List;

public interface SystemStatisticDayMapper {


    int insertSelective(ServiceStatisticVO record);

    ServiceStatisticVO selectByPrimaryKey(Long id);

    List<ServiceStatisticVO> getAllSystemStatistic(String date);
}