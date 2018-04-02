package nju.edu.cn.pepple.mapper.history_statistic;

import nju.edu.cn.pepple.vo.ServiceMaxVO;

public interface ServiceMaxMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ServiceMaxVO record);

    int insertSelective(ServiceMaxVO record);

    ServiceMaxVO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ServiceMaxVO record);

    int updateByPrimaryKey(ServiceMaxVO record);
}