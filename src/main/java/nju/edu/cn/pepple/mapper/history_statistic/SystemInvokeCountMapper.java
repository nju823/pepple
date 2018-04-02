package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.SystemInvokeCountVO;

public interface SystemInvokeCountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemInvokeCountVO record);

    int insertSelective(SystemInvokeCountVO record);

    SystemInvokeCountVO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemInvokeCountVO record);

    int updateByPrimaryKey(SystemInvokeCountVO record);
}