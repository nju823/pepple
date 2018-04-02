package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceInvokeCountVO;

public interface ServiceInvokeCountDayMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ServiceInvokeCountVO record);

    int insertSelective(ServiceInvokeCountVO record);

    ServiceInvokeCountVO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ServiceInvokeCountVO record);

    int updateByPrimaryKey(ServiceInvokeCountVO record);
}