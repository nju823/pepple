package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import nju.edu.cn.pepple.vo.SystemStatisticVO;

public interface SystemStatisticDayMapper {


    int insertSelective(ServiceStatisticVO record);

    SystemStatisticVO selectByPrimaryKey(Long id);

}