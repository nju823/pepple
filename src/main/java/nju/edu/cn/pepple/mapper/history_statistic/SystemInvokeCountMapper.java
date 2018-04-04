package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.SystemInvokeCountVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemInvokeCountMapper {


    int insertSelective(SystemInvokeCountVO record);

    SystemInvokeCountVO selectByPrimaryKey(Long id);

    List<String> getInvokedSystem(String date);

    List<SystemInvokeCountVO> getStatistic(@Param("date") String date,@Param("system") String system);
}