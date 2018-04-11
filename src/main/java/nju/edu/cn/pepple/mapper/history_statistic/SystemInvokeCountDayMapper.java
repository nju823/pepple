package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.SystemInvokeCountVO;

public interface SystemInvokeCountDayMapper {
    int insertSelective(SystemInvokeCountVO record);

    SystemInvokeCountVO selectByPrimaryKey(Long id);

}