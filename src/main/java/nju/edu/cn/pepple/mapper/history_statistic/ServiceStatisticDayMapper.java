package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceStatisticDayMapper {


    int insert(ServiceStatisticVO record);

    int insertSelective(ServiceStatisticVO record);

    ServiceStatisticVO selectByPrimaryKey(Long id);

    List<ServiceStatisticVO> getSystemServiceStatistic(@Param("sysName") String sysName,@Param("date") String date);


}