package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import nju.edu.cn.pepple.vo.StatisticVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceStatisticMapper {


    ServiceStatisticVO selectByPrimaryKey(Long id);

    List<String> getInvokedServices(String date);

    List<String> getInvokedSystem(String date);

    List<ServiceStatisticVO> getStatistic(@Param("date") String date,@Param("service") String service);

    List<ServiceStatisticVO> getStatisticBySystem(@Param("date") String date,@Param("system") String system);
}