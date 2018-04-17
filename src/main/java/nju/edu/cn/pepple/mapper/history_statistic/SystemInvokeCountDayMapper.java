package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.SystemInvokeCountVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemInvokeCountDayMapper {
    int insertSelective(SystemInvokeCountVO record);

    SystemInvokeCountVO selectByPrimaryKey(Long id);

    List<SystemInvokeCountVO> getInvokeSystemCount(@Param("target") String target,@Param("date") String date);

    List<SystemInvokeCountVO> getTargetSystemCount(@Param("source") String source,@Param("date") String date);
}