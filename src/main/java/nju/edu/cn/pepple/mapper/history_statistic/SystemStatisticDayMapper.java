package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceStatisticVO;
import nju.edu.cn.pepple.vo.SystemStatisticVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SystemStatisticDayMapper {


    int insertSelective(ServiceStatisticVO record);

    ServiceStatisticVO selectByPrimaryKey(Long id);

    List<ServiceStatisticVO> getAllSystemStatistic(String date);

    ServiceStatisticVO getSystemStatistic(@Param("sysName") String sysName,@Param("date") String date);

    List<ServiceStatisticVO> getSystemStatisticWeek(@Param("sysName")String sysName, @Param("start") String start
    ,@Param("end") String end);
}