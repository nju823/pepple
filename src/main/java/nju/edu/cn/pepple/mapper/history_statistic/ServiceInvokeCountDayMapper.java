package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceInvokeCountVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceInvokeCountDayMapper {


    int insertSelective(ServiceInvokeCountVO record);

    List<ServiceInvokeCountVO> getInvokeServiceCount(@Param("service") String service,@Param("date") String date);

    List<ServiceInvokeCountVO> getTargetServiceCount(@Param("service") String service,@Param("date") String date);
}