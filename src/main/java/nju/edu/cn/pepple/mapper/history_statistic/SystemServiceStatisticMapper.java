package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import nju.edu.cn.pepple.vo.SystemStatisticVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemServiceStatisticMapper {


    int insertSelective(ServiceStatisticVO record);

    ServiceStatisticVO selectByPrimaryKey(Long id);

    List<ServiceStatisticVO> getHourStatistic(@Param("sysName") String sysName,@Param("date") String date);

}