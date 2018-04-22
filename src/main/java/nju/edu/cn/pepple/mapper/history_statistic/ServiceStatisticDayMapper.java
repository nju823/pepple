package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceStatisticDayMapper {


    int insert(ServiceStatisticVO record);

    int insertSelective(ServiceStatisticVO record);

    ServiceStatisticVO selectByPrimaryKey(Long id);

    List<ServiceStatisticVO> getStatisticBySystem(@Param("date") String date,@Param("system") String system);

    List<ServiceStatisticVO> getSystemServiceStatistic(@Param("sysName") String sysName,@Param("date") String date);

    ServiceStatisticVO getServiceStatistic(@Param("service") String service,@Param("date") String date);

    List<ServiceStatisticVO> getServiceStatisticBetween(@Param("service") String service,
                                                 @Param("start") String start,@Param("end") String end);

}